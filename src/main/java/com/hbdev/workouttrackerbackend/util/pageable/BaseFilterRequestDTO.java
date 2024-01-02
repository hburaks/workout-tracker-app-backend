package com.hbdev.workouttrackerbackend.util.pageable;

import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BaseFilterRequestDTO extends BaseRequestDTO {
    private Integer pageNumber;
    private Integer pageSize;
    private SortDTO sortDTO;
    private List<SearchCriteria> filters;
}

