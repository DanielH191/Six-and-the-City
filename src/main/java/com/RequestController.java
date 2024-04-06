package com;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.logging.Logger;

import javax.servlet.http.*;

@Controller
public class RequestController extends HelpingMethods {

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
