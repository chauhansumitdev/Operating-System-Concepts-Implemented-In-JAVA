package com.example;

class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public synchronized int getCount() {
        return count;
    }
}

class Worker extends Thread {
    private Counter counter;
    private boolean increment;

    public Worker(Counter counter, boolean increment) {
        this.counter = counter;
        this.increment = increment;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (increment) {
                counter.increment();
            } else {
                counter.decrement();
            }
        }
    }
}

public class SynchronisationTest {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Worker incrementWorker = new Worker(counter, true);
        Worker decrementWorker = new Worker(counter, false);

        incrementWorker.start();
        decrementWorker.start();

        incrementWorker.join();
        decrementWorker.join();

        System.out.println("Final count: " + counter.getCount());
    }
}