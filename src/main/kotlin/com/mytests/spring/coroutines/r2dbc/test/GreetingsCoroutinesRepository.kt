package com.mytests.spring.coroutines.r2dbc.test
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository


interface GreetingsCoroutinesRepository : CoroutineCrudRepository<Greetings, String>{

    suspend fun existsByUsername(username: String): Boolean  // Reactive Types Are Expected error is shown: https://youtrack.jetbrains.com/issue/IDEA-285678
    suspend fun findTopByMessage(message: String): Greetings // Reactive Types Are Expected error is shown: https://youtrack.jetbrains.com/issue/IDEA-285678
    suspend fun countByMessageEndingWith(message: String): Int // Reactive Types Are Expected error is shown: https://youtrack.jetbrains.com/issue/IDEA-285678


    suspend fun findByUsernameContains(username: String): Flow<Greetings> // Reactive Types Are Expected error is shown: https://youtrack.jetbrains.com/issue/IDEA-285679

    fun findByMessageContains(message: String): Flow<Greetings>
}
