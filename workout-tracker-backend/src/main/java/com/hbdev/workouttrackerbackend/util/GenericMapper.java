package com.hbdev.workouttrackerbackend.util;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GenericMapper<Entity extends BaseEntity, ResponseDTO extends BaseDTO, RequestDTO extends BaseDTO> {
//TODO Can't generate mapping method for a generic type variable source.
    GenericMapper INSTANCE = Mappers.getMapper(GenericMapper.class);

    Entity dtoToEntity(RequestDTO source);
    ResponseDTO entityToDto(Entity source);


    List<Entity> dtoListToEntityList(List<RequestDTO> sourceList);
    List<ResponseDTO> entityListToDtoList(List<Entity> sourceList);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    Entity updateEntityFromDto(RequestDTO dto, @MappingTarget Entity entity);

}