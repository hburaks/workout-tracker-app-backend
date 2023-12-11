package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table
@Entity
@Data
public class CustomExerciseEntity extends BaseEntity {

    private String name;

    private int volume;

    @OneToMany(mappedBy = "customExercise", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<SetEntity> Sets;

    @ManyToOne
    @JoinColumn(name = "default_exercise_id")
    private DefaultExerciseEntity defaultExercise;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private WorkoutEntity workout;

}
