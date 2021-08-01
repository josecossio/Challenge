package com.company.model;

public class Podium {

    private String firstPlace;
    private String secondPlace;
    private String thirdPlace;

    public Podium(String firstPlace, String secondPlace, String thirdPlace) {
        this.firstPlace = firstPlace;
        this.secondPlace = secondPlace;
        this.thirdPlace = thirdPlace;
    }

    public String getFirstPlace() {
        return firstPlace;
    }

    public void setFirstPlace(String firstPlace) {
        this.firstPlace = firstPlace;
    }

    public String getSecondPlace() {
        return secondPlace;
    }

    public void setSecondPlace(String secondPlace) {
        this.secondPlace = secondPlace;
    }

    public String getThirdPlace() {
        return thirdPlace;
    }

    public void setThirdPlace(String thirdPlace) {
        this.thirdPlace = thirdPlace;
    }

    @Override
    public String toString(){

        return "Resultados de la carrera{" +
                "primer lugar: '" + firstPlace + '\'' +
                ", secondPlace='" + secondPlace + '\'' +
                ", thirdPlace='" + thirdPlace + '\'' +
                '}';

    }

}
