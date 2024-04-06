package com;

public class EmergencyUnit {
    public String name;
    public int agentAmount;
    public double distanceInKm;
    public String travelDuration;

    public EmergencyUnit(String name, int agentAmount, double distanceInKm, String travelDuration) {
        this.name = name;
        this.agentAmount = agentAmount;
        this.distanceInKm = distanceInKm;
        this.travelDuration = travelDuration;
    }
}
