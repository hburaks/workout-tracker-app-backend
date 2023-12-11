package com.hbdev.workouttrackerbackend.mapper;

import com.hbdev.workouttrackerbackend.database.entity.ProfileEntity;
import com.hbdev.workouttrackerbackend.model.requestDTO.ProfileRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.ProfileResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfileMapper extends BaseMapper<ProfileEntity, ProfileResponseDTO, ProfileRequestDTO> {
    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    @Override
    @Mapping(source = "userId", target = "user.id")
    ProfileEntity requestDtoToEntity(ProfileRequestDTO requestDTO);
}
