package com;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Main extends HelpingMethods {

    List<Incident> incidentQueue = new ArrayList<Incident>();

    public Main() {
        incidentQueue.add(Const.defaultIncident);
    }

    public Incident getIncident() {
        if (incidentQueue.size() > 0)
            return incidentQueue.removeFirst();

        return null;
    }
}
