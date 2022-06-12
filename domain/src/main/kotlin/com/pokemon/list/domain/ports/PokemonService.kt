package com.pokemon.list.domain.ports

import com.pokemon.list.domain.aggregate.Pagination
import com.pokemon.list.domain.entity.Pokemon
import com.pokemon.list.domain.vo.Id
import org.reactivestreams.Publisher

interface PokemonService {

    fun listPokemons(pagination: Pagination): Publisher<List<Pokemon>>

    fun getPokemon(id: Id) : Publisher<Pokemon>

}