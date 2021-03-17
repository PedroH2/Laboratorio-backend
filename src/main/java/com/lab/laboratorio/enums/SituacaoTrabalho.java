package com.lab.laboratorio.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SituacaoTrabalho {
	
	ABERTO("A"),
	FECHADO("F"),
	SUSPENSO("C");

	private String codigo;
}