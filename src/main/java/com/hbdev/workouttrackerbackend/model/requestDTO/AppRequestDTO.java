package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;
import lombok.Data;

@Data
public class AppRequestDTO extends BaseRequestDTO {
    private String name;
}
