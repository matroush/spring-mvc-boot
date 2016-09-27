package com.corssover.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/beat")
public class HeartBeatController {

    @RequestMapping(value = "/text")
    @PreAuthorize("hasRole('test')")
    public String text() {
        return "text";
    }

    @RequestMapping(value = "/secure")
    @PreAuthorize("hasRole('test')")
    public String secureText() {
        return "Secure Text";
    }


}
