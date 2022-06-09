package com.pokemon.list.infra.adapter.out.service.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class PokemonFullInformationResponse (@JsonProperty("id") val id: Int,
                                           @JsonProperty("name") val name: String,
                                           @JsonProperty("height") val height: Int,
                                           @JsonProperty("weight") val weight: Int,
                                           @JsonProperty("base_experience") val baseExperience: Int)