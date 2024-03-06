package com.pakhomova;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void empty() {
        MyArrayList<String> arrayList = new MyArrayList<>();
        assertEquals(0, arrayList.size());
        assertTrue(arrayList.isEmpty());
    }

    @Test
    void add() {
        MyArrayList<String> arrayList = new MyArrayList<>();

        arrayList.add("first");

        assertEquals(1, arrayList.size());
        assertFalse(arrayList.isEmpty());

        arrayList.add("second");

        assertEquals(2, arrayList.size());
        assertFalse(arrayList.isEmpty());
    }

    @Test
    void get() {
        MyArrayList<String> arrayList = new MyArrayList<>();

        arrayList.add("first");
        assertEquals("first", arrayList.get(0));

        arrayList.add("second");
        assertEquals("first", arrayList.get(0));
        assertEquals("second", arrayList.get(1));

        arrayList.add("third");
        assertEquals("first", arrayList.get(0));
        assertEquals("second", arrayList.get(1));
        assertEquals("third", arrayList.get(2));
    }

    @Test
    void remove() {
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("first");
        arrayList.add("second");
        arrayList.add("third");

        assertEquals("first", arrayList.get(0));
        assertEquals("second", arrayList.get(1));
        assertEquals("third", arrayList.get(2));

        assertTrue(arrayList.remove(2));

        assertEquals("first", arrayList.get(0));
        assertEquals("second", arrayList.get(1));

        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(2));

        assertEquals(2, arrayList.size());
        assertFalse(arrayList.isEmpty());
    }

    @Test
    void clear() {
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("first");
        arrayList.add("second");
        arrayList.add("third");

        assertEquals("first", arrayList.get(0));
        assertEquals("second", arrayList.get(1));
        assertEquals("third", arrayList.get(2));

        assertTrue(arrayList.clear());

        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(2));

        assertEquals(0, arrayList.size());
        assertTrue(arrayList.isEmpty());
    }

}