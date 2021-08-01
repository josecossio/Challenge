package com.company.model;

public class Car {

    private Pilot pilot;
    private int position;
    private int distance;

    public Car(Pilot pilot, int position, int distance) {
        this.pilot = pilot;
        this.position = position;
        this.distance = distance;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
