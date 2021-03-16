package com.lab.laboratorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.laboratorio.dto.request.TrabalhoRequestDTO;
import com.lab.laboratorio.dto.response.ResponseDTO;
import com.lab.laboratorio.dto.response.TrabalhoResponseDTO;
import com.lab.laboratorio.model.Trabalho;
import com.lab.laboratorio.service.TrabalhoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/trabalho")
@Slf4j
public class TrabalhoController {

	private TrabalhoService service;
	
	public TrabalhoController(TrabalhoService service) {
		this.service = service;
	}
	
	@PostMapping("/cadastra")
	public ResponseEntity<ResponseDTO<TrabalhoResponseDTO>> cadastra(@RequestBody TrabalhoRequestDTO requestDTO){
		log.debug("Iniciando processo de POST no endpoint: /api/v1/trabalho/cadastra", requestDTO);
		TrabalhoResponseDTO trabalhoResponseDTO = service.cadastra(requestDTO);
		log.debug("Finalizando processo de POST no endpoint: /api/v1/trabalho/cadastra", trabalhoResponseDTO);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseDTO<>(trabalhoResponseDTO));
	}
	@GetMapping("/busca")
	public ResponseEntity<ResponseDTO<List<TrabalhoResponseDTO>>> busca(){
		log.debug("Iniciando processo de GET no endpoint: /api/v1/trabalho/busca");
		List<TrabalhoResponseDTO> trabalhoResponseDTO = service.busca();
		log.debug("Finalizando processo de GET no enpoint: /api/v1/trabalho/busca");
		return ResponseEntity.ok(new ResponseDTO<>(trabalhoResponseDTO));
	}
	@GetMapping("/busca/{id}")
	public ResponseEntity<ResponseDTO<TrabalhoResponseDTO>> buscaPorId(@PathVariable Long id) throws Exception{
		log.debug("Iniciando processo de GET no endpoint: /api/v1/trabalho/busca/id");
		TrabalhoResponseDTO trabalhoResponseDTO = service.buscaPorId(id);
		log.debug("Finalizando processo de GET no endpoint: /api/v1/trabalho/busca/id");
		return ResponseEntity.ok(new ResponseDTO<>(trabalhoResponseDTO));
	}
	
	@PutMapping("/altera/{id}")
	public ResponseEntity<ResponseDTO<Void>> altera(@PathVariable Long id, @RequestBody TrabalhoRequestDTO trabalhoRequestDTO){
		log.debug("Iniciando processo de PUT no endpoint: /api/v1/trabalho/altera/id", id, trabalhoRequestDTO);
		service.altera(id, trabalhoRequestDTO);
		log.debug("Finalizando processo de PUT no endpoint: /api/v1/trabalho/altera/id", id, trabalhoRequestDTO);
		return ResponseEntity.accepted().build();
	
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Trabalho> deleta(@PathVariable Long id){
		log.debug("Iniciando processo de DELETE no endpoint: /api/v1/trabalho/id", id);
		log.debug("Finalizando processo de DELETE no endpoint: /api/v1/trabalho/id", id);
		service.deleta(id);
		return ResponseEntity.ok().body(null);
		
	}
}
