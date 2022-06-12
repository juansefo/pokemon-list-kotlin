package com.pokemon.list.app.handler

import com.pokemon.list.app.query.GetPokemon
import com.pokemon.list.domain.entity.Pokemon
import com.pokemon.list.domain.ports.PokemonService
import com.pokemon.list.domain.vo.Id
import org.reactivestreams.Publisher
import reactor.core.publisher.Mono

class GetPokemonHandler(private val pokemonService: PokemonService) : Handler<GetPokemon, Pokemon>() {

    override fun execute(query: GetPokemon): Publisher<Pokemon> =
        Mono.just(
            Id.fromInt(query.id)
        )
            .flux()
            .flatMap(pokemonService::getPokemon)

}