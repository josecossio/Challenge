package com.company.model;

public class Track {

    private Car[] cars;
    private int trackLength;
    private int[] lanes;

    public Track(Car[] cars, int trackLength, int[] lanes) {
        this.cars = cars;
        this.trackLength = trackLength;
        this.lanes = lanes;
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    public int getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(int trackLength) {
        this.trackLength = trackLength;
    }

    public int[] getLanes() {
        return lanes;
    }

    public void setLanes(int[] lanes) {
        this.lanes = lanes;
    }
}
