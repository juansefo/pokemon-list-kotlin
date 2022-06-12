package com.pokemon.list.app.handler

import com.pokemon.list.app.query.GetPokemonList
import com.pokemon.list.domain.aggregate.Pagination
import com.pokemon.list.domain.entity.Pokemon
import com.pokemon.list.domain.ports.PokemonService
import com.pokemon.list.domain.vo.ItemPerPage
import com.pokemon.list.domain.vo.Page
import org.reactivestreams.Publisher
import reactor.core.publisher.Mono

class ListPokemonHandler(private val pokemonService: PokemonService) : Handler<GetPokemonList, List<Pokemon>>() {

    override fun execute(query: GetPokemonList): Publisher<List<Pokemon>> =
        Mono.just(
            Pagination(
                ItemPerPage(query.itemsPerPages),
                Page(query.page)
            )
        )
            .flux()
            .flatMap(pokemonService::listPokemons)

}