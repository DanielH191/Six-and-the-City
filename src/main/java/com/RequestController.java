package com;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Logger;

import javax.servlet.http.*;

@Controller
public class RequestController extends HelpingMethods {

    @Autowired
    private TextSummarizerService textSummarizerService;
    @Autowired
    private Voice2TextService voice2TextService;


    private final String filePath = "C:\\Users\\a_n_n\\Documents\\Audioaufzeichnungen\\Emergency_call.m4a";

    private Logger logger = Logger.getLogger("RequestController.java");
    private final Main main;

    public RequestController(Main main) {
        this.main = main;

        // gameResultScraper.scrapeFromOldDatabase(9);

    }

    @GetMapping("/")
    public String index(
            Model model, HttpServletRequest request) {
        Const.addConstantsToModel(model);
        Incident incident = main.getIncident();
        main.addIncidentAttributesToModel(incident, model);

        model.addAttribute("incident", incident);
        model.addAttribute("attribut1", 1);
        return "index";
    }

    @GetMapping("/error")
    public String errorHandling(HttpServletRequest request) {
        // printConnectionDetails(request);

        return "error";
    }

    @GetMapping("/openAItext")
    @ResponseBody
    public String showFuckingOpenAIrespone() { //@RequestParam String text
        // Assuming textSummarizer.getDataFromText(text) retrieves data based on the provided text
        String text2 = "Hello? I live next to Guenther Jauch. Here is an Emergency at Wannsee Street 1. " +
                "I can hardly belief it. Saw two men with guns leaving his apartment. Please, send help now!";
        JsonNode reply = textSummarizerService.getDataFromText(text2);
        System.out.println(reply.toString());

        JsonNode choicesNode = reply.get("choices").get(0);
        JsonNode messageNode = choicesNode.get("message");
        String content = messageNode.get("content").asText();
        String[] parts = content.split("; ");

        // Extract location and occurrence from parts if splitting produced the expected number of parts
        String location = "";
        String occurrence = "";
        if (parts.length >= 2) {
            location = parts[0].split(": ")[1];
            occurrence = parts[1].split(": ")[1];
        } else {
            return "Location: could not parse; Occurrence: could not parse";
        }

        // Return extracted location and occurrence as a response
        return "Location: " + location + "; Occurrence: " + occurrence;
    }

    @GetMapping("/voiceToText")
    @ResponseBody
    public String getRecordingSummary() {
        JsonNode reply = voice2TextService.transcribeAudioFile(filePath);
        JsonNode choicesNode = reply.get("choices").get(0);
        JsonNode messageNode = choicesNode.get("message");
        String content = messageNode.get("content").asText();
        String[] parts = content.split("; ");

        // Extract location and occurrence from parts if splitting produced the expected number of parts
        String location = "";
        String occurrence = "";
        if (parts.length >= 2) {
            location = parts[0].split(": ")[1];
            occurrence = parts[1].split(": ")[1];
        } else {
            return "Location: " + location + "; Occurrence: " + occurrence;
        }

        // Return extracted location and occurrence as a response
        return "Location: " + location + "; Occurrence: " + occurrence;

    }

    public void printConnectionDetails(HttpServletRequest request)// ausgelagerte Printmethode
    {
        p(java.time.LocalDate.now() + " " + java.time.LocalTime.now());
        p("Ip: " + request.getRemoteAddr());
        Enumeration<String> e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String header = e.nextElement();
            p(header + ": " + request.getHeader(header));
        }
    }

    public String parseStringBuffer(String original) {
        int nrGaenzefuechschen = 0;
        String parsed = "";
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == 34) {
                nrGaenzefuechschen++;
            }
            if (nrGaenzefuechschen == 3 && nrGaenzefuechschen < 4) {
                parsed = parsed + original.charAt(i);
            }
        }
        if (parsed.startsWith("\"")) {
            parsed = parsed.substring(1);
        }
        return parsed;
    }
}
