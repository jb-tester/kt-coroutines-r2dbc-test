package com.mytests.spring.coroutines.r2dbc.test

import io.r2dbc.spi.ConnectionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.core.io.DefaultResourceLoader
import org.springframework.core.io.ResourceLoader
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator

@SpringBootApplication
class KtCoroutinesR2dbcTestApplication{

@Autowired
fun initializeDatabase(connectionFactory: ConnectionFactory) {
    val resourceLoader: ResourceLoader = DefaultResourceLoader()
    val scripts = arrayOf(resourceLoader.getResource("classpath:database.sql"))
    ResourceDatabasePopulator(*scripts).populate(connectionFactory).block()
}
}

fun main(args: Array<String>) {
    runApplication<KtCoroutinesR2dbcTestApplication>(*args) {
        webApplicationType = WebApplicationType.REACTIVE
    }
}