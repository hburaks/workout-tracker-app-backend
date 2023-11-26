package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.model.enums.BodyPartTypeEnum;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@Data
public class ExercisePersonalRecordEntity extends BaseEntity {
    private SetEntity maxVolumeSet;
    private SetEntity maxOneRepMaxSet;
    private SetEntity maxWeightSet;
}
