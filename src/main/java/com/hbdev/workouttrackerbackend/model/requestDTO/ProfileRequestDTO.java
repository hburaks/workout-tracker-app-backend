package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;
import lombok.Data;


@Data
public class ProfileRequestDTO extends BaseRequestDTO {
    private Long userId;
}
