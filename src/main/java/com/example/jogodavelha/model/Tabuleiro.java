package com.example.jogodavelha.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.modelmapper.internal.util.Stack;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_tabuleiro")
public class Tabuleiro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public static List<Integer> historicojogadorX = new ArrayList<>();
	public static List<Integer> historicojogadorO = new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@NotNull
	private Jogador jogador;
	@NotNull
	private Integer coordenada;
	
}
