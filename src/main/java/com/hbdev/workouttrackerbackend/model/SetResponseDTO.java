package com.hbdev.workouttrackerbackend.model;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class SetResponseDTO extends BaseEntity {

    @Column
    double weight;
    @Column
    int reps;
    @Column
    int order;
}
