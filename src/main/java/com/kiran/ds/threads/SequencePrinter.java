package com.kiran.ds.threads;

public class SequencePrinter {

    private int counter = 1;
    private int threshold;
    private int noOfThreads;

    public SequencePrinter(int threshold, int noOfThreads) {
        this.threshold = threshold;
        this.noOfThreads = noOfThreads;
    }

    private synchronized void printNumber(int remainder) {
        while(counter < threshold) {
            while(counter % noOfThreads != remainder){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " + counter);
            counter++;
            notifyAll();
        }
    }

    public static void main(String[] args) {
        SequencePrinter sequencePrinter = new SequencePrinter(10, 3);
        Thread t1 = new Thread(() -> sequencePrinter.printNumber(1), "T1");
        Thread t2 = new Thread(() -> sequencePrinter.printNumber(2), "T2");
        Thread t3 = new Thread(() -> sequencePrinter.printNumber(0), "T3");
        t1.start();
        t2.start();
        t3.start();
    }
}
