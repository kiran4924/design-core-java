package com.kiran.design.threads;

// Macquarie
public class RepeatSequencePrinter {

    private int count = 1;
    private int noOfThreads;
    private int noOfTimes;

    public RepeatSequencePrinter(int noOfThreads, int noOfTimes) {
        this.noOfThreads = noOfThreads;
        this.noOfTimes = noOfTimes;
    }

    public synchronized void printRepeatSequence(int remainder) {
        for(int i=0; i<noOfTimes; i++) {
            while(count % noOfThreads != remainder) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(Thread.currentThread().getName() + ": " + count + " ");
            if(count == noOfThreads) {
                System.out.println();
            }
            count++;
            if(count != noOfThreads) {
                count = count%noOfThreads;
            }
            notifyAll();
        }
    }

    public static void main(String[] args) {
        RepeatSequencePrinter repeatSequencePrinter = new RepeatSequencePrinter(3, 3);
        Thread t1 = new Thread(() -> repeatSequencePrinter.printRepeatSequence(1), "T1");
        Thread t2 = new Thread(() -> repeatSequencePrinter.printRepeatSequence(2), "T2");
        Thread t3 = new Thread(() -> repeatSequencePrinter.printRepeatSequence(0), "T3");

        t1.start();
        t2.start();
        t3.start();
    }
}
