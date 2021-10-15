package com.example.jogodavelha.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.jogodavelha.dto.GanhadorDto;
import com.example.jogodavelha.model.Jogador;
import com.example.jogodavelha.model.Tabuleiro;

public class VerificarGanhadorUtil {

	public GanhadorDto verificaGanhador() {

		return null;
	}

	public static List<Integer> historicojogadorGanhador = new ArrayList<>();

	public GanhadorDto verificarTodosPossibilidadesVitoria() {

		if (verificaHorizontal().getGanhador()) {
			return verificaHorizontal();
		}
		if (verificaVertical().getGanhador()) {
			return verificaVertical();
		}
		if (verificaDiagonal().getGanhador()) {
			return verificaDiagonal();
		}

		return new GanhadorDto(null, false, null, null);
	}

	private GanhadorDto verificaHorizontal() {

		boolean verificarVitoriaX = verificaConsiçãoVitoria(Tabuleiro.historicojogadorX, 0, 2, 1)
				|| verificaConsiçãoVitoria(Tabuleiro.historicojogadorX, 3, 5, 1);
		verificaConsiçãoVitoria(Tabuleiro.historicojogadorX, 6, 8, 1);

		if (verificarVitoriaX) {
			GanhadorDto dto = new GanhadorDto(Jogador.X, true, null, historicojogadorGanhador);
			return dto;
		}

		boolean verificarVitoriaO = verificaConsiçãoVitoria(Tabuleiro.historicojogadorO, 0, 2, 1)
				|| verificaConsiçãoVitoria(Tabuleiro.historicojogadorO, 3, 5, 1)
				|| verificaConsiçãoVitoria(Tabuleiro.historicojogadorO, 6, 8, 1);

		if (verificarVitoriaO) {
			GanhadorDto dto = new GanhadorDto(Jogador.O, true, null, historicojogadorGanhador);
			return dto;
		}

		return new GanhadorDto(null, false, null, null);
	}

	private GanhadorDto verificaVertical() {

		boolean verificarVitoriaX = verificaConsiçãovertical(Tabuleiro.historicojogadorX, 0, 6)
				|| verificaConsiçãovertical(Tabuleiro.historicojogadorX, 1, 7)
				|| verificaConsiçãovertical(Tabuleiro.historicojogadorX, 2, 8);

		if (verificarVitoriaX) {
			GanhadorDto dto = new GanhadorDto(Jogador.X, true, null, historicojogadorGanhador);
			return dto;
		}

		boolean verificarVitoriaO = verificaConsiçãovertical(Tabuleiro.historicojogadorO, 0, 6)
				|| verificaConsiçãovertical(Tabuleiro.historicojogadorO, 1, 7)
				|| verificaConsiçãovertical(Tabuleiro.historicojogadorO, 2, 8);

		if (verificarVitoriaO) {
			GanhadorDto dto = new GanhadorDto(Jogador.O, true, null, historicojogadorGanhador);
			return dto;
		}

		return new GanhadorDto(null, false, null, null);
	}

	private GanhadorDto verificaDiagonal() {

		boolean verificarVitoriaX = verificaConsiçãoDiagonalEsquerda(Tabuleiro.historicojogadorX, 0, 8)
				|| verificaConsiçãoDiagonalDireita(Tabuleiro.historicojogadorX, 2, 6);

		if (verificarVitoriaX) {
			GanhadorDto dto = new GanhadorDto(Jogador.X, true, null, historicojogadorGanhador);
			return dto;
		}

		boolean verificarVitoriaO = verificaConsiçãoDiagonalEsquerda(Tabuleiro.historicojogadorO, 0, 8)
				|| verificaConsiçãoDiagonalDireita(Tabuleiro.historicojogadorO, 2, 6);

		if (verificarVitoriaO) {
			GanhadorDto dto = new GanhadorDto(Jogador.O, true, null, historicojogadorGanhador);
			return dto;
		}

		return new GanhadorDto(null, false, null, null);
	}

	private boolean verificaConsiçãoVitoria(List<Integer> Historicojogadas, int inicio, int fim, int incr) {
		Collections.sort(Historicojogadas);
		int cont = 0;
		for (int i = inicio; i <= fim; i++) {
			if (Historicojogadas.contains(i))
				cont++;
			if (cont == 3) {
				historicojogadorGanhador.add(inicio);
				historicojogadorGanhador.add(inicio + 1);
				historicojogadorGanhador.add(fim);

				return true;
			}

		}
		return false;
	}

	private boolean verificaConsiçãovertical(List<Integer> Historicojogadas, int inicio, int fim) {
		Collections.sort(Historicojogadas);
		int cont = 0;

		for (int i = inicio; i <= fim; i += 3) {
			if (Historicojogadas.contains(i))
				cont++;
			if (cont == 3) {
				historicojogadorGanhador.add(inicio);
				historicojogadorGanhador.add(inicio + 3);
				historicojogadorGanhador.add(fim);
				return true;
			}

		}
		return false;
	}

	private boolean verificaConsiçãoDiagonalDireita(List<Integer> Historicojogadas, int inicio, int fim) {
		Collections.sort(Historicojogadas);
		int cont = 0;
		for (int i = inicio; i <= fim; i += 2) {
			if (Historicojogadas.contains(i))
				cont++;
			if (cont == 3) {
				historicojogadorGanhador.add(inicio);
				historicojogadorGanhador.add(inicio + 2);
				historicojogadorGanhador.add(fim);
				return true;
			}

		}
		return false;
	}

	private boolean verificaConsiçãoDiagonalEsquerda(List<Integer> Historicojogadas, int inicio, int fim) {
		Collections.sort(Historicojogadas);
		int cont = 0;
		for (int i = inicio; i <= fim; i += 4) {
			if (Historicojogadas.contains(i))
				cont++;
			if (cont == 3) {
				historicojogadorGanhador.add(inicio);
				historicojogadorGanhador.add(inicio + 4);
				historicojogadorGanhador.add(fim);
				return true;
			}

		}
		return false;
	}

}
