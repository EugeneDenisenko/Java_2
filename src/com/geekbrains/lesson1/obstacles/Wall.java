package com.geekbrains.lesson1.obstacles;

import com.geekbrains.lesson1.participants.Participant;

public class Wall implements Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public boolean canOvercome(Participant participant) {
        return participant.jump() >= height;
    }

    @Override
    public String toString() {
        return "Wall";
    }
}
