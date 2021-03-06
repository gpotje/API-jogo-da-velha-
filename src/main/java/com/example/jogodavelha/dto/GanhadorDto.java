package com.example.jogodavelha.dto;

import java.util.List;

import com.example.jogodavelha.model.Tabuleiro;
import com.example.jogodavelha.model.enuns.Jogador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GanhadorDto {

	private Jogador jogador;
	private Boolean ganhador;
	private List<Tabuleiro> jogadas;
	private List<Integer> coordenada;
	
}
