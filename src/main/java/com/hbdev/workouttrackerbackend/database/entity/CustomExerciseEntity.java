package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table
@Entity
@Getter
@Setter
public class CustomExerciseEntity extends BaseEntity {

    private String name;

    private int volume;

    private String note;

    private int restTime;

    @OneToMany(mappedBy = "customExercise", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<SetEntity> Sets;

    @ManyToOne
    @JoinColumn(name = "default_exercise_id")
    private DefaultExerciseEntity defaultExercise;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private WorkoutEntity workout;

}
