package com;

public class Incident {

    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String street;
    public String city;
    public int postalCode;
    public String timeOfCall;
    public String durationOfCall;
    public String description;

    public Incident(String firstName,
            String lastName,
            String street,
            String city,
            int postalCode,
            String timeOfCall,
            String durationOfCall,
            String description,
            String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.timeOfCall = timeOfCall;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.durationOfCall = durationOfCall;
        this.description = description;
        this.phoneNumber = phoneNumber;
    }
}
