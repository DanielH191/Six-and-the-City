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

/*
	@GetMapping("/openAItext")
	public String showFuckingOpenAIrespone(String text){
		String text2 = "Someone broke into my house and wants to kill me.. ahhhhh.. Please help. Baumstrasse 25. Potsdam";
		JsonNode reply = textSummarizer.getDataFromText(text2);
		System.out.println(reply.toString());

		JsonNode choicesNode = reply.get("choices").get(0);
		JsonNode messageNode = choicesNode.get("message");
		String content = messageNode.get("content").asText();
		String[] parts = content.split("; ");
		System.out.println(parts.length);

		// Extract location and occurrence from parts
		String location = parts[0].split(": ")[1];
		String occurrence = parts[1].split(": ")[1];
		//return reply.asText();
		return "Location: " + location + "; Occurence: " + occurrence;
	}*/

	@GetMapping("/openAItext")
	@ResponseBody
	public String showFuckingOpenAIrespone(){ //@RequestParam String text
		// Assuming textSummarizer.getDataFromText(text) retrieves data based on the provided text
		String text2 = "Someone broke into my house and wants to kill me.. ahhhhh.. Please help. Baumstrasse 25. Potsdam";
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
			// Handle case where splitting didn't produce expected parts
			// You might want to log an error or provide a default response
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
}
