package com.geekbrains.lesson1;

public class Robot implements Participant {
    @Override
    public int run() {
        return 15_000;
    }

    @Override
    public int jump() {
        return 30;
    }

    @Override
    public String toString() {
        return "Robot";
    }
}
