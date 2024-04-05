package com;

public class Incident {

    public String firstName;
    public String lastName;
    public String location;
    public String timeOfCall;
    public String durationOfCall;
    public String fullTranscript;

    public Incident(String firstName,
            String lastName,
            String location,
            String timeOfCall,
            String durationOfCall,
            String fullTranscript) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.timeOfCall = timeOfCall;
        this.durationOfCall = durationOfCall;
        this.fullTranscript = fullTranscript;
    }
}
