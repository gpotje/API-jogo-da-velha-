package com.example.jogodavelha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jogodavelha.model.Tabuleiro;
import com.example.jogodavelha.repository.TabuleiroRepository;


@Service
public class TabuleiroService {

	@Autowired
	private TabuleiroRepository repository;
	
	
	public void criaJogada(Tabuleiro jogada) {
		repository.save(jogada);
	}
	
	public Tabuleiro consultaTabuleiroPorID(Long id) {
		return repository.findById(id).get();
	}
	
	public List<Tabuleiro> consultaTabuleiro() {
		return repository.findAll();
	}
	
}
