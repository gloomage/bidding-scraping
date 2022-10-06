package com.bidding.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.net.URL;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_SITE")
public class SiteModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "muni_id")
    private MuniModel municipio;

    @Column
    private String nomsite;

    @Column
    private URL urlsite;

    @Column
    private String tabsite;

}
