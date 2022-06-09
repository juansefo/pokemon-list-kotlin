package com.pokemon.list.domain


    fun main(){
        print("https://pokeapi.co/api/v2/pokemon/1/".replace(Regex(".+/(\\d+)/"),"$1"))
    }
