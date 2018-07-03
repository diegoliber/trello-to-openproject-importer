package com.github.dieogoliber.openproject.trelloimporter.web.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class HealthController {
	
	@RequestMapping(value = "/health", method = RequestMethod.GET, produces=MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<?> health() {
		
        return ResponseEntity.ok("Service online");
    }

}
