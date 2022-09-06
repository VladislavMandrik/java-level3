package ru.gb.mandrik;

public class Main {

    private int[] arr = {1, 2, 4, 2, 3, 1, 7, 8, 6, 7};

    public String m(int[] arr) {

        String s = "";
        boolean isFour = false;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                isFour = true;
                break;
            }
            s += arr[i];
        }

        if (!isFour) {
            throw new RuntimeException();
        }
        s = String.valueOf(new StringBuilder(s).reverse());
        return s;
    }

    public boolean checkArray(int[] arr) {
        for (int e : arr) {
            if (e != 4) {
                if (e != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
