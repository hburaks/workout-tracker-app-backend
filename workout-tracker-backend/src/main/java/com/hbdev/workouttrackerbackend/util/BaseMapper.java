package com.hbdev.workouttrackerbackend.util;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMapper<
        DTO extends BaseDTO,
        Entity extends BaseEntity,
        RequestDTO extends BaseDTO
        > implements IBaseMapper<DTO, Entity, RequestDTO> {
    @Override
    public abstract DTO entityToDTO(Entity entity);

    @Override
    public abstract Entity dtoToEntity(DTO dto);


    @Override
    public List<DTO> entityListToDTOList(List<Entity> entities) {
        List<DTO> DTOList = new ArrayList<>();

        for (Entity addressEntity : entities) {
            DTOList.add(entityToDTO(addressEntity));
        }
        return DTOList;
    }

    @Override
    public List<Entity> dtoListTOEntityList(List<DTO> dtos) {
        List<Entity> entityList = new ArrayList<>();

        for (DTO dto : dtos) {
            entityList.add(dtoToEntity(dto));
        }
        return entityList;
    }


    @Override
    public abstract Entity requestDTOToEntity(RequestDTO dto);


    @Override
    public List<Entity> requestDtoListTOEntityList(List<RequestDTO> requestDTOS) {
        return null;
    }

    @Override
    public Entity requestDtoToExistEntity(RequestDTO dto, Entity entity) {
        return null;
    }
}
