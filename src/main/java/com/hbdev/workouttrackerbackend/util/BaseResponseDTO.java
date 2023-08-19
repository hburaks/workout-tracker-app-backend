package com.hbdev.workouttrackerbackend.util;

import lombok.Data;

import java.util.Date;
import java.util.UUID;
@Data
public class BaseResponseDTO {
    private Long id;

    private UUID uuid;

    private Date creationDate;

    private Date lastModifiedDate;

}
