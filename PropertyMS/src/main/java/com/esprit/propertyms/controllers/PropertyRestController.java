package com.esprit.propertyms.controllers;


import com.esprit.propertyms.dto.PropertyDto;
import com.esprit.propertyms.services.IPropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/properties")
@RequiredArgsConstructor
public class PropertyRestController{

    private final IPropertyService propertyService;

    @PostMapping("add")
    public PropertyDto add(@RequestBody PropertyDto propertyDto) {
        return propertyService.add(propertyDto);
    }

    @PatchMapping("update/{id}")
    public PropertyDto patchUpdate(@RequestBody Map<Object,Object> fields, @PathVariable Long id){
        return propertyService.update(id,fields);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete( @PathVariable Long id){
        return propertyService.delete(id);
    }


    @GetMapping
    public List<PropertyDto> getProperties(){
        return propertyService.getProperties();
    }

    @GetMapping("{id}")
    public PropertyDto getProperty(@PathVariable Long id){
        return propertyService.getProperty(id);
    }

    @GetMapping("name/{name}")
    public PropertyDto getPropertyByName(@PathVariable String name){
        return propertyService.getPropertyByName(name);
    }
    @GetMapping("agent/{email}")
    public List<PropertyDto> getPropertiesByAgentEmail(@PathVariable String email){
        return propertyService.getPropertiesByAgentEmail(email);
    }

}