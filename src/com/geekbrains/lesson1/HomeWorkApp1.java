package com.geekbrains.lesson1;

import com.geekbrains.lesson1.obstacles.*;
import com.geekbrains.lesson1.participants.Cat;
import com.geekbrains.lesson1.participants.Human;
import com.geekbrains.lesson1.participants.Participant;
import com.geekbrains.lesson1.participants.Robot;

public class HomeWorkApp1 {
    public static void main(String[] args) {

        Treadmill treadmill = new Treadmill(3000);
        Wall wall = new Wall(100);
        Human human = new Human();
        Cat cat = new Cat();
        Robot robot = new Robot();

        Obstacle[] obstacleArray = {treadmill, wall};
        Participant[] participantArray = {human, cat, robot};

        for (Participant participant : participantArray) {
            for (Obstacle obstacle : obstacleArray) {
                if (obstacle.canOvercome(participant)) {
                    System.out.println(participant + " осилил " + obstacle);
                } else {
                    System.out.println(participant + " НЕ осилил " + obstacle);
                    break;
                }
            }
            System.out.println("----------------");
        }
    }
}
