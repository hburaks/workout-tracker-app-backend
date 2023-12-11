package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;

@Table
@Entity
@Data
public class WorkoutEntity extends BaseEntity {

    private int duration;

    private int volume;

    @CreatedDate
    private Date date;

    @OneToMany(mappedBy = "workout", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<CustomExerciseEntity> customExerciseList;

    @ManyToOne
    @JoinColumn(name = "workout_template_id")
    private WorkoutTemplateEntity workoutTemplate;


    @ManyToOne
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;

}
