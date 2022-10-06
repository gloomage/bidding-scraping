package com.bidding.enums;

public enum MesEnum {

    JAN("JANEIRO", 1),
    FEV("FEVEREIRO", 2),
    MAR("MARÇO", 3),
    ABR("ABRIL", 4),
    MAI("MAIO", 5),
    JUN("JUNHO", 6),
    JUL("JULHO", 7),
    AGO("AGOSTO", 8),
    SET("SETEMBRO", 9),
    OUT("OUTUBRO", 10),
    NOV("NOVEMBRO ", 11),
    DEZ("DEZEMBRO", 12);

    private final String nomMes;
    private final Integer seqMes;


    MesEnum(String nomMes, Integer seqMes) {
        this.nomMes = nomMes;
        this.seqMes = seqMes;
    }
}
