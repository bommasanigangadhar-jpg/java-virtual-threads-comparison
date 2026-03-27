package com.virtual.threads.demo;

import java.util.ArrayList;
import java.util.List;

public class PlatFormThreadsDemo {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        List<Thread> threads = new ArrayList<>();
        for (int index = 0; index < 100_000; index++) {
            Thread thread = new Thread( () -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex){
                    //error
                }
            });
            thread.start();
            threads.add(thread);
        }

        for(Thread thread: threads) {
            thread.join();
        }

        System.out.println("Time: " + (System.currentTimeMillis() - start) + "ms");
    }
}
