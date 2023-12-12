package com.hbdev.workouttrackerbackend.util.security;

import com.hbdev.workouttrackerbackend.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity, UserResponseDTO, UserRequestDTO> {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

}
