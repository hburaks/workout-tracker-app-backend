package com.hbdev.workouttrackerbackend.util.pageable;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Data;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
public class PageResponseDTO<DTO extends BaseResponseDTO> {

    private int number;
    private int size;
    private int totalPages;
    private Long totalElements;
    private boolean hasContent;
    private List<DTO> content;
    private Sort sort;
}
