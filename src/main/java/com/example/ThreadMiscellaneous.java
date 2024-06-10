package com.example;

public class ThreadMiscellaneous {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        A obj = new A();
        Thread thread = new Thread(obj);
        thread.start();


    }
}

class A implements Runnable{
    @Override
    public void run() {
        Thread.currentThread().setName("SigmaMale");
        System.out.println(Thread.currentThread().getName());
    }
}
