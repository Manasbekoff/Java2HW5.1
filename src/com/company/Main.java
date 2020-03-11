package com.company;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore sema = new Semaphore(4, true);
        for (int i = 1; i < 101; i++) {
                Random x = new Random();
                int random = x.nextInt(4)+1;
                new Passengers(sema, i, random).start();
            }
        }
    }
