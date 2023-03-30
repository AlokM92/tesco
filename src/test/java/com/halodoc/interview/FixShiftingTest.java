package com.halodoc.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FixShiftingTest {

    FixShifting fixShifting;

    @Test
    void testMergeShifts() {

        Interval arr[] = new Interval[3];
        arr[0]= new Interval(1,9);
        arr[1]= new Interval(2,5);
        arr[2]= new Interval(19,20);

        List<Interval> result = fixShifting.mergeShifts(arr);


        Assertions.assertEquals(2, result.size());

    }
    @Test
    void testMergeShiftsNullCheck() {
        FixShifting fixShifting = new FixShifting();
        Interval arr[] = new Interval[0];

        Assertions.assertNull(fixShifting.mergeShifts(arr));
    }
}
