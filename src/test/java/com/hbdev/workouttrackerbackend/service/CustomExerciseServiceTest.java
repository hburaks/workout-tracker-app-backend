package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.CustomExerciseEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomExerciseServiceTest {

    @InjectMocks
    private CustomExerciseService customExerciseService;

    @Mock
    private SetService setService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize the mock objects
    }

    @Test
    public void calculateVolumeOfCustomExerciseList() {
        List<CustomExerciseEntity> exercises = new ArrayList<>();
        CustomExerciseEntity exercise1 = mock(CustomExerciseEntity.class);
        CustomExerciseEntity exercise2 = mock(CustomExerciseEntity.class);
        CustomExerciseEntity exercise3 = mock(CustomExerciseEntity.class);

        when(exercise1.getVolume()).thenReturn(100.0);
        when(exercise2.getVolume()).thenReturn(150.0);
        when(exercise3.getVolume()).thenReturn(150.0);

        exercises.add(exercise1);
        exercises.add(exercise2);
        exercises.add(exercise3);

        Double volumeOfWorkout = customExerciseService.calculateVolumeOfCustomExerciseListAndUpdateRm1(exercises);

        Double expectedVolume = 400.0;
        assertEquals(expectedVolume, volumeOfWorkout, "The calculated volume of the list is incorrect.");
    }
}