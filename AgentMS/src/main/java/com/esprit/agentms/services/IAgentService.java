package com.esprit.agentms.services;

import com.esprit.agentms.dto.AgentDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface IAgentService {
    AgentDto add(AgentDto agentDto);

    AgentDto update(String id, Map<Object, Object> fields);

    boolean delete(String id);

    Page<AgentDto> getAgents(int pageNbr, int pageSize);

    AgentDto getAgent(String id);

    List<AgentDto> searchAgentByName(String name);

    AgentDto getAgentByEmail(String email);
}
