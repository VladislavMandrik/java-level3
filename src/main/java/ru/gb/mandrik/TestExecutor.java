package ru.gb.mandrik;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class TestExecutor {
    public static void start(Class<?> testClass) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = testClass.getDeclaredMethods();
        boolean isSingletonBef = false;

        for (Method o : methods) {
            if (o.getAnnotation(BeforeSuite.class) != null) {
                if (!isSingletonBef) {
                    o.invoke(null);
                    isSingletonBef = true;
                } else {
                    throw new RuntimeException();
                }
            }
        }

        Map<Integer, Method> map = new TreeMap<>();

        for (Method o : methods) {
            if (o.getAnnotation(Test.class) != null) {
                map.put(o.getAnnotation(Test.class).priority(), o);
            }
        }

        map.forEach((key, value) -> {
            try {
                value.invoke(null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });

        boolean isSingletonAft = false;
        for (Method o : methods) {
            if (o.getAnnotation(AfterSuite.class) != null) {
                if (!isSingletonAft) {
                    o.invoke(null);
                    isSingletonAft = true;
                } else {
                    throw new RuntimeException();
                }
            }
        }
    }
}
