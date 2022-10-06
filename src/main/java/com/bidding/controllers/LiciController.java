package com.bidding.controllers;

import com.bidding.models.LiciModel;
import com.bidding.services.LiciService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3680)
@RequestMapping("/api/v1/publica/licitacoes")
public class LiciController {

    final LiciService liciService;

    public LiciController(LiciService liciService){
        this.liciService = liciService;
    }

}
