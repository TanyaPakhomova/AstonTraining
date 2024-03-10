package com.pakhomova;

import java.util.Comparator;

/**
 * Класс, реализующий алгоритм быстрой сортировки для ArrayList.
 */
public class QuickSort {

    /**
     * Сортирует переданный ArrayList с использованием заданного компаратора.
     *
     * @param <T>        тип элементов в ArrayList.
     * @param arrayList  список, который нужно отсортировать.
     * @param comparator компаратор для определения порядка сортировки.
     */
    static <T extends Comparable<T>> void sort(ArrayList<T> arrayList, Comparator<T> comparator) {
        int low = 0;
        int high = arrayList.size() - 1;

        sortReq(arrayList, comparator, low, high);
    }

    /**
     * Рекурсивно выполняет быструю сортировку в пределах указанных индексов массива.
     *
     * @param <T>        тип элементов в ArrayList.
     * @param arrayList  список, который нужно отсортировать.
     * @param comparator компаратор для определения порядка сортировки.
     * @param lowIndex   нижний индекс для текущего вызова.
     * @param highIndex  верхний индекс для текущего вызова.
     */
    static <T extends Comparable<T>> void sortReq(ArrayList<T> arrayList, Comparator<T> comparator, int lowIndex, int highIndex) {
        //выбираем опорный элемент
        int middle = lowIndex + (highIndex - lowIndex) / 2;
        T opora = arrayList.get(middle);

        //делим на массивы больше и меньше опоры
        int i = lowIndex, j = highIndex;
        while (i <= j) {
            while (comparator.compare(arrayList.get(i), opora) < 0) {
                i++;
            }
            while (comparator.compare(arrayList.get(j), opora) > 0) {
                j--;
            }
            //меняем местами
            if (i <= j) {
                T temp = arrayList.get(i);
                arrayList.set(arrayList.get(j), i);
                arrayList.set(temp, j);
                i++;
                j--;
            }

        }

        // вызов рекурсии для сортировки левой и правой части
        if (lowIndex < j)
            sortReq(arrayList, comparator, lowIndex, middle);

        if (highIndex > i)
            sortReq(arrayList, comparator, middle, highIndex);
    }
}