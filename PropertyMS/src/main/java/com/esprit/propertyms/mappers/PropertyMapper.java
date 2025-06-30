package com.esprit.propertyms.mappers;

import com.esprit.propertyms.dto.PropertyDto;
import com.esprit.propertyms.entities.Property;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PropertyMapper {
    Property mapToEntity(PropertyDto propertyDto);
    PropertyDto mapToDto(Property property);
}
