package com.example.jogodavelha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.jogodavelha.dto.GanhadorDto;
import com.example.jogodavelha.dto.TabuleiroDto;
import com.example.jogodavelha.model.Tabuleiro;
import com.example.jogodavelha.service.TabuleiroService;

@RestController
@RequestMapping(value = "/tabuleiro")
public class TabuleiroController {
	
	@Autowired
	private TabuleiroService service;
	
	
	@GetMapping
	public ResponseEntity<GanhadorDto> consultaTabuleiro(){ 
		GanhadorDto retornoTabuleiro = service.consultaTabuleiro();
		 return ResponseEntity.ok().body(retornoTabuleiro);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tabuleiro> consultaTabuleiroPorID(@PathVariable Long id){ 
		Tabuleiro retornoTabuleiro = service.consultaTabuleiroPorID(id);
		 return ResponseEntity.ok().body(retornoTabuleiro);
	}
	
	@PostMapping
	public ResponseEntity<String> criaJogada(@RequestBody TabuleiroDto jogada){ 
		 service.criaJogada(jogada);
		return ResponseEntity.ok().body("jogada Feita com  Sucesso");
	}
	
	@DeleteMapping("/reset")
	public ResponseEntity<String> reset(){ 
		 service.deleteEmployees();
		return ResponseEntity.ok().body("Jogo resetado com sucesso");
	}
	
	@PostMapping("/list")
	public ResponseEntity<String> criaJogadaLista(@RequestBody List<Tabuleiro> jogada){ 
		 service.criaJogadaList(jogada);
		return ResponseEntity.ok().body("jogada Feita com  Sucesso");
	}

	

}
