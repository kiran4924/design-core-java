package com.kiran.ds.threads;

public class SenderReceiver {

    private String packet;

    // True if receiver should wait
    // False if sender should wait
    private boolean transfer = true;

    public synchronized void send(String packet) {
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        transfer = false;

        this.packet = packet;
        notifyAll();
    }

    public synchronized String receive() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        transfer = true;

        notifyAll();
        return packet;
    }

    public static void main(String[] args) {
        SenderReceiver senderReceiver = new SenderReceiver();
        Thread sender = new Thread(() -> {
            String[] data = {"1st packet", "2nd packet", "3rd packet", "4th packet", "End"};
            for(String packet : data) {
                System.out.println("Sending: " + packet);
                senderReceiver.send(packet);
            }
        });
        Thread receiver = new Thread(() -> {
            for(String packet = senderReceiver.receive(); packet != "End"; packet = senderReceiver.receive()) {
                System.out.println("Received: " + packet);
            }
        });
        sender.start();
        receiver.start();
    }
}
