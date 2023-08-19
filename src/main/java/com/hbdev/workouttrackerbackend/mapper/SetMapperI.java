package com.hbdev.workouttrackerbackend.mapper;

import com.hbdev.workouttrackerbackend.database.entity.SetEntity;
import com.hbdev.workouttrackerbackend.model.SetResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.SetRequestDTO;
import com.hbdev.workouttrackerbackend.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SetMapperI extends IBaseMapper<SetEntity, SetResponseDTO, SetRequestDTO> {

    SetMapperI INSTANCE = Mappers.getMapper(SetMapperI.class);


}
