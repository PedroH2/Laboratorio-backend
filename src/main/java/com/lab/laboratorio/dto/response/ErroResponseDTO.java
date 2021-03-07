package com.lab.laboratorio.dto.response;

public class ErroResponseDTO {

	private String campo;
	private String mensagem;
	
	public ErroResponseDTO(String mensagem) {
		this.mensagem = mensagem;
	}
}
