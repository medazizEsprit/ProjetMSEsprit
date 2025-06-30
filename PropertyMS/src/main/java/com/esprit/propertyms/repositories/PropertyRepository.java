package com.esprit.propertyms.repositories;

import com.esprit.propertyms.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PropertyRepository extends JpaRepository<Property, String> {
    Optional<Object> findByTitle(String name);
    @Query("SELECT p FROM Property p WHERE p.agentEmail = :email")
    List<Property> findpropertiesByAgentEmail(String email);
}
