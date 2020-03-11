package com.company;

import java.util.concurrent.Semaphore;

public class Passengers extends Thread {
    Semaphore semaphore;
    private int passengersId;
    private int checkoutId;

    public Passengers(Semaphore sema, int passengers, int checkout) {
        this.passengersId = passengers;
        this.checkoutId = checkout;
        this.semaphore = sema;
    }

    public synchronized void run() {
        try {
            semaphore.acquire();
                System.out.println("Пассажир " + passengersId + " подходит к кассе: " + checkoutId);
                System.out.println("Пассажир " + passengersId + " отходит от кассы: " + checkoutId);
                semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
