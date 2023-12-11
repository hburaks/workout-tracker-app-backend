package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProfileRequestDTO extends BaseRequestDTO {
    private Long userId;
}
