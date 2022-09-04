package ru.gb.mandrik;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;
    private static boolean isWin;
    private CountDownLatch cdl;
    private CyclicBarrier finishBarrier;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch cdl, CyclicBarrier finish) {
        this.race = race;
        this.speed = speed;
        this.cdl = cdl;
        this.finishBarrier = finish;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    private void getWinner(String name) {
        if (!isWin) {
            System.out.println(name + " win!!!");
            isWin = true;
        }
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            cdl.countDown();
            System.out.println(this.name + " готов");
            cdl.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        getWinner(name);
        try {
            finishBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}