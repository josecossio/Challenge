package com.company;

import com.company.model.Car;
import com.company.model.Pilot;
import com.company.model.Track;
import com.company.model.Podium;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        configureGame();

    }

    private static void configureGame() {

        Pilot firstPilot = new Pilot("Jian");
        Pilot secondPilot = new Pilot("Lian");
        Pilot thirdPilot = new Pilot("Ian");
        Pilot fourthPilot = new Pilot("Leon");

        Car firstCar = new Car(firstPilot, 0, 0);
        Car secondCar = new Car(secondPilot, 1, 0);
        Car thirdCar = new Car(thirdPilot, 2, 0);
        Car fourthCar = new Car(fourthPilot, 3, 0);

        Car[] cars = new Car[4];

        cars[0] = firstCar;
        cars[1] = secondCar;
        cars[2] = thirdCar;
        cars[3] = fourthCar;

        int[] positions = new int[4];
        positions[0] = firstCar.getPosition();
        positions[1] = secondCar.getPosition();
        positions[2] = thirdCar.getPosition();
        positions[3] = firstCar.getPosition();

        Track track = new Track(cars, 10000, positions);

        initGame(track);

    }

    private static void initGame(Track track) {
        int firsPosition = track.getCars()[0].getPosition();
        int secondPosition = track.getCars()[1].getPosition();
        int thirdPosition = track.getCars()[2].getPosition();
        int fourthPosition = track.getCars()[3].getPosition();

        while ( track.getCars()[0].getPosition() == track.getTrackLength() ||
                track.getCars()[1].getPosition() == track.getTrackLength() ||
                track.getCars()[2].getPosition() == track.getTrackLength() ||
                track.getCars()[3].getPosition() == track.getTrackLength()) {

            int random_int = (int) Math.floor(Math.random() * (6) + 1);
            int moveCar = random_int * 100;
            track.getCars()[0].setDistance(moveCar);
            track.getCars()[1].setDistance(moveCar);
            track.getCars()[2].setDistance(moveCar);
            track.getCars()[3].setDistance(moveCar);

            for (int i = 0; i < track.getCars().length;) {

                if (track.getCars()[i].getPosition() <= firsPosition &&
                        track.getCars()[i].getPosition() >= secondPosition &&
                        track.getCars()[i].getPosition() >= thirdPosition &&
                        track.getCars()[i].getPosition() >= fourthPosition) {
                    firsPosition = track.getCars()[0].getPosition();
                    secondPosition = track.getCars()[1].getPosition();
                    thirdPosition = track.getCars()[2].getPosition();
                    fourthPosition = track.getCars()[3].getPosition();
                } else if (track.getCars()[i+1].getPosition() <= firsPosition &&
                        track.getCars()[i+1].getPosition() <= secondPosition &&
                        track.getCars()[i+1].getPosition() >= secondPosition &&
                        track.getCars()[i+1].getPosition() >= secondPosition ){
                    firsPosition = track.getCars()[1].getPosition();
                    secondPosition = track.getCars()[0].getPosition();
                    thirdPosition = track.getCars()[2].getPosition();
                    fourthPosition = track.getCars()[3].getPosition();
                } else if (track.getCars()[i+2].getPosition() <= firsPosition &&
                        track.getCars()[i+2].getPosition() <= secondPosition &&
                        track.getCars()[i+2].getPosition() <= secondPosition &&
                        track.getCars()[i+2].getPosition() >= secondPosition ) {
                    firsPosition = track.getCars()[1].getPosition();
                    secondPosition = track.getCars()[2].getPosition();
                    thirdPosition = track.getCars()[0].getPosition();
                    fourthPosition = track.getCars()[3].getPosition();
                } else if (track.getCars()[i+3].getPosition() <= firsPosition &&
                        track.getCars()[i+3].getPosition() <= secondPosition &&
                        track.getCars()[i+3].getPosition() <= secondPosition &&
                        track.getCars()[i+3].getPosition() <= secondPosition ) {
                    firsPosition = track.getCars()[1].getPosition();
                    secondPosition = track.getCars()[2].getPosition();
                    thirdPosition = track.getCars()[3].getPosition();
                    fourthPosition = track.getCars()[0].getPosition();

                }
            }
        }

        Podium podium = new Podium(track.getCars()[0].getPilot().getName(), track.getCars()[1].getPilot().getName(),
                track.getCars()[2].getPilot().getName());

        saveGame(podium.toString());

    }

    private static void saveGame(String toString) {

        File archive = new File("Podium.txt");
        if (!archive.exists()) {
            try {
                archive.createNewFile();
                FileWriter writer = new FileWriter(archive, true);
                PrintWriter line = new PrintWriter(writer);
                line.println(toString);
                line.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            else {
                try {
                    FileWriter writer = new FileWriter(archive, true);
                    PrintWriter line = new PrintWriter(writer);
                    line.println(toString);
                    line.close();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
