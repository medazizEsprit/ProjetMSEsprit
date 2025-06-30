package com.esprit.propertyms.services;

import com.esprit.propertyms.dto.PropertyDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface IPropertyService {
    PropertyDto add(PropertyDto agentDto);

    PropertyDto update(Long id, Map<Object, Object> fields);

    boolean delete(Long id);

    List<PropertyDto> getProperties();

    PropertyDto getProperty(Long id);

    PropertyDto getPropertyByName(String name);

    List<PropertyDto> getPropertiesByAgentEmail(String name);
}
