package com.lab.laboratorio.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class TotalFatObj {

    private int qtdTrabalhos;
    private int qtdDiasPesquisados;
    private Long totalFaturado;
    private LocalDate dtParamInicial;
    private LocalDate dtParamFinal;

}
