package ru.gb.mandrik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TestMain {

    Main main = new Main();

    @ParameterizedTest
    @MethodSource("testMArgumentsProvider")
    void testM(int[] arr, String res) {
        Assertions.assertEquals(res, main.m(arr));
    }

    @ParameterizedTest
    @MethodSource("testCheckArrayArgumentsProvider")
    void testCheckArr(int[] arr, boolean res) {
        Assertions.assertEquals(res, main.checkArray(arr));
    }

    private static Stream<Arguments> testMArgumentsProvider() {
        return Stream.of(
                Arguments.of(new int[]{4, 4, 4, 4, 4, 4}, ""),
                Arguments.of(new int[]{4}, ""),
                Arguments.of(new int[]{1, 3, 4, 2, 5}, "25")
        );
    }

    private static Stream<Arguments> testCheckArrayArgumentsProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 4, 1, 4, 1, 4}, true),
                Arguments.of(new int[]{4}, true),
                Arguments.of(new int[]{1, 0, 4, 2, 5}, false)
        );
    }

    @Test
    void testMRuntimeException() {
        Assertions.assertThrows(RuntimeException.class,
                () -> main.m(new int[]{}));
    }
}