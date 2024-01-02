package com.hbdev.workouttrackerbackend;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WorkoutTrackerBackendApplicationTests {
    Calculator underTest = new Calculator();

    @Test
    void itShouldAddTwoNumbers() {
        // given
        Integer numberOne = 20;
        Integer numberTwo = 30;

        // when
        Integer result = underTest.add(numberOne, numberTwo);

        // then
        Integer expected = 50;
        assertThat(result).isEqualTo(expected);
    }

    class Calculator {
        Integer add(int a, Integer b) {
            return a + b;
        }
    }
}
