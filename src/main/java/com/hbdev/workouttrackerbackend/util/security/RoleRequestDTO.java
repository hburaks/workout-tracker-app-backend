package com.hbdev.workouttrackerbackend.util.security;

import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;
import lombok.Data;

@Data
public class RoleRequestDTO extends BaseRequestDTO {
    private String name;
}
