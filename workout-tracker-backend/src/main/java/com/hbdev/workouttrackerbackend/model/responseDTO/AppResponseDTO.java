package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import com.hbdev.workouttrackerbackend.util.security.UserWithoutAppResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class AppResponseDTO extends BaseResponseDTO {
    private String name;
    private List<DefaultExerciseWithoutAppResponseDTO> defaultExerciseList;
    private List<UserWithoutAppResponseDTO> userList;
}
