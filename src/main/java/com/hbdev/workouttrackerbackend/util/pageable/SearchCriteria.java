package com.hbdev.workouttrackerbackend.util.pageable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchCriteria {

    private String key;
    private String operation;
    private Object value;

}
