package com.hbdev.workouttrackerbackend.util;

import com.hbdev.workouttrackerbackend.database.entity.ExerciseEntity;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseRepository;

import java.util.List;
import java.util.UUID;

public abstract class BaseService<ResponseDTO extends BaseResponseDTO, RequestDTO extends BaseRequestDTO, Entity extends BaseEntity, Mapper extends BaseMapper<Entity, ResponseDTO, RequestDTO>, Repository extends BaseRepository<Entity>> {
    protected abstract Mapper getBaseMapper();


    protected abstract Repository getBaseRepository();

    public List<ResponseDTO> getAll() {
        List<Entity> entityList = getBaseRepository().findAll();
        return getBaseMapper().entityListToResponseDtoList(entityList);
    }

    public ResponseDTO save(RequestDTO requestDTO) {
        Entity entity = getBaseMapper().requestDtoToEntity(requestDTO);
        getBaseRepository().save(entity);
        return getBaseMapper().entityToResponseDto(entity);
    }


    public ResponseDTO update(UUID uuid, RequestDTO requestDTO) {
        Entity entity = getBaseRepository().findByUuid(uuid).orElse(null);
        if (entity == null) {
            return null;
        }
        return getBaseMapper().entityToResponseDto(getBaseRepository().save(getBaseMapper().updateEntityFromRequestDTO(requestDTO, entity)));
    }

    public Boolean deleteByUuid(UUID uuid) {
        Entity entity = getBaseRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            getBaseRepository().delete(entity);
            return true;
        }
        return false;
    }

    public ResponseDTO getByUuid(UUID uuid) {
        Entity entity = getBaseRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            return getBaseMapper().entityToResponseDto(entity);
        } else {
            return null;
        }
    }

    public Entity getEntityByUuid(UUID uuid) {
        return getBaseRepository().findByUuid(uuid).orElse(null);
    }

}
