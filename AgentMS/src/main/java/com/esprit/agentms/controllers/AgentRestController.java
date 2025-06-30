package com.esprit.agentms.controllers;


import com.esprit.agentms.clients.AgentClient;
import com.esprit.agentms.dto.AgentDto;
import com.esprit.propertyms.dto.PropertyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import com.esprit.agentms.services.IAgentService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/agents")
@RequiredArgsConstructor
public class AgentRestController{

    private final IAgentService agentService;
    private final AgentClient agentClient;
    @PostMapping("add")
    public AgentDto add(@RequestBody AgentDto agentDto) {
        return agentService.add(agentDto);
    }

    @PatchMapping("update/{id}")
    public AgentDto patchUpdate(@RequestBody Map<Object,Object> fields, @PathVariable String id){
        return agentService.update(id,fields);
    }

    @DeleteMapping("delete/{email}")
    public boolean delete( @PathVariable String email){
        return agentService.delete(email);
    }


    @GetMapping
    public Page<AgentDto> getAgents(int pageNbr,int pageSize){
        return agentService.getAgents(pageNbr,pageSize);
    }

    @GetMapping("{id}")
    public AgentDto getAgent(@PathVariable String id){
        return agentService.getAgent(id);
    }

    @GetMapping("search/{name}")
    public List<AgentDto> getAgentByName(@PathVariable String name){
        return agentService.searchAgentByName(name);
    }
    @GetMapping("agent/{email}")
    public AgentDto getAgentByEmail(@PathVariable String email){
        return agentService.getAgentByEmail(email);
    }

    @GetMapping("/properties/agent/{email}")
    List<PropertyDto> getPropertiesByAgentEmail(@PathVariable("email") String email){
        return agentClient.getPropertiesByAgentEmail(email);
    }






}