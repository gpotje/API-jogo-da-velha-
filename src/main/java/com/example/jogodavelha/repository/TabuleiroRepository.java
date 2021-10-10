package com.example.jogodavelha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jogodavelha.model.Tabuleiro;

public interface TabuleiroRepository extends JpaRepository<Tabuleiro,Long> {
	
	Tabuleiro findByCoordenada(Integer coordenada);

}
