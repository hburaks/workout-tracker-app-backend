package com.hbdev.workouttrackerbackend.util;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public abstract class BaseController<
		DTO extends BaseDTO,
		Entity extends BaseEntity,
		RequestDTO extends BaseDTO,
		Mapper extends BaseMapper<DTO, Entity, RequestDTO>,
		Repository extends BaseRepository<Entity>,
		Service extends BaseService<DTO, Entity, RequestDTO, Mapper, Repository>
		> {
	protected abstract Service getBaseService();

	@GetMapping("")
	public ResponseEntity<List<DTO>> getAll() {
		return new ResponseEntity<>(getBaseService().getAll(), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<DTO> getByUuid(@PathVariable UUID uuid) {
		DTO dto = getBaseService().getByUuid(uuid);
		if (dto == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<DTO> save(@RequestBody RequestDTO requestDTO) {
		return new ResponseEntity<>(getBaseService().save(requestDTO), HttpStatus.CREATED);
	}

	@PutMapping("/{uuid}")
	public ResponseEntity<DTO> updateSetting(@PathVariable UUID uuid, @RequestBody RequestDTO requestDTO) {
		DTO dto = getBaseService().update(uuid, requestDTO);
		if (dto == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(getBaseService().update(uuid, requestDTO), HttpStatus.OK);
	}

	@DeleteMapping("/{uuid}")
	public ResponseEntity<Boolean> deleteSetting(@PathVariable UUID uuid) {
		boolean isDeleted = getBaseService().delete(uuid);
		if (isDeleted) {
			return new ResponseEntity<>(isDeleted, HttpStatus.OK);
		}
		return new ResponseEntity<>(isDeleted, HttpStatus.NOT_FOUND);
	}
}
