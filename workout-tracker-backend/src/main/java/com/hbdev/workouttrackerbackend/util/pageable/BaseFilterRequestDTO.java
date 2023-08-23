package com.hbdev.workouttrackerbackend.util.pageable;

import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;
import lombok.Data;

import java.util.List;

@Data
public class BaseFilterRequestDTO extends BaseRequestDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
    private List<SearchCriteria> filters;
}

