package com.hbdev.workouttrackerbackend.model.responseDTO.primitives;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import com.hbdev.workouttrackerbackend.util.security.UserResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrimitiveProfileResponseDTO extends BaseResponseDTO {

    private UserResponseDTO user;

}
