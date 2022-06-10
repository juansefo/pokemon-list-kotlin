package com.pokemon.list.domain.entity

import com.pokemon.list.domain.vo.*

data class Pokemon(
    val id: Id,
    val name: Name,
    val weight: Weight = Weight(0),
    val height: Height = Height(0),
    val baseExperience: BaseExperience = BaseExperience(0)
) {

    companion object {
        fun pokemonResume(
            url: String,
            name: String
        ): Pokemon =
            Pokemon(Id.fromUrl(url), Name(name))

        fun pokemonFullInformation(
            id: Int,
            name: String,
            weight: Int,
            height: Int,
            baseExperience: Int
        ): Pokemon =
            Pokemon(Id.fromInt(id), Name(name), Weight(weight), Height(height), BaseExperience(baseExperience))

    }
}