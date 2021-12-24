package com.mytests.spring.coroutines.r2dbc.test
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository


interface GreetingsCoroutinesRepository : CoroutineCrudRepository<Greetings, String>{

    suspend fun existsByUsername(username: String): Boolean
    suspend fun findTopByMessage(message: String): Greetings

    suspend fun findByUsernameContains(username: String): Flow<Greetings>

    fun findByMessageContains(message: String): Flow<Greetings>
}
