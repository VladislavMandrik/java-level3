package ru.gb.mandrik;

public class WaitNotifyClass {
    private final Object mon = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        WaitNotifyClass waitNotifyObj = new WaitNotifyClass();
        Thread thread1 = new Thread(waitNotifyObj::printA);
        Thread thread2 = new Thread(waitNotifyObj::printB);
        Thread thread3 = new Thread(waitNotifyObj::printC);
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public void printA() {
        for (int i = 0; i < 5; i++) {
            synchronized (mon) {
                try {
                    while (currentLetter != 'A')
                        mon.wait();
                    System.out.print(currentLetter);
                    currentLetter = 'B';
                    mon.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void printB() {
        for (int i = 0; i < 5; i++) {
            synchronized (mon) {
                try {
                    while (currentLetter != 'B')
                        mon.wait();
                    System.out.print(currentLetter);
                    currentLetter = 'C';
                    mon.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void printC() {
        for (int i = 0; i < 5; i++) {
            synchronized (mon) {
                try {
                    while (currentLetter != 'C')
                        mon.wait();
                    System.out.print(currentLetter);
                    currentLetter = 'A';
                    mon.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

