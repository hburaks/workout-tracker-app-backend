package com.hbdev.workouttrackerbackend.util.pageable;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class SortDTO {
    private String columnName;
    private Sort.Direction directionEnum;
}
