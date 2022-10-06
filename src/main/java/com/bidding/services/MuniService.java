package com.bidding.services;

import com.bidding.models.MuniModel;
import com.bidding.repositories.MuniRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MuniService {

    final MuniRepository muniRepository;

    public MuniService(MuniRepository muniRepository){
        this.muniRepository = muniRepository;
    }

    public List<MuniModel> findAll() {
        return muniRepository.findAll();
    }

    @Transactional
    public MuniModel save(MuniModel muniModel) {
        return muniRepository.save(muniModel);
    }

    public Optional<MuniModel> findById(UUID id) {
        return muniRepository.findById(id);
    }

    @Transactional
    public void delete(MuniModel muniModel) {
        muniRepository.delete(muniModel);
    }
}
