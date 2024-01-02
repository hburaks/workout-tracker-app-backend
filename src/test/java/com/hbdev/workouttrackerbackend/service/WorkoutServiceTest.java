package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.DbExerciseEntity;
import com.hbdev.workouttrackerbackend.database.entity.DefaultExerciseEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutEntity;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutRepository;
import com.hbdev.workouttrackerbackend.util.security.JWTUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WorkoutServiceTest {

    @Mock
    private WorkoutRepository workoutRepository;

    @Mock
    private JWTUtil jwtUtil;


    @InjectMocks
    private WorkoutService workoutService;


    @Test
    public void calculateTheDurationInSecond() {
        WorkoutEntity workout = mock(WorkoutEntity.class);

        Date startDate = new Date();
        Date endDate = new Date(startDate.getTime() + 1800 * 1000);

        when(workout.getStartDate()).thenReturn(startDate);
        when(workout.getEndDate()).thenReturn(endDate);

        Integer durationInSecond = workoutService.calculateTheDurationInSecond(workout);
        Integer expectedDuration = 1800;
        assertEquals(expectedDuration, durationInSecond, "The calculated duration of the workout is incorrect.");
    }

    @Test
    public void findDefaultExerciseWithNameFromList() {
        String name = "test-name";

        DefaultExerciseEntity exercise1 = mock(DefaultExerciseEntity.class);
        DbExerciseEntity mockDbExercise1 = mock(DbExerciseEntity.class);
        when(exercise1.getDbExercise()).thenReturn(mockDbExercise1);
        when(mockDbExercise1.getName()).thenReturn("exercise");

        DefaultExerciseEntity exercise2 = mock(DefaultExerciseEntity.class);
        DbExerciseEntity mockDbExercise2 = mock(DbExerciseEntity.class);
        when(exercise2.getDbExercise()).thenReturn(mockDbExercise2);
        when(mockDbExercise2.getName()).thenReturn("exercise");

        DefaultExerciseEntity exercise3 = mock(DefaultExerciseEntity.class);
        DbExerciseEntity mockDbExercise3 = mock(DbExerciseEntity.class);
        when(exercise3.getDbExercise()).thenReturn(mockDbExercise3);
        when(mockDbExercise3.getName()).thenReturn("test-name");

        List<DefaultExerciseEntity> defaultExerciseEntityList = Arrays.asList(exercise1, exercise2, exercise3);

        DefaultExerciseEntity founded = workoutService.findDefaultExerciseWithNameFromList(name, defaultExerciseEntityList);

        assertNotNull(founded);
        assertEquals(name, founded.getDbExercise().getName());
    }


}
