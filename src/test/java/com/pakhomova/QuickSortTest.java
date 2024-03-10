package com.pakhomova;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickSortTest {
    @Test
    void testSortWithInteger() {
        ArrayList<Integer> integerList = new MyArrayList<>();
        integerList.add(33);
        integerList.add(9);
        integerList.add(5);
        integerList.add(22);
        integerList.add(99);
        integerList.add(11);

        QuickSort.sort(integerList, Integer::compareTo);

        assertEquals(5, integerList.get(0));
        assertEquals(9, integerList.get(1));
        assertEquals(11, integerList.get(2));
        assertEquals(22, integerList.get(3));
        assertEquals(33, integerList.get(4));
        assertEquals(99, integerList.get(5));
    }

    @Test
    void testSortWithString() {
        ArrayList<String> stringList = new MyArrayList<>();
        stringList.add("banana");
        stringList.add("apple");
        stringList.add("orange");
        stringList.add("grape");
        stringList.add("pineapple");

        Comparator<String> stringComparator = Comparator.naturalOrder();
        QuickSort.sort(stringList, stringComparator);

        assertEquals("apple", stringList.get(0));
        assertEquals("banana", stringList.get(1));
        assertEquals("grape", stringList.get(2));
        assertEquals("orange", stringList.get(3));
        assertEquals("pineapple", stringList.get(4));
    }

    @Test
    void testSortWithCustomComparator() {
        MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add("ora");
        stringList.add("b");
        stringList.add("grape");
        stringList.add("pineapple");
        stringList.add("ap");

        Comparator<String> customComparator = (s1, s2) -> s2.length() - s1.length();
        QuickSort.sort(stringList, customComparator);

        assertEquals("pineapple", stringList.get(0));
        assertEquals("grape", stringList.get(1));
        assertEquals("ora", stringList.get(2));
        assertEquals("ap", stringList.get(3));
        assertEquals("b", stringList.get(4));
    }

    @Test
    void testWithSingleElement() {
        MyArrayList<Integer> stringList = new MyArrayList<>();
        stringList.add(12);

        Comparator<Integer> integerComparator = Comparator.naturalOrder();
        QuickSort.sort(stringList, integerComparator);

        assertEquals(1, stringList.size());
        assertEquals(12, stringList.get(0));
    }
}