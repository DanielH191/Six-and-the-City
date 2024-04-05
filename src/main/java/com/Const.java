package com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Logger;

import org.springframework.ui.Model;

public class Const {
    private static Logger logger = Logger.getLogger("Constants.java");
    private static HelpingMethods h = new HelpingMethods();

    public static boolean websiteOutOfOrder() {
        return h.getDateNow("HH").equals("23") && Integer.parseInt(h.getDateNow("mm")) > 45;
    }

    public static void addConstantsToModel(Model model) {
        model.addAttribute("xyz", 1412);
    }

}
