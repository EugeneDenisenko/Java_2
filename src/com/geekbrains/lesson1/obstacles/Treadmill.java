package com.geekbrains.lesson1.obstacles;

import com.geekbrains.lesson1.participants.Participant;

public class Treadmill implements Obstacle {
    private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    public boolean canOvercome(Participant participant) {
        return participant.run() >= distance;
    }

    @Override
    public String toString() {
        return "Treadmill";
    }
}
