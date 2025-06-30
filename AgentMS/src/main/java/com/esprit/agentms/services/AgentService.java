package com.esprit.agentms.services;

import com.esprit.agentms.dto.AgentDto;
import com.esprit.agentms.entities.Agent;
import com.esprit.agentms.mappers.AgentMapper;
import com.esprit.agentms.repositories.AgentRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AgentService implements IAgentService {
    private final AgentRepository agentRepository;
    private final AgentMapper agentMapper;

    public AgentService(AgentRepository agentRepository, AgentMapper agentMapper) {
        this.agentRepository = agentRepository;
        this.agentMapper = agentMapper;
    }

    @Override
    public AgentDto add(AgentDto agentDto) {
        Agent agent = agentMapper.mapToEntity(agentDto);
        return agentMapper.mapToDto(agentRepository.save(agent));
    }

    @Override
    public AgentDto update(String id, Map<Object, Object> fields) {
        Optional<Agent> optionalAgent = agentRepository.findById(id);
        if (optionalAgent.isEmpty()) {
            return null; // Ou lancer une exception personnalisée
        }

        Agent agent = optionalAgent.get();
        fields.forEach((key, value) -> {
            try {
                Field field = Agent.class.getDeclaredField((String) key);
                field.setAccessible(true);
                field.set(agent, value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // Log l'erreur si nécessaire
            }
        });
        return agentMapper.mapToDto(agentRepository.save(agent));
    }

    @Override
    public boolean delete(String id) {
        if (agentRepository.existsById(id)) {
            agentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Page<AgentDto> getAgents(int pageNbr, int pageSize) {
        Pageable pageable = PageRequest.of(pageNbr, pageSize);
        return agentRepository.findAll(pageable).map(agentMapper::mapToDto);
    }

    @Override
    public AgentDto getAgent(String id) {
        return agentRepository.findById(id)
                .map(agentMapper::mapToDto)
                .orElse(null);
    }

    @Override
    public List<AgentDto> searchAgentByName(String name) {
        return agentRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name)
                .stream()
                .map(agentMapper::mapToDto)
                .toList();
    }

    @Override
    public AgentDto getAgentByEmail(String email) {
        return agentMapper.mapToDto(agentRepository.findByEmailIgnoreCase(email));
    }
}
