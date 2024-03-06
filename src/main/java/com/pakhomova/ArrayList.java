package com.pakhomova;

public interface ArrayList<T> extends Iterable<T> {
    boolean add(T t);
    boolean add(int index, T element);
    T get(int index);
    boolean remove(int index);
    boolean clear();
    void sort();
    boolean isEmpty();
    int size();

}
