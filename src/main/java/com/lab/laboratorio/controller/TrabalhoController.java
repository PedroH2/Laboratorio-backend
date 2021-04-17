package com.lab.laboratorio.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.lab.laboratorio.utils.TotalFatObj;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.lab.laboratorio.enums.SituacaoTrabalho;
import com.lab.laboratorio.error.ResourceNotFoundException;
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
		log.debug("Iniciando processo de POST no endpoint: /api/v1/trabalho/cadastra");
		TrabalhoResponseDTO trabalhoResponseDTO = service.cadastra(requestDTO);
		log.debug("Finalizando processo de POST no endpoint: /api/v1/trabalho/cadastra");
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
		service.deleta(id);
		log.debug("Finalizando processo de DELETE no endpoint: /api/v1/trabalho/id", id);
		return ResponseEntity.ok().body(null);
		
	}
	@PutMapping("{id}/{situacao}")
	public ResponseEntity<ResponseDTO<TrabalhoResponseDTO>> alteraPorId(@PathVariable Long id, @PathVariable SituacaoTrabalho situacao){
		log.debug("Iniciando processo de PUT no endpoint: /api/v1/trabalho/{}/{} para alteração de situação de trabalho", id, situacao);
		TrabalhoResponseDTO dto = service.alteraSituacao(id, situacao);
		log.debug("Finalizando processo de PUT no endpoint: /api/v1/trabalho/{}/{} para alteração de situação de trabalho", id, situacao);
		return ResponseEntity.ok(new ResponseDTO<>(dto));
	}
	@GetMapping("/buscaPorSituacaoTrabalho/{situacao}")
	public ResponseEntity<ResponseDTO<List<TrabalhoResponseDTO>>> buscaPorSituacaoTrabalho(@PathVariable SituacaoTrabalho situacao){
		List<TrabalhoResponseDTO> dto = service.buscaPorSituacaoTrabalho(situacao);
	log.debug("Finalizando processo de GET no endpoint: /api/v1/trabalho/busacPorSituacaoTrabalho/{}", situacao);
		return ResponseEntity.ok(new ResponseDTO<>(dto));
	}
	@GetMapping("/buscaPorDataDeEntrada/{data}")
	public ResponseEntity<ResponseDTO<List<TrabalhoResponseDTO>>> buscaPorDataDeEntrada(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate data){
		log.debug("Iniciando processo de GET no endpoint: /api/v1/trabalho/buscaPorDataDeEntrada/{}", data);
		List<TrabalhoResponseDTO> dto = service.buscaPorDataDeEntrada(data);
		log.debug("Finalizando processo de GET no endpoint: /api/v1/trabalho/buscaPorDataDeEntrada/{}", data);
		return ResponseEntity.ok(new ResponseDTO<>(dto));
	}
	@GetMapping("/buscaPorDataDeEntregaDesejada/{data}")
	public ResponseEntity<ResponseDTO<List<TrabalhoResponseDTO>>> buscaPorDataDeEntregaDesejada(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate data){
		log.debug("Iniciando processo de GET no endpoint: /api/v1/trabalho/buscaPorDataDeEntrada/{}", data);
		List<TrabalhoResponseDTO> dto = service.buscaPorDataDeEntregaDesejada(data);
		log.debug("Finalizando processo de GET no endpoint: /api/v1/trabalho/buscaPorDataDeEntrada/{}", data);
		return ResponseEntity.ok(new ResponseDTO<>(dto));
	}
	@GetMapping("/buscaEntreDatas/{dataEntrada}/{dataParam}")
	public ResponseEntity<ResponseDTO<List<TrabalhoResponseDTO>>> buscaEntreDatas(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataEntrada,
																				  @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataParam){
		log.debug("Iniciando processo de GET no endpoint: /api/v1/trabalho/buscaPorDataDeEntrada/{}");
		List<TrabalhoResponseDTO> dto = service.buscaEntreDatas(dataEntrada, dataParam);
		log.debug("Finalizando processo de GET no endpoint: /api/v1/trabalho/buscaPorDataDeEntrada/{}" );
		return ResponseEntity.ok(new ResponseDTO<>(dto));
	}
	@PutMapping("/finalizarTrab/{id}")
	public ResponseEntity<ResponseDTO<TrabalhoResponseDTO>> finalizaTrab(@PathVariable Long id){
		log.debug("Iniciando processo de PUT no endpoint: /finalizarTrab/{}", id);
		TrabalhoResponseDTO trabalhoResponseDTO = service.finalizaTrab(id);
		log.debug("Finalizando processo de PUT no endpoint: /finalizarTrab/{}", id);
		return ResponseEntity.ok(new ResponseDTO<>(trabalhoResponseDTO));

	}
	@GetMapping("/buscaFaturamentoDeTrabsFinalizados/{dataParamInicial}/{dataParam}")
	public ResponseEntity<TotalFatObj> buscaFaturamentoDeTrabsFinalizados(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataParamInicial,
																		  @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataParam){
		log.debug("Iniciando processo de GET no endpoint: /buscaFaturamentoDeTrabsFinalizados/{}/{}");
		TotalFatObj valTotal = service.buscaFaturamentoTotalDeTrabsFinalizados(dataParamInicial, dataParam);
		log.debug("Finalizando processo de GET no endpoint: /buscaFaturamentoDeTrabsFinalizados/{}/{}" );
		return ResponseEntity.ok().body(valTotal);
	}
}
