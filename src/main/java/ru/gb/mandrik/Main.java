package ru.gb.mandrik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Integer[] array = {1, 3, 4, 6, 10, 85, 46};
        swap(array, 1, 0);
        convertToArrayList(array);
    }

    private static <T> void swap(T[] array, int firstIndex, int secondIndex) {
        T firstValue = array[firstIndex];
        T secondValue = array[secondIndex];
        array[firstIndex] = secondValue;
        array[secondIndex] = firstValue;
        System.out.println(Arrays.toString(array));
    }

    private static <E> List<E> convertToArrayList(E[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}
