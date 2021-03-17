package com.lab.laboratorio.dto.request;

import java.time.LocalDate;

import com.lab.laboratorio.enums.SituacaoTrabalho;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TrabalhoRequestDTO {

	private String cidade;
	private String dentista;
	private String paciente;
	private LocalDate dtEntrada;
	private LocalDate dtEntregaDesejada;
	private String trabalhoAExecutar;
	private String cor;
	private String metal;
	private String observacoes;
	private SituacaoTrabalho situacaoTrabalho;
}