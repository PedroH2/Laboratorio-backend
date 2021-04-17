package com.lab.laboratorio.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.lab.laboratorio.enums.SituacaoTrabalho;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonInclude(Include.NON_NULL)
public class TrabalhoResponseDTO {
	
	private Long id;
	private String cidade;
	private String dentista;
	private String paciente;
	private String trabalhoAExecutar;
	private LocalDate dtEntrada;
	private LocalDate dtEntregaDesejada;
	private String cor;
	private String metal;
	private String observacoes;
	private SituacaoTrabalho situacaoTrabalho;
	private BigDecimal valorTrabalho;
	private LocalDate dtFinalizacao;
	private String colaboradorResponsavel;
}
