package com.geekbrains.lesson1.participants;

public class Human implements Participant {
    @Override
    public int run() {
        return 3_000;
    }

    @Override
    public int jump() {
        return 150;
    }

    @Override
    public String toString() {
        return "Human";
    }
}
