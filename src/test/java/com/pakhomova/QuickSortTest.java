package com.pakhomova;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    @Test
    void sort() {
        ArrayList<Integer> integerArrayList = new MyArrayList<>();
        integerArrayList.add(3);
        integerArrayList.add(2);
        integerArrayList.add(1);

        QuickSort.sort(integerArrayList);

        assertEquals(1, integerArrayList.get(0));
        assertEquals(2, integerArrayList.get(1));
        assertEquals(3, integerArrayList.get(2));
    }
}