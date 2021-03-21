package com.lab.laboratorio.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErroResponseDTO {

	private String campo;
	private String mensagem;
	
	public ErroResponseDTO(String mensagem) {
		this.mensagem = mensagem;
	}
}
