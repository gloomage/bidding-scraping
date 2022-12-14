package com.bidding.enums;

import lombok.Getter;

@Getter
public enum UfsEnum {

    RO("Rondônia", 11),
    AC("Acre", 12),
    AM("Amazonas", 13),
    RR("Roraima", 14),
    PA("Pará", 15),
    AP("Amapá", 16),
    TO("Tocantins", 17),
    MA("Maranhão", 21),
    PI("Piauí", 22),
    CE("Ceará", 23),
    RN("Rio Grande do Norte", 24),
    PB("Paraíba", 25),
    PE("Pernambuco", 26),
    AL("Alagoas", 27),
    SE("Sergipe", 28),
    BA("Bahia", 29),
    MG("Minas Gerais", 31),
    ES("Espírito Santo", 32),
    RJ("Rio de Janeiro", 33),
    SP("São Paulo", 35),
    PR("Paraná", 41),
    SC("Santa Catarina", 42),
    RS("Rio Grande do Sul", 43),
    MS("Mato Grosso do Sul", 50),
    MT("Mato Grosso", 51),
    GO("Goiás", 52),
    DF("Distrito Federal", 53),
    EX("EXTERIOR - FORA DO BRASIL", 99);

    private String nomeUF;
    private int codigoUF;

    UfsEnum(String nomeUF, int codigoUF) {
        this.nomeUF = nomeUF;
        this.codigoUF = codigoUF;
    }
}
