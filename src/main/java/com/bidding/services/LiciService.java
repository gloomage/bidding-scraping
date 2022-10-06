package com.bidding.services;

import com.bidding.models.LiciModel;
import com.bidding.repositories.LiciRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LiciService {

    final LiciRepository liciRepository;

    public LiciService(LiciRepository liciRepository){
        this.liciRepository = liciRepository;
    }
}
