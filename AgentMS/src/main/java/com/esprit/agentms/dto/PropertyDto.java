package com.esprit.agentms.dto;

public record PropertyDto(Long id, String title, String address, Double price, String agentEmail)
{
    // No additional methods are needed as the record automatically provides
    // getters, equals, hashCode, and toString methods.
}