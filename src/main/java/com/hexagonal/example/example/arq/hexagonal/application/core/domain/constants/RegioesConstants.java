package com.hexagonal.example.example.arq.hexagonal.application.core.domain.constants;

import java.util.List;

public class RegioesConstants {
    public static final List<String> NORDESTE = List.of("CE", "RN", "BA", "PB", "PE", "AL", "PI", "MA", "SE");
    public static final List<String> NORTE = List.of("RR", "AP", "PA", "TO", "RO", "AC", "AM");
    public static final List<String> CENTRO_OESTE = List.of("MT", "GO", "MS");
    public static final List<String> SUDESTE = List.of("SP", "RJ", "ES", "MG");
    public static final List<String> SUL = List.of("RS", "SC", "PR");
    public static final Double VALOR_FRETE_NORDESTE = 15.98;
    public static final Double VALOR_FRETE_NORTE = 20.83;
    public static final Double VALOR_FRETE_CENTRO_OESTE = 12.50;
    public static final Double VALOR_FRETE_SUDESTE = 7.85;
    public static final Double VALOR_FRETE_SUL = 17.30;
}
