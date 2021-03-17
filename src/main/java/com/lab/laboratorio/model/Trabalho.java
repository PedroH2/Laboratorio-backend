package com.lab.laboratorio.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lab.laboratorio.enums.SituacaoTrabalho;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name= "db_trabalho")
public class Trabalho {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 100, nullable = true)
	private String cidade;
	
	@Column(length = 100, nullable = false)
	private String dentista;
	
	@Column(length = 100, nullable = false)
	private String paciente;
	
	@Column
	private LocalDate dtEntrada;
	
	@Column
	private LocalDate dtEntregaDesejada;
	
	@Column(length = 100, nullable = false)
	private String trabalhoAExecutar;
	
	@Column(length = 50, nullable = true)
	private String cor;
	
	@Column(length = 50, nullable = true)
	private String metal;
	
	@Column(length = 1000, nullable = true)
	private String observacoes;
	
	@Column
	private SituacaoTrabalho situacaoTrabalho;

}
