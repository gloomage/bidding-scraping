package com.bidding.controllers;

import com.bidding.dtos.MuniDto;
import com.bidding.enums.UfsEnum;
import com.bidding.models.MuniModel;
import com.bidding.services.MuniService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3680)
@RequestMapping("/api/v1/publica/municipios")
public class MuniController {

    final MuniService muniService;

    public MuniController(MuniService muniService){
        this.muniService = muniService;
    }

    @GetMapping
    public ResponseEntity<List<MuniModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(muniService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getMuni(@PathVariable(value = "id") UUID id){
        Optional<MuniModel> muniModelOptional = muniService.findById(id);
        if(!muniModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Muni not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(muniModelOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> saveMuni (@RequestBody MuniDto muniDto){
        var muniModel = new MuniModel();
        BeanUtils.copyProperties(muniDto, muniModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(muniService.save(muniModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMuni(@PathVariable(value = "id") UUID id, @RequestBody MuniDto muniDto){
        Optional<MuniModel> muniModelOptional = muniService.findById(id);
        if(!muniModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Muni not found.");
        }
        var muniModel = new MuniModel();
        BeanUtils.copyProperties(muniDto, muniModel);
        muniModel.setId(muniModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(muniService.save(muniModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMuni(@PathVariable(value = "id") UUID id){
        Optional<MuniModel> muniModelOptional = muniService.findById(id);
        if(!muniModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Muni not found.");
        }
        muniService.delete(muniModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Muni deleted successfully.");
    }
}
