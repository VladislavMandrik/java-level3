package ru.gb.mandrik;

import java.util.ArrayList;
import java.util.Arrays;

public class MainFruitsInBoxes {
    public static void main(String[] args) {
        Box<Apple> box = new Box<>(new ArrayList<>());
        Box<Apple> box1 = new Box<>(new ArrayList<>());
        Box<Orange> orangeBox = new Box<>(new ArrayList<>());
        Box<GoldenApple> goldenAppleBox = new Box<>(new ArrayList<>());

        Apple[] apples = new Apple[16];
        Arrays.fill(apples, new Apple());
        box.add(apples);

        box1.add(new Apple(), new Apple(), new Apple());

        orangeBox.add(new Orange(), new Orange());

        goldenAppleBox.add(new GoldenApple(), new GoldenApple());

        System.out.println(box.getWeight());

        System.out.println(orangeBox.getWeight());

        System.out.println(orangeBox.compare(box));
        box.sprinkle(box1);

        System.out.println(box1.getWeight());
        System.out.println(goldenAppleBox.getWeight());
    }
}
