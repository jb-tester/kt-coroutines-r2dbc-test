package com.mytests.spring.coroutines.r2dbc.test

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

private const val STRING1 = "hi!"

@Service
class GreetingsCoroutinesService(private val fooRepository: GreetingsCoroutinesRepository) {

    @Transactional
    suspend fun createMessages() {
        fooRepository.save(Greetings(STRING1,"John"))
        fooRepository.save(Greetings(STRING1,"Marie"))
    }

    @Transactional
    suspend fun createMessage(): Greetings {
        return fooRepository.save(Greetings(STRING1,"Rebecca"))
    }

    //@Transactional
    suspend fun findAllMessages(): List<Greetings> {
        delay(10)
        return fooRepository.findAll().toList()
    }

    //@Transactional
    suspend fun findAllMessagesFlow(): Flow<Greetings> {
        delay(10)
        return fooRepository.findAll()
    }
    
    suspend fun findSingleFooByMessage(): Greetings {
        return fooRepository.findTopByMessage("hello!")
    }

    suspend fun doesExistsUser(): Boolean{
        return fooRepository.existsByUsername("Jane");
    }

    suspend fun findAllByMessage(): List<Greetings>{
        return fooRepository.findByMessageContains("hello").toList();
    }
    suspend fun findAllByUsername(): List<Greetings>{
        return fooRepository.findByUsernameContains("Ja").toList();
    }

    suspend fun countMessagesWithExclamationPoint():Int{
        return fooRepository.countByMessageEndingWith("!")
    }
    // will return 0, since reactive-type parameters are not treated correctly with r2dbc
    suspend fun countUsernamesWithSpecificSymbols(): Int {
        return fooRepository.countByUsername(flowOf("Jane")).first()
    }
}