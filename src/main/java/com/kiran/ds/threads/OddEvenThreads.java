package com.kiran.ds.threads;

public class OddEvenThreads {

    private int counter = 1;
    private static int threshold = 10;

    public static void main(String[] args) {
        OddEvenThreads oddEvenThreads = new OddEvenThreads();
        Thread oddThread = new Thread(() -> oddEvenThreads.print(0), "Odd Thread");
        Thread evenThread = new Thread(() -> oddEvenThreads.print(1), "Even Thread");
        oddThread.start();
        evenThread.start();
    }

    public synchronized void print(int remainder) {
        while(counter < threshold) {
            while(counter % 2 == remainder) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " +counter);
            counter++;
            notify();
        }
    }
}
