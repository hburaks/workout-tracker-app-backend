package com.hbdev.workouttrackerbackend.util;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface IBaseMapper<Entity extends BaseEntity,
        ResponseDTO extends BaseResponseDTO,
        RequestDTO extends BaseRequestDTO> {

    Entity requestDtoToEntity(RequestDTO requestDTO);

    ResponseDTO entityToResponseDto(Entity entity);

    List<ResponseDTO> entityListToResponseDtoList(List<Entity> entityList);

    Entity updateEntityFromRequestDTO(RequestDTO requestDTO, @MappingTarget Entity entity);


}