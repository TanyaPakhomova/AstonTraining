package com.pakhomova;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void testEmpty() {
        MyArrayList<String> arrayList = new MyArrayList<>();
        assertEquals(0, arrayList.size());
        assertTrue(arrayList.isEmpty());
    }

    @Test
    void testAdd() {
        MyArrayList<String> arrayList = new MyArrayList<>();

        arrayList.add("first");

        assertEquals(1, arrayList.size());
        assertFalse(arrayList.isEmpty());

        arrayList.add("second");

        assertEquals(2, arrayList.size());
        assertFalse(arrayList.isEmpty());
    }

    @Test
    void testAddIndexed() {
        MyArrayList<String> arrayList = new MyArrayList<>();

        assertFalse(arrayList.add(0, "first"));

        arrayList.add("first");
        assertTrue(arrayList.add(0, "first-updated"));

        assertEquals("first-updated", arrayList.get(0));
    }

    @Test
    void testGet() {
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
    void testRemove() {
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("first");
        arrayList.add("second");
        arrayList.add("third");

        assertEquals("first", arrayList.get(0));
        assertEquals("second", arrayList.get(1));
        assertEquals("third", arrayList.get(2));

        assertFalse(arrayList.remove(3));
        assertTrue(arrayList.remove(2));

        assertEquals("first", arrayList.get(0));
        assertEquals("second", arrayList.get(1));

        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(2));

        assertEquals(2, arrayList.size());
        assertFalse(arrayList.isEmpty());
    }

    @Test
    void testClear() {
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("first");
        arrayList.add("second");
        arrayList.add("third");

        assertEquals("first", arrayList.get(0));
        assertEquals("second", arrayList.get(1));
        assertEquals("third", arrayList.get(2));

        arrayList.clear();

        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(2));

        assertEquals(0, arrayList.size());
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testSort() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(2);

        list.sort();

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
    }

    @Test
    public void testSet() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        list.set("four", 1);

        assertEquals("four", list.get(1));
    }
}