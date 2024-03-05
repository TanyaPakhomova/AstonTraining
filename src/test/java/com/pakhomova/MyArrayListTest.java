package com.pakhomova;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void add(){
        MyArrayList<String> arrayList = new MyArrayList<>();
        assertTrue( arrayList.add("first"));
    }
    @Test
    void get(){
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("first");
        arrayList.add("second");
        arrayList.add("third");

        assertEquals("first", arrayList.get(0));

    }

    @Test
    void remove(){
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("first");
        arrayList.add("second");
        arrayList.add("third");

        assertTrue(arrayList.remove(2));
    }

    @Test
    void clear(){
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("first");
        arrayList.add("second");
        arrayList.add("third");

        assertTrue(arrayList.clear());
    }

}