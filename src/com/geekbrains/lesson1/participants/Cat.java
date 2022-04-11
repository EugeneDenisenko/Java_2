package com.geekbrains.lesson1.participants;

public class Cat implements Participant {
    @Override
    public int run() {
        return 200;
    }

    @Override
    public int jump() {
        return 110;
    }

    @Override
    public String toString() {
        return "Cat";
    }
}
