package com.pokemon.list.infra.adapter.`in`.api.dto

import com.pokemon.list.domain.entity.Pokemon
import java.util.stream.Collectors

data class PokemonListDTOResponse (val pokemons: List<PokemonInfoDTOResponse>) : Response{

    companion object {
        fun fromList(list: List<Pokemon>
        ): Response =PokemonListDTOResponse(list.stream().map { pokemon-> PokemonInfoDTOResponse(pokemon.id.value,pokemon.name.value) }.collect(Collectors.toList()))

    }
}