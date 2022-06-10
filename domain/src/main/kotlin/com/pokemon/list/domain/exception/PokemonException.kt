package com.pokemon.list.domain.exception

data class PokemonException(val code: Int, override val message : String) : Exception(){

}