package com.jonas.test.stream;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ForkJoinPoolTester {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ForkJoinTask<?> task = new ForkJoinPool(3).submit(() -> {
            Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().forEach(i -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hello, " + i);
            });
            System.out.println("return foreach");
        });

        task.get();

        System.out.println("return main");
    }
}
