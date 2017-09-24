package com.goit.homework;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SecondTask {
    ExecutorService threadpool;
    ArrayList<Double> allThreadsResult = new ArrayList();
    double oneN_result = 0;

    public void secondTaskStart()throws Exception {

        int size = 80000000;

        Scanner scn = new Scanner(System.in);

        System.out.println("Enter count of interation ('N') : ");
        int N = scn.nextInt();

        System.out.println("NO pool variant :");
        long startTime = System.nanoTime();
        for(int i = 0;i<N;i++){
            createThreads(size);
            System.out.println("Iteration number  " +i+" done");

            allThreadsResult.clear();
            oneN_result = 0;
        }
        long finalTime = System.nanoTime();
        System.out.println("Time without pool= " + (finalTime-startTime) + " nanoseconds");

        System.out.println("Variant with pool :");
        long startTime2 = System.nanoTime();
        for(int i = 0;i<N;i++){
            createThreadsPool(size);
            System.out.println("Iteration number  " +i+" done");

            allThreadsResult.clear();
            oneN_result = 0;
        }
        long finalTime2 = System.nanoTime();
        System.out.println("Time with pool = " + (finalTime2-startTime2) + " nanoseconds");

        threadpool.shutdown();

    }

    private double createThreads(int size) throws Exception{

        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int elementsPerThread = size / availableProcessors;

        for (int i = 0; i < availableProcessors; i++) {
            int tempI = i;

            Thread thread = new Thread(() -> {
                double oneThreadResult = 0;
                for (int j = elementsPerThread * tempI; j < elementsPerThread * (tempI + 1); j++) {
                    oneThreadResult = oneThreadResult + (Math.sin(j) + Math.cos(j));
                }
                allThreadsResult.add(oneThreadResult);
            });
            thread.start();
        }


        return createResult(availableProcessors);
    }

    private double createThreadsPool(int size) throws Exception{

        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int elementsPerThread = size / availableProcessors;

        threadpool = Executors.newFixedThreadPool(availableProcessors);

        for(int i =0;i<availableProcessors;i++) {
            int tempI = i;

            Runnable runnable =new Runnable() {
                @Override
                public void run() {
                    double oneThreadResult = 0;
                    for (int j = elementsPerThread * tempI; j < elementsPerThread * (tempI + 1); j++) {
                        oneThreadResult = oneThreadResult + (Math.sin(j) + Math.cos(j));
                    }
                    allThreadsResult.add(oneThreadResult);
                }
            };

            threadpool.submit(runnable);
        }

        return createResult(availableProcessors);
    }

    private double createResult( int availableProcessors) throws Exception{

        if (allThreadsResult.size() == availableProcessors) {
            for (int i = 0; i < availableProcessors; i++){
                oneN_result = oneN_result + allThreadsResult.get(i);
            }
            return oneN_result;
        }

        Thread.sleep(2000);

        return createResult(availableProcessors);
    }
}
