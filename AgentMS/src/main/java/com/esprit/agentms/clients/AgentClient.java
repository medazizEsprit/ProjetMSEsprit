package com.esprit.agentms.clients;

import com.esprit.propertyms.dto.PropertyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PROPERTYMS")
public interface AgentClient {
    @GetMapping("/properties/agent/{email}")
    List<PropertyDto> getPropertiesByAgentEmail(@PathVariable("email") String email);
}
