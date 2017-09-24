package com.goit.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FirstTask {

    public void task1Star() throws InterruptedException {
        try {
            Scanner scn = new Scanner(System.in);
            System.out.println("First number :");
            double a = scn.nextDouble();
            System.out.println("Your symbol(+,-,*,/,%,==,>,<) :");
            String tmp = scn.nextLine();
            String c = scn.nextLine();
            System.out.println("Second number :");
            double b = scn.nextDouble();

            String result = task1Tread(c, a, b);

            System.out.println(result);
        } catch (InputMismatchException exc) {
            System.out.println("Wrong symbol!!!");
        }
    }

    private String task1Tread(String c, double a, double b) throws InterruptedException {

        Thread thread = new Thread(() -> {
            String result = "";
            Double tmp = (double) 0;


            switch (c) {
                case "+":
                    tmp = (a + b);
                    result = tmp.toString();
                    break;
                case "-":
                    tmp = a - b;
                    result = tmp.toString();
                    break;
                case "*":
                    tmp = a * b;
                    result = tmp.toString();
                    break;
                case "/":
                    tmp = a / b;
                    result = tmp.toString();
                    break;
                case "%":
                    tmp = a % b;
                    result = tmp.toString();
                    break;
                case "==":
                    result = a == b ? "true" : "false";
                    break;
                case ">":
                    result = a > b ? "true" : "false";
                    break;
                case "<":
                    result = a < b ? "true" : "false";
                    break;

                default:
                    System.out.println("���� �������");
            }


            Thread threads = Thread.currentThread();
            threads.setName(result);
        });
        thread.start();
        thread.join();


        return thread.getName().toString();
    }
}
