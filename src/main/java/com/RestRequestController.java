package com;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestRequestController extends HelpingMethods {

    private final Main main;

    public RestRequestController(Main main) {
        this.main = main;
    }

    @PostMapping("/abc")
    public String xyz(@RequestBody String cell) {

        return "";
    }
}
