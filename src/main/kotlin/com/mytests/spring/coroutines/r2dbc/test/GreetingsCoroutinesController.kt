package com.mytests.spring.coroutines.r2dbc.test

import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/coroutines")
class GreetingsCoroutinesController(private val service: GreetingsCoroutinesService) {

    @PostMapping("/create-one")
    suspend fun createOne() {
        service.createMessage()
    }

    @PostMapping("/create-two")
    suspend fun createTwo() {
        service.createMessages()
    }

    @GetMapping("/find")
    suspend fun find(): List<Greetings> {
        return service.findAllMessages()
    }

    @GetMapping("/find-flow")
    suspend fun findFlow(): Flow<Greetings> {
        return service.findAllMessagesFlow()
    }
    @GetMapping("/find-top")
    suspend fun findTop(): Greetings {
        return service.findSingleFooByMessage()
    }
    @GetMapping("/check-username")
    suspend fun checkUsername(): Boolean {
        return service.doesExistsUser()
    }
    @GetMapping("/find-by-message")
    suspend fun findByMessage(): List<Greetings> {
        return service.findAllByMessage();
    }
    @GetMapping("/find-by-username")
    suspend fun findByUsername(): List<Greetings> {
        return service.findAllByUsername();
    }
    @GetMapping("/count-messages")
    suspend fun countExclamationMessages(): Int {
        return service.countMessagesWithExclamationPoint();
    }
    @GetMapping("/count-names")
    suspend fun countNames(): Int {
        return service.countUsernamesWithSpecificSymbols();
    }
}