package com.pakhomova;

import java.util.Iterator;

/**
 * Реализация интерфейса ArrayList с использованием массива для хранения элементов.
 *
 * @param <T> тип элементов, которые содержатся в списке.
 */
public class MyArrayList<T> implements ArrayList<T> {

    /**
     * Массив для хранения элементов списка.
     */
    T[] values;

    /**
     * Конструктор без аргументов, создает пустой список.
     */
    public MyArrayList() {
        values = (T[]) new Object[0];
    }

    /**
     * Добавляет элемент в конец списка.
     * @param t элемент, который нужно добавить.
     */
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

    /**
     * Вставляет элемент по указанному индексу в список.
     * @param index индекс, по которому нужно вставить элемент.
     * @param element элемент, который нужно вставить.
     * @return true, если элемент успешно вставлен, иначе false.
     */
    @Override
    public boolean add(int index, T element) {
        if (index >= size()) {
            return false;
        }

        values[index] = element;
        return true;
    }

    /**
     * Возвращает элемент по указанному индексу.
     * @param index индекс элемента, который нужно получить.
     * @return элемент по указанному индексу.
     */
    @Override
    public T get(int index) {
        return values[index];
    }

    /**
     * Удаляет элемент по указанному индексу из списка.
     * @param index индекс элемента, который нужно удалить.
     * @return true, если элемент успешно удален, иначе false.
     */
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

    /**
     * Сортирует элементы списка в естественном порядке
     * с использованием алгоритма пузырьковой сортировки.
     */
    @Override
    public void sort() {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < values.length - 1; i++) {
                if (((Comparable<T>) values[i]).compareTo(values[i + 1]) > 0) {
                    // Swap values[i] and values[i + 1]
                    T temp = values[i];
                    values[i] = values[i + 1];
                    values[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);

    }

    /**
     * Проверяет, является ли список пустым.
     * @return true, если список пуст, иначе false.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Возвращает количество элементов в списке.
     * @return количество элементов в списке.
     */
    @Override
    public int size() {
        return values.length;
    }

    /**
     * Заменяет элемент по указанному индексу новым элементом.
     *
     * @param t     новый элемент, которым нужно заменить существующий элемент.
     * @param index индекс элемента, который нужно заменить.
     */
    @Override
    public void set(T t, int index) {
        values[index] = t;
    }

    /**
     * Возвращает итератор для обхода элементов списка.
     * @return итератор для обхода элементов списка.
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(values);
    }
}
