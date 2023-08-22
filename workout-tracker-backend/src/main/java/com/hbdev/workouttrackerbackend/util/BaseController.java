package com.hbdev.workouttrackerbackend.util;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseRepository;
import com.hbdev.workouttrackerbackend.util.pageable.BaseFilterRequestDTO;
import com.hbdev.workouttrackerbackend.util.pageable.PageResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public abstract class BaseController<RequestDTO extends BaseRequestDTO, ResponseDTO extends BaseResponseDTO, Entity extends BaseEntity, Mapper extends BaseMapper<Entity, ResponseDTO, RequestDTO>, Repository extends BaseRepository<Entity>, Service extends BaseService<ResponseDTO, RequestDTO, Entity, Mapper, Repository>> {

    protected abstract Service getService();

    @PostMapping("get-all-filter")
    public ResponseEntity<PageResponseDTO<ResponseDTO>> getAll(@RequestBody BaseFilterRequestDTO baseFilterRequestDTO) {
        return new ResponseEntity<>(getService().getAll(baseFilterRequestDTO), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ResponseDTO> save(@RequestBody RequestDTO requestDTO) {
        try {
            ResponseDTO responseDTO = getService().save(requestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{uuid}")
    public ResponseEntity<ResponseDTO> getByUuid(@PathVariable UUID uuid) {
        try {
            ResponseDTO responseDTO = getService().getByUuid(uuid);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{uuid}")
    public ResponseEntity<Boolean> deleteByUuid(@PathVariable UUID uuid) {
        Boolean isDeleted = getService().deleteByUuid(uuid);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping({"{uuid}"})
    public ResponseEntity<ResponseDTO> update(@PathVariable UUID uuid, RequestDTO requestDTO) {
        try {
            ResponseDTO responseDTO = getService().update(uuid, requestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
