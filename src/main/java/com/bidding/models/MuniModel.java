package com.bidding.models;

import com.bidding.enums.UfsEnum;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_MUNI")
public class MuniModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String nommuni;

    @Column
    private UfsEnum ufsmuni;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "municipio"
    )
    private List<SiteModel> sites;
}
