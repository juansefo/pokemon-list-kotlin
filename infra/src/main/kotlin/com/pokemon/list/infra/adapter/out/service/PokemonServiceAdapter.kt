package com.pokemon.list.infra.adapter.out.service

import com.pokemon.list.domain.aggregate.Pagination
import com.pokemon.list.domain.entity.Pokemon
import com.pokemon.list.domain.service.PokemonService
import com.pokemon.list.domain.vo.Id
import io.netty.handler.codec.http.HttpResponseStatus
import org.reactivestreams.Publisher
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import reactor.netty.http.client.HttpClient
import reactor.netty.http.client.HttpClient.ResponseReceiver
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.pokemon.list.domain.exception.PokemonException
import com.pokemon.list.infra.adapter.out.service.dto.PokemonFullInformationResponse
import com.pokemon.list.infra.adapter.out.service.dto.PokemonListDTOResponse
import mu.KotlinLogging
import reactor.core.scheduler.Schedulers
import java.util.stream.Collectors
import kotlin.reflect.KClass

class PokemonServiceAdapter(private val httpClient: HttpClient) : PokemonService {

    private val logger = KotlinLogging.logger {}

    override fun listPokemons(pagination: Pagination): Publisher<List<Pokemon>> {

        return httpClient
            .get()
            .uri(
                Constants.BASE_PATH_URL.plus(
                    Constants.GET_POKEMON_LIST_PATH_URL.format(
                        pagination.page.value,
                        pagination.itemPerPage.value
                    )
                )
            )
            .toMono()
            .subscribeOn(Schedulers.boundedElastic())
            .flatMap { response -> processResponse(PokemonListDTOResponse::class, response) }
            .map { pokemonResponse -> pokemonResponse.results
                .stream()
                .map { pokemonDto-> Pokemon.pokemonResume(pokemonDto.url, pokemonDto.name) }
                .collect(Collectors.toList())
            }

    }

    override fun getPokemon(id: Id): Publisher<Pokemon> {

        println(Constants.BASE_PATH_URL.plus(Constants.PATH_URL.format(id.value)))

        return httpClient
            .get()
            .uri(Constants.BASE_PATH_URL.plus(Constants.PATH_URL.format(id.value)))
            .toMono()
            .subscribeOn(Schedulers.boundedElastic())
            .flatMap { response -> processResponse(PokemonFullInformationResponse::class, response) }
            .map { pokemonDto ->
                Pokemon
                    .pokemonFullInformation(
                        pokemonDto.id,
                        pokemonDto.name,
                        pokemonDto.weight,
                        pokemonDto.height,
                        pokemonDto.baseExperience
                    )
            }
    }

    private fun <T : Any> processResponse(clazz: KClass<T>, response: ResponseReceiver<*>): Mono<T> {

        return response.responseSingle { httpClientResponse, byteBufMono ->
            httpClientResponse.toMono()
                .filter { res -> res.status().code() == HttpResponseStatus.OK.code() }
                .flatMap {
                    byteBufMono.asString().map { body -> jacksonObjectMapper().readValue(body, clazz.java) }
                }
                .onErrorResume { err ->
                    logger.error { "Error Calling Pokemon Service {}".format(err.message) }
                    Mono.error(PokemonException(500,"Error with Pokemon Service"))
                }

        }
    }

}