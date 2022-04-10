package com.geekbrains.lesson1;

import com.geekbrains.lesson1.obstacles.*;

public class HomeWorkApp1 {
    public static void main(String[] args) {

        Obstacle treadmill = new Treadmill(3000);
        Obstacle wall = new Wall(100);
        Participant human = new Human();
        Participant cat = new Cat();
        Participant robot = new Robot();

        Obstacle[] obstacleArray = getObstaclesArray(treadmill, wall);
        Participant[] participantArray = getMovableArray(human, cat, robot);

        for (Participant participant : participantArray) {
            boolean shot = true;
            for (Obstacle obstracle : obstacleArray) {
                if (shot && obstracle.getClass() == Treadmill.class) {
                    if (((Treadmill) obstracle).canRun(participant)) {
                        System.out.println(participant + " осилил беговую дорожку.");
                    } else {
                        System.out.println(participant + " НЕ осилил беговую дорожку.");
                        shot = false;
                    }
                }
                if (shot && obstracle.getClass() == Wall.class) {
                    if (((Wall) obstracle).canJump(participant)) {
                        System.out.println(participant + " осилил стену.");
                    } else {
                        System.out.println(participant + " НЕ осилил стену.");
                        shot = false;
                    }
                }
            }
            System.out.println("----------------");
        }
    }

    public static Obstacle[] getObstaclesArray(Obstacle... obstacles) {
        return obstacles;
    }

    public static Participant[] getMovableArray(Participant... participants) {
        return participants;
    }
}
