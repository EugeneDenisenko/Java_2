package com.geekbrains.lesson1.obstacles;

import com.geekbrains.lesson1.participants.Participant;

public interface Obstacle {
    boolean canOvercome(Participant participant);
}
