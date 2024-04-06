package com;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class Main extends HelpingMethods {

    List<Incident> incidentQueue = new ArrayList<Incident>();

    public Main() {
        incidentQueue.add(Const.defaultIncident);
    }

    public Incident getIncident() {
        if (incidentQueue.size() > 0)
            return incidentQueue.get(0);

        return null;
    }

    public void addIncidentAttributesToModel(Incident incident, Model model) {
        String[] attributeLabels = new String[] {
                Const.firstNameLabel,
                Const.lastNameLabel,
                Const.phoneNumberLabel,
                Const.streetLabel,
                Const.cityLabel
        };
        String[] attributes = new String[attributeLabels.length];

        for (int i = 0; i < attributeLabels.length; i++)
            attributes[i] = labelToAttribute(attributeLabels[i], incident);

        model.addAttribute("attributeLabels", attributeLabels);
        model.addAttribute("attributes", attributes);

        model.addAttribute("descriptionLabel", Const.descriptionLabel);
        model.addAttribute("description", incident.description);
        model.addAttribute("callDuration", incident.durationOfCall);

    }

    public String labelToAttribute(String label, Incident incident) {
        switch (label) {
            case Const.firstNameLabel:
                return incident.firstName;
            case Const.lastNameLabel:
                return incident.lastName;
            case Const.phoneNumberLabel:
                return incident.phoneNumber;
            case Const.cityLabel:
                return incident.city;
            case Const.streetLabel:
                return incident.street;
            case Const.descriptionLabel:
                return incident.description;
            default:
                return "fehlendes Attributmapping";
        }
    }
}
