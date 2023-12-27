package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;

@Table(name = "workouts")
@Entity
@Getter
@Setter
public class WorkoutEntity extends BaseEntity {

    private int durationInSecond;

    private double volume;

    private boolean isFinished;

    @CreatedDate
    private Date startDate;

    private Date endDate;

    @OneToMany(mappedBy = "workout", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<CustomExerciseEntity> customExerciseList;

    @ManyToOne
    @JoinColumn(name = "workout_template_id")
    private WorkoutTemplateEntity workoutTemplate;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;

    public WorkoutEntity() {
        this.isFinished = false;
    }
}
