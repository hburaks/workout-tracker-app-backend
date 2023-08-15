package com.hbdev.workouttrackerbackend.util;


import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseRepository;

import java.util.List;
import java.util.UUID;

public abstract class BaseService<
        DTO extends BaseDTO,
        Entity extends BaseEntity,
        RequestDTO extends BaseDTO,
        Mapper extends BaseMapper<DTO, Entity, RequestDTO>,
        Repository extends BaseRepository<Entity>> {

    protected abstract Mapper getBaseMapper();


    protected abstract Repository getBaseRepository();

    public DTO save(RequestDTO requestDTO) {
        Entity entity = getBaseMapper().requestDTOToEntity(requestDTO);
        getBaseRepository().save(entity);
        return getBaseMapper().entityToDTO(entity);
    }

    public List<DTO> getAll() {
        List<Entity> entityList = getBaseRepository().findAll();
        return getBaseMapper().entityListToDTOList(entityList);
    }

    public DTO update(UUID uuid, RequestDTO requestDTO) {
        Entity entity = getBaseRepository().findByUuid(uuid).orElse(null);
        if (entity == null) {
            return null;
        }
        return getBaseMapper().entityToDTO(getBaseRepository().save(getBaseMapper().requestDtoToExistEntity(requestDTO, entity)));
    }


    public Boolean delete(UUID uuid) {
        Entity entity = getBaseRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            getBaseRepository().delete(entity);
            return true;
        }
        return false;
    }


    public DTO getByUuid(UUID uuid) {
        Entity entity = getBaseRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            return getBaseMapper().entityToDTO(entity);
        } else {
            return null;
        }
    }
}
