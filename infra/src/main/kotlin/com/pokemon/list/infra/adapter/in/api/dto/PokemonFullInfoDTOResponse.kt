package com.pokemon.list.infra.adapter.`in`.api.dto

import com.pokemon.list.domain.entity.Pokemon
import com.pokemon.list.domain.vo.*
import java.util.stream.Collectors

data class PokemonFullInfoDTOResponse (
    val id: String,
    val name: String,
    val weight: Int,
    val height: Int,
    val baseExperience: Int
): Response {

    companion object {
        fun fromEntity(
            pokemon: Pokemon
        ): Response = PokemonFullInfoDTOResponse(
            pokemon.id.value,
            pokemon.name.value,
            pokemon.weight.value,
            pokemon.height.value,
            pokemon.baseExperience.value
        )

    }
}