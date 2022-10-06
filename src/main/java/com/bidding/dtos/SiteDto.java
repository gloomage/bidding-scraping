package com.bidding.dtos;

import com.bidding.models.MuniModel;
import lombok.Data;

import java.net.URL;
@Data
public class SiteDto {

    private MuniModel municipio;

    private String nomsite;

    private URL urlsite;

    private String tabsite;
}
