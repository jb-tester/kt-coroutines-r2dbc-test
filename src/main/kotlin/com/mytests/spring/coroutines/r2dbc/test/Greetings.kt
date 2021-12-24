package com.mytests.spring.coroutines.r2dbc.test

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column

data class Greetings(val message: String, val username: String ){
    @get:Column("id")
    @get:Id
    var id: Int? = null
}