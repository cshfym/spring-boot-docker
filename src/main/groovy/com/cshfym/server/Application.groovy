package com.cshfym.server

import com.cshfym.server.config.KafkaConfiguration
import com.cshfym.server.services.KafkaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration
import org.springframework.boot.web.support.SpringBootServletInitializer
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.DispatcherServlet

@PropertySources([
    @PropertySource(value = "classpath:application.properties"),
    @PropertySource(value = "file:/usr/local/conf/spring-boot-docker/application.properties", ignoreResourceNotFound = true)
])
@SpringBootApplication
@RestController
@EnableAutoConfiguration(exclude = FlywayAutoConfiguration.class)
@Import([
    KafkaConfiguration.class
])

class Application extends SpringBootServletInitializer {

    @Autowired
    KafkaService kafkaService

    static void main(String[] args) {
        // SpringApplication.run(Application.class, args)
        ApplicationContext context = SpringApplication.run Application, args
        DispatcherServlet dispatcherServlet = (DispatcherServlet)context.getBean("dispatcherServlet")
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true)
    }

}