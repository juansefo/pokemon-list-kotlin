package com.pokemon.list.domain.vo

data class Id(val value: String){

    companion object {
        fun fromUrl(url: String) : Id = Id(url.replace(Regex(".+/(\\d+)/"),"$1"))

        fun fromInt(id: Int) : Id = Id(id.toString())
    }
}