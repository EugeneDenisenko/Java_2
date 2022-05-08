package com.geekbrains.lesson5;

public class HomeWorkApp5 {

    private static final int SIZE = 10_000_000;
    private static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        method1();
        method2();
    }

    private static void method1() {
        float[] array = new float[SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + (float) i / 2));
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("Время выполнения однопоточного метода = " + (finishTime - startTime) + "ms.");
    }

    private static void method2() {
        float[] array = new float[SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        float[] firstHalfArray = new float[HALF];
        float[] secondHalfArray = new float[HALF];
        Thread thread1 = new Thread(() -> {
            System.arraycopy(array, 0, firstHalfArray, 0, HALF);
            for (int i = 0; i < HALF; i++) {
                firstHalfArray[i] = (float) (firstHalfArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + (float) i / 2));
            }
        });
        Thread thread2 = new Thread(() -> {
            System.arraycopy(array, HALF, secondHalfArray, 0, HALF);
            for (int i = HALF; i < SIZE; i++) {
                secondHalfArray[i - HALF] = (float) (secondHalfArray[i - HALF] * Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) * Math.cos(0.4f + (float) i / 2));
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(firstHalfArray, 0, array, 0, HALF);
        System.arraycopy(secondHalfArray, 0, array, HALF, HALF);
        long finishTime = System.currentTimeMillis();
        System.out.println("Время выполнения многопоточного метода = " + (finishTime - startTime) + "ms.");
    }
}
