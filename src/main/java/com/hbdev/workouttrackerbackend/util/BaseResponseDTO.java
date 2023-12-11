package com.hbdev.workouttrackerbackend.util;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class BaseResponseDTO {

    private Long id;

    private UUID uuid;

    private Date creationDate;

    private Date lastModifiedDate;

}
