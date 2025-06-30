package com.esprit.agentms;

import com.esprit.agentms.entities.Agent;
import com.esprit.agentms.repositories.AgentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.io.Console;
import java.lang.constant.Constable;

@EnableFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AgentMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgentMsApplication.class, args);
    }
        @Bean
        CommandLineRunner runner(AgentRepository agentRepository) {
        return args -> {
//            Agent agent = new Agent("MohamedAziz","BenTourkia","AzizVoyages","c@a.com","50645211");
//            agentRepository.insert(agent);
            System.out.println(agentRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase("aziz","ben"));
            System.out.println(agentRepository.findByEmailIgnoreCase("c@a.com"));
        };

    }



}
