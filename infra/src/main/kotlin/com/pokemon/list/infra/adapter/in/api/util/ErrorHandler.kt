package com.pokemon.list.infra.adapter.`in`.api.util

import com.pokemon.list.domain.exception.PokemonException
import com.pokemon.list.infra.adapter.`in`.api.dto.Response
import com.pokemon.list.infra.adapter.`in`.api.util.dto.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class ErrorHandler {

    companion object {
        fun mapError(pokemonException: PokemonException):
                ResponseEntity<Response> = when(pokemonException.code){
                    500 -> ResponseEntity.internalServerError().body(createErrorResponse(pokemonException.message))
                    403 -> ResponseEntity.status(HttpStatus.FORBIDDEN).body(createErrorResponse(pokemonException.message))
            else -> ResponseEntity.internalServerError().body(createErrorResponse(pokemonException.message))
        }

        private fun createErrorResponse(message:String) :ErrorResponse = ErrorResponse(message)
    }
}