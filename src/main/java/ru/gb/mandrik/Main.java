package ru.gb.mandrik;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TestExecutor.start(TestClass.class);
    }
}
