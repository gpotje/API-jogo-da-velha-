package com.example.jogodavelha.dto;

import java.util.List;

import com.example.jogodavelha.model.Jogador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JogadorCoordenadaDto {

	private Jogador jogador;
	private boolean ganhador;

	
}
