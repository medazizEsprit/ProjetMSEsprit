package com.esprit.agentms.repositories;

import com.esprit.agentms.entities.Agent;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AgentRepository extends MongoRepository<Agent, String> {
    @Query("{ '$or': [ { 'firstName': { $regex: ?0, $options: 'i' } }, { 'lastName': { $regex: ?0, $options: 'i' } } ] }")
    <List> Optional<Agent> findByName(String name);
    List<Agent> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String keyword, String keyword2);
    Agent findByEmailIgnoreCase(String email);

}
