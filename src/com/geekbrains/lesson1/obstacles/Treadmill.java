package com.geekbrains.lesson1.obstacles;

import com.geekbrains.lesson1.Participant;

public class Treadmill implements Obstacle {
    private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    public boolean canRun(Participant participant) {
        return participant.run() >= distance;
    }
}
