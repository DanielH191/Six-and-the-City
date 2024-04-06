package com;

import java.util.logging.Logger;

import org.springframework.ui.Model;

public class Const {
    private static Logger logger = Logger.getLogger("Constants.java");
    private static HelpingMethods h = new HelpingMethods();

    public static boolean websiteOutOfOrder() {
        return h.getDateNow("HH").equals("23") && Integer.parseInt(h.getDateNow("mm")) > 45;
    }

    public static final String firstNameLabel = "First Name";
    public static final String lastNameLabel = "Last Name";
    public static final String phoneNumberLabel = "Phone Number";
    public static final String streetLabel = "Street";
    public static final String cityLabel = "City";
    public static final String descriptionLabel = "Description";
    public static final String emergencyCodeLabel = "Emergency code";

    public static final String city = "Potsdam";
    public static final int postalCode = 14467;
    public static final String durationOfCall = "01:57";
    public static final String phoneNumber = "01574183219";

    public static final Incident defaultIncident = new Incident("Peter",
            "Pan",
            "Sonnenstraße 5",
            "Potsdam",
            14467,
            "04.07.2023 16:51",
            "01:57",
            "Im Haus L ist im ersten Stock jemand verrückt geworden.",
            "01574183219");

    public static final EmergencyUnit[] emergencyUnits = new EmergencyUnit[] {
            new EmergencyUnit("PC 45-82-01", 2, 0.5, "00:32"),
            new EmergencyUnit("PC 45-83-03", 1, 1.7, "03:10"),
            new EmergencyUnit("PC 45-92-01", 2, 4.2, "06:47")
    };

    public static final String[] emergencyCodes = new String[] {
            "Armed robbery",
            "Traffic accident",
            "Domestic violence",
            "Murder"

    };

    public static void addConstantsToModel(Model model) {
        model.addAttribute("descriptionLabel", descriptionLabel);
        model.addAttribute("emergencyCodeLabel", emergencyCodeLabel);
        model.addAttribute("emergencyCodes", emergencyCodes);
        model.addAttribute("emergencyUnits", emergencyUnits);
    }
}
