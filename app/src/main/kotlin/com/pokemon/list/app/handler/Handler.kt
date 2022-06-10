package com.pokemon.list.app.handler

import com.pokemon.list.app.query.Query
import org.reactivestreams.Publisher

abstract class Handler<in I:Query ,out T>{

    abstract fun execute(query: I): Publisher<@UnsafeVariance T>

}