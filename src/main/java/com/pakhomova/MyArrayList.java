package com.pakhomova;

import java.util.Iterator;

public class MyArrayList<T> implements ArrayList<T> {

    T[] values;

    public MyArrayList() {
        values = (T[]) new Object[0];
    }


    @Override
    public void add(T t) {
        try {
            T[] temp = values;
            values = (T[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = t;
        } catch (ClassCastException ex) {
            ex.getStackTrace();
        }
    }


    @Override
    public boolean add(int index, T element) {
        if (index >= size()) {
            return false;
        }

        values[index] = element;
        return true;
    }

    @Override
    public T get(int index) {
        return values[index];
    }

    @Override
    public boolean remove(int index) {
        if (index >= size()) {
            return false;
        }

        try {
            T[] temp = values;
            values = (T[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int amountElementAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, amountElementAfterIndex);
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void clear() {
        values = (T[]) new Object[0];
    }

    @Override
    public void sort() {

    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(values);
    }

    /*
- добавить элемент: add(T element),
- добавить элемент: по индексу: add(int index, T element),
- получить элемент: get(int index),
- удалить элемент remove(int index),
- очистить всю коллекцию: clear(),
- отсортировать sort() и (или) sort(Comparator<T> comparator)
     */
}
