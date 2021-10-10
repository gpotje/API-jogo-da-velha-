package com.example.jogodavelha.dto;

import com.example.jogodavelha.model.Jogador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TabuleiroDto {

	private Long Id;
	private Jogador jogador;
	private Integer coordenada;
	
}
