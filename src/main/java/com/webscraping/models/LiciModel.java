package com.webscraping.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_LICI")
public class LiciModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String data;

    @Column
    private String titulo;

    @Column
    private String objeto;

    @Column
    private String mes;

    @Column
    private String ano;

    @Column
    private String tipo;

    @Column
    private String modalidade;

    @Column
    private String link;
}
