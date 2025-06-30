package com.esprit.propertyms.services;

import com.esprit.propertyms.dto.PropertyDto;
import com.esprit.propertyms.entities.Property;
import com.esprit.propertyms.mappers.PropertyMapper;
import com.esprit.propertyms.repositories.PropertyRepository;

import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PropertyService implements IPropertyService {
    private final PropertyRepository propertyRepository;
    private final PropertyMapper propertyMapper;

    public PropertyService(PropertyRepository propertyRepository, PropertyMapper propertyMapper) {
        this.propertyRepository = propertyRepository;
        this.propertyMapper = propertyMapper;
    }

    @Override
    public PropertyDto add(PropertyDto propertyDto) {
        Property property = propertyMapper.mapToEntity(propertyDto);
        return propertyMapper.mapToDto(propertyRepository.save(property));
    }

    @Override
    public PropertyDto update(Long id, Map<Object, Object> fields) {
        Property property = propertyRepository.findById(id.toString())
                .orElseThrow(() -> new EntityNotFoundException("Property not found for id: " + id));

        fields.forEach((key, value) -> {
            try {
                Field field = Property.class.getDeclaredField(key.toString());
                field.setAccessible(true);
                field.set(property, value);
            } catch (Exception e) {
                throw new RuntimeException("Error updating field: " + key, e);
            }
        });
        return propertyMapper.mapToDto(propertyRepository.save(property));
    }

    @Override
    public boolean delete(Long id) {
        if (!propertyRepository.existsById(id.toString())) {
            return false;
        }
        propertyRepository.deleteById(id.toString());
        return true;
    }

    @Override
    public List<PropertyDto> getProperties() {
        return propertyRepository.findAll()
                .stream()
                .map(propertyMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PropertyDto getProperty(Long id) {
        Property property = propertyRepository.findById(id.toString())
                .orElseThrow(() -> new EntityNotFoundException("Property not found for id: " + id));
        return propertyMapper.mapToDto(property);
    }

    @Override
    public PropertyDto getPropertyByName(String name) {
        Property property = (Property) propertyRepository.findByTitle(name)
                .orElseThrow(() -> new EntityNotFoundException("Property not found for title: " + name));
        return propertyMapper.mapToDto(property);
    }

    @Override
    public List<PropertyDto> getPropertiesByAgentEmail(String mail) {
        return propertyRepository.findpropertiesByAgentEmail(mail)
                .stream()
                .map(propertyMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
