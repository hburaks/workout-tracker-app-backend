package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.SetEntity;
import com.hbdev.workouttrackerbackend.model.enums.SetTypeEnum;
import com.hbdev.workouttrackerbackend.model.enums.WeightUnitTypeEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class SetServiceTest {

    @InjectMocks
    private SetService setService;

    @Test
    void calculateVolumeOfSets() {
        List<SetEntity> sets = new ArrayList<>();

        SetEntity set1 = new SetEntity();
        set1.setSetTypeEnum(SetTypeEnum.REGULAR);
        set1.setWeightUnitTypeEnum(WeightUnitTypeEnum.KG);
        set1.setReps(11);
        set1.setWeight(20.0);
        sets.add(set1);

        SetEntity set2 = new SetEntity();
        set2.setSetTypeEnum(SetTypeEnum.REGULAR);
        set2.setWeightUnitTypeEnum(WeightUnitTypeEnum.KG);
        set2.setReps(8);
        set2.setWeight(20.0);
        sets.add(set2);


        SetEntity set3 = new SetEntity();
        set3.setSetTypeEnum(SetTypeEnum.REGULAR);
        set3.setWeightUnitTypeEnum(WeightUnitTypeEnum.KG);
        set3.setReps(10);
        set3.setWeight(25.0);
        sets.add(set3);

        SetEntity set4 = new SetEntity();
        set4.setSetTypeEnum(SetTypeEnum.REGULAR);
        set4.setReps(12);
        set4.setWeight(30.0);
        set4.setWeightUnitTypeEnum(WeightUnitTypeEnum.KG);
        sets.add(set4);

        Double volumeOfSets = setService.calculateVolumeOfSets(sets);
        Double expectedVolume = 990.0;

        assertEquals(expectedVolume, volumeOfSets, "The calculated volume of the list is incorrect.");

        //TODO: getting 0 from volume;
    }
}