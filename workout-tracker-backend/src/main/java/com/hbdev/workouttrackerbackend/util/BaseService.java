package com.hbdev.workouttrackerbackend.util;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseRepository;
import com.hbdev.workouttrackerbackend.util.pageable.BaseFilterRequestDTO;
import com.hbdev.workouttrackerbackend.util.pageable.BaseSpecification;
import com.hbdev.workouttrackerbackend.util.pageable.PageResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.UUID;
import java.util.stream.Collectors;

public abstract class BaseService<
        ResponseDTO extends BaseResponseDTO,
        RequestDTO extends BaseRequestDTO,
        Entity extends BaseEntity,
        Mapper extends BaseMapper<Entity, ResponseDTO, RequestDTO>,
        Repository extends BaseRepository<Entity>,
        Specification extends BaseSpecification<Entity>> {
    protected abstract Mapper getMapper();


    protected abstract Repository getRepository();
    protected abstract Specification getSpecification();



    public PageResponseDTO<ResponseDTO> getAll(BaseFilterRequestDTO baseFilterRequestDTO) {
        Pageable pageable;
        if (baseFilterRequestDTO.getSortDTO() != null) {
            if (baseFilterRequestDTO.getSortDTO().getDirectionEnum() == Sort.Direction.ASC) {
                pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(), baseFilterRequestDTO.getPageSize(),
                        Sort.by(baseFilterRequestDTO.getSortDTO().getColumnName()).ascending());
            } else {
                pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(), baseFilterRequestDTO.getPageSize(),
                        Sort.by(baseFilterRequestDTO.getSortDTO().getColumnName()).descending());
            }
        } else {
            pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(), baseFilterRequestDTO.getPageSize(),
                    Sort.by("id").ascending());
        }

        getSpecification().setCriteriaList(baseFilterRequestDTO.getFilters());
        Page<Entity> entityPage = getRepository().findAll(getSpecification(), pageable);
        PageResponseDTO<ResponseDTO> responseDTO = new PageResponseDTO<>();
        responseDTO.setTotalElements(entityPage.getTotalElements());
        responseDTO.setTotalPages(entityPage.getTotalPages());
        responseDTO.setSize(entityPage.getSize());

        responseDTO.setSort(entityPage.getSort());
        responseDTO.setNumber(entityPage.getNumber());
        responseDTO.setHasContent(entityPage.hasContent());
        responseDTO.setContent(getMapper().entityListToResponseDtoList(entityPage.getContent()));
//        entityPage.get().map(entity -> getMapper().entityToResponseDto(entity)).collect(Collectors.toList());
        return responseDTO;
    }

    public ResponseDTO save(RequestDTO requestDTO) {
        Entity entity = getMapper().requestDtoToEntity(requestDTO);
        getRepository().save(entity);
        return getMapper().entityToResponseDto(entity);
    }


    public ResponseDTO update(UUID uuid, RequestDTO requestDTO) {
        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity == null) {
            return null;
        }
        return getMapper().entityToResponseDto(getRepository().save(getMapper().updateEntityFromRequestDTO(requestDTO, entity)));
    }

    public Boolean deleteByUuid(UUID uuid) {
        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            getRepository().delete(entity);
            return true;
        }
        return false;
    }

    public ResponseDTO getByUuid(UUID uuid) {
        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            return getMapper().entityToResponseDto(entity);
        } else {
            return null;
        }
    }

    public Entity getEntityByUuid(UUID uuid) {
        return getRepository().findByUuid(uuid).orElse(null);
    }

}
