package com.baselogic.cloud.configserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@SpringBootApplication

@EnableConfigServer

@EnableCircuitBreaker
public class Application {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


    /**
     * TODO: Add a mapping for '/' to show default message.
     */



    /**
     * Print out all beans in context if 'trace' profile is enabled
     *
     * gradle bootRun -Dspring.profiles.active=trace
     * gradle bootRun -Dspring.profiles.active=TLS,trace
     *
     * @param ctx
     * @return
     */
    @Profile("trace")
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            String[] beanNames = ctx.getBeanDefinitionNames();

            logger.debug("\n********************************************");
            logger.debug("Listing the " + beanNames.length + " beans loaded by Spring Boot:");

            Arrays.stream(beanNames).sorted().forEach(System.out::println);

            logger.debug("*** the End ********************************\n");
        };
    }

} // The End...
