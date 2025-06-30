package com.esprit.agentms.mappers;


import com.esprit.agentms.dto.AgentDto;
import com.esprit.agentms.entities.Agent;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AgentMapper {
    Agent mapToEntity(AgentDto agentDto);
    AgentDto mapToDto(Agent agent);
}
