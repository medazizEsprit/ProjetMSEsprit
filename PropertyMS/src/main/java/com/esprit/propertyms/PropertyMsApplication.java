package com.esprit.propertyms;

import com.esprit.propertyms.entities.Property;
import com.esprit.propertyms.repositories.PropertyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class PropertyMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertyMsApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(PropertyRepository propertyRepository) {
        return args -> {
            System.out.println(propertyRepository.findpropertiesByAgentEmail("b@a.com") );

        };
    }
}
