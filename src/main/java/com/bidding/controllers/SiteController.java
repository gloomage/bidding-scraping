package com.bidding.controllers;

import com.bidding.dtos.SiteDto;
import com.bidding.models.LiciModel;
import com.bidding.models.SiteModel;
import com.bidding.services.MuniService;
import com.bidding.services.SiteService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3680)
@RequestMapping("/api/v1/publica/sites")
public class SiteController {

    final SiteService siteService;
    final MuniService muniService;

    public SiteController(SiteService siteService, MuniService muniService){
        this.siteService = siteService;
        this.muniService = muniService;
    }

    @GetMapping
    public ResponseEntity<List<SiteModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(siteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSite(@PathVariable(value = "id") UUID id){
        Optional<SiteModel> siteModelOptional = siteService.findById(id);
        if(!siteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Site not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(siteModelOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> saveSite (@RequestBody SiteDto siteDto){
        var siteModel = new SiteModel();
        BeanUtils.copyProperties(siteDto, siteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(siteService.save(siteModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSite(@PathVariable(value = "id") UUID id, @RequestBody SiteDto siteDto){
        Optional<SiteModel> siteModelOptional = siteService.findById(id);
        if(!siteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Site not found.");
        }
        var siteModel = new SiteModel();
        BeanUtils.copyProperties(siteDto, siteModel);
        siteModel.setId(siteModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(siteService.save(siteModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSite(@PathVariable(value = "id") UUID id){
        Optional<SiteModel> siteModelOptional = siteService.findById(id);
        if(!siteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Site not found.");
        }
        siteService.delete(siteModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Site deleted successfully.");
    }

    @PostMapping("/licitacoes/{id}")
    public ResponseEntity<List<LiciModel>> extrairLicitacoes(@PathVariable(value = "id") UUID id) throws IOException {
        Optional<SiteModel> siteModelOptional = siteService.findById(id);
        if(!siteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
        }
        return ResponseEntity.status(HttpStatus.OK).body(siteService.extrairLicitacoes(siteModelOptional.get()));
    }
}
