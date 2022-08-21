package ru.gb.mandrik;

import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> list;

    public Box(List<T> list) {
        this.list = list;
    }

    public final void add(T... t) {
        list.addAll(Arrays.asList(t));
    }

    public double getWeight() {
        if (list.get(0) == null) {
            return 0;
        } else {
            return list.size() * list.get(0).getWeight();
        }
    }

    public boolean compare(Box<? extends Fruit> box) {
        return this.getWeight() == box.getWeight();
    }

    public void sprinkle(Box<T> box) {
        box.list.addAll(this.list);
        this.list.clear();
    }
}
