package com.pokemon.list.infra.adapter.`in`.api

import com.pokemon.list.app.handler.GetPokemonHandler
import com.pokemon.list.app.handler.ListPokemonHandler
import com.pokemon.list.app.query.GetPokemon
import com.pokemon.list.app.query.GetPokemonList
import com.pokemon.list.domain.exception.PokemonException
import com.pokemon.list.infra.adapter.`in`.api.dto.PokemonFullInfoDTOResponse
import com.pokemon.list.infra.adapter.`in`.api.dto.PokemonListDTOResponse
import com.pokemon.list.infra.adapter.`in`.api.dto.Response
import com.pokemon.list.infra.adapter.`in`.api.util.ErrorHandler
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@RestController
@RequestMapping("/pokemon")
class PokemonApi (val listPokemonHandler: ListPokemonHandler, val getPokemonHandler: GetPokemonHandler){

    @GetMapping("/list")
    fun listPokemons(@RequestParam(value = "itemsPerPages") itemsPerPages: Int,
                      @RequestParam(value = "page") page: Int): Mono<ResponseEntity<Response>> {
        return listPokemonHandler.execute(GetPokemonList(itemsPerPages, page))
            .toMono()
            .map { list -> PokemonListDTOResponse.fromList(list) }
            .map { updatedCat -> ResponseEntity.ok(updatedCat) }
            .onErrorResume( PokemonException::class.java) { err -> errorHandling(err) }
            .defaultIfEmpty(ResponseEntity.notFound().build())
    }

    @GetMapping("/{id}")
    fun getPokemon(@PathVariable(value = "id") id: Int): Mono<ResponseEntity<Response>> {
        return getPokemonHandler.execute(GetPokemon(id))
            .toMono()
            .map { pokemon -> PokemonFullInfoDTOResponse.fromEntity(pokemon) }
            .map { updatedCat -> ResponseEntity.ok(updatedCat) }
            .onErrorResume( PokemonException::class.java) { err -> errorHandling(err) }
            .defaultIfEmpty(ResponseEntity.notFound().build())
    }

    fun errorHandling(error: PokemonException): Mono<ResponseEntity<Response>> {
        return Mono.just(ErrorHandler.mapError(error))
    }

}