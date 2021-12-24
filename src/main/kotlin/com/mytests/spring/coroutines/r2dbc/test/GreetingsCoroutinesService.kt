package com.mytests.spring.coroutines.r2dbc.test

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GreetingsCoroutinesService(private val fooRepository: GreetingsCoroutinesRepository) {

    @Transactional
    suspend fun createMessages() {
        fooRepository.save(Greetings("hi!","John"))
        fooRepository.save(Greetings("hi!","Marie"))
    }

    @Transactional
    suspend fun createMessage(): Greetings {
        return fooRepository.save(Greetings("hi!","Rebecca"))
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
        return fooRepository.findTopByMessage("hi!")
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
}