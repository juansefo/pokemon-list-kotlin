package com.pokemon.list.infra.adapter.config

import com.pokemon.list.app.handler.GetPokemonHandler
import com.pokemon.list.app.handler.ListPokemonHandler
import com.pokemon.list.domain.ports.PokemonService
import com.pokemon.list.infra.adapter.out.service.PokemonServiceAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import reactor.netty.http.client.HttpClient

@Configuration
@ComponentScan(basePackages = ["com.pokemon.list.infra.adapter.in.api"])
class Config {

    @Bean
    fun buildListPokemonHandler (pokemonService: PokemonService): ListPokemonHandler = ListPokemonHandler(pokemonService)

    @Bean
    fun buildGetPokemonHandler (pokemonService: PokemonService): GetPokemonHandler = GetPokemonHandler(pokemonService)

    @Bean
    fun buildPokemonService (): PokemonService = PokemonServiceAdapter(createHttpClient())

    fun createHttpClient():HttpClient =HttpClient.create()


}