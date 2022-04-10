package com.geekbrains.lesson1.obstacles;

import com.geekbrains.lesson1.Participant;

public class Wall implements Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public boolean canJump(Participant participant) {
        return participant.jump() >= height;
    }
}
