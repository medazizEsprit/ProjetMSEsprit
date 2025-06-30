package com.esprit.agentms.dto;

public record AgentDto(String id,String firstName,String lastName,String email, String phone, String agency) {
    // No additional methods are needed as the record automatically provides
    // getters, equals, hashCode, and toString methods.
}