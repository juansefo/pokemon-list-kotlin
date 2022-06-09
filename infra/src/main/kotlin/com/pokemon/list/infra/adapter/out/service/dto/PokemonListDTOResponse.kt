package com.pokemon.list.infra.adapter.out.service.dto

class PokemonListDTOResponse(val count : Int,
                             val next : String,
                             val previous :String?,
                             val results : List<PokemonSortDTOResponse>)