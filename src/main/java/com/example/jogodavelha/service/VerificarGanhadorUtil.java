package com.example.jogodavelha.service;

import java.util.Collections;
import java.util.List;

import com.example.jogodavelha.model.Tabuleiro;

public class VerificarGanhadorUtil {
	
	public String verificaHorizontal() {

		boolean verificarVitoriaX = verificaConsiçãoVitoria(Tabuleiro.historicojogadorX, 0, 2, 1)
				|| verificaConsiçãoVitoria(Tabuleiro.historicojogadorX, 3, 5, 1)
				|| verificaConsiçãoVitoria(Tabuleiro.historicojogadorX, 6, 8, 1);

		boolean verificarVitoriaO = verificaConsiçãoVitoria(Tabuleiro.historicojogadorO, 0, 2, 1)
				|| verificaConsiçãoVitoria(Tabuleiro.historicojogadorO, 3, 5, 1)
				|| verificaConsiçãoVitoria(Tabuleiro.historicojogadorO, 6, 8, 1);

		if (verificarVitoriaX) {
			return "Jogar X  ganhou na Horizontal";
		} else if (verificarVitoriaO) {
			return "Jogar O ganhou na Horizontal ";
		}

		return "ainda niguem ganhou :(";
	}
	
	public String verificaVertical() {

		boolean verificarVitoriaX = verificaConsiçãovertical(Tabuleiro.historicojogadorX, 0, 6)
				|| verificaConsiçãovertical(Tabuleiro.historicojogadorX, 1, 7)
				|| verificaConsiçãovertical(Tabuleiro.historicojogadorX, 2, 8);

		boolean verificarVitoriaO = verificaConsiçãovertical(Tabuleiro.historicojogadorO, 0, 6)
				|| verificaConsiçãovertical(Tabuleiro.historicojogadorO, 1, 7)
				|| verificaConsiçãovertical(Tabuleiro.historicojogadorO, 2, 8);

		if (verificarVitoriaX) {
			return "Jogar X  ganhou na Vertical";
		} else if (verificarVitoriaO) {
			return "Jogar O ganhou na Vertical";
		}

		return "ainda niguem ganhou :(";
	}
	public String verificaDiagonal() {

		boolean verificarVitoriaX = verificaConsiçãoDiagonalEsquerda(Tabuleiro.historicojogadorX, 0, 8)
				|| verificaConsiçãoDiagonalDireita(Tabuleiro.historicojogadorX, 2, 6);
			

		boolean verificarVitoriaO = verificaConsiçãoDiagonalEsquerda(Tabuleiro.historicojogadorO, 0, 8)
				|| verificaConsiçãoDiagonalDireita(Tabuleiro.historicojogadorO, 2, 6);
			

		if (verificarVitoriaX) {
			return "Jogar X  ganhou na Diagonal";
		} else if (verificarVitoriaO) {
			return "Jogar O ganhou na Diagonal";
		}

		return "ainda niguem ganhou :(";
	}

	private boolean verificaConsiçãoVitoria(List<Integer> Historicojogadas, int inicio, int fim, int incr) {
		Collections.sort(Historicojogadas);
		int cont = 0;
		for (int i = inicio; i <= fim; i++) {
			if (Historicojogadas.contains(i))
				cont++;
			if (cont == 3)
				return true;
		}
		return false;
	}

	private boolean verificaConsiçãovertical(List<Integer> Historicojogadas, int inicio, int fim) {
		Collections.sort(Historicojogadas);
		int cont = 0;
		for (int i = inicio; i <= fim; i+=3) {
			if (Historicojogadas.contains(i))
				cont++;
			if (cont == 3)
				return true;
		}
		return false;
	}
	
	private boolean verificaConsiçãoDiagonalDireita(List<Integer> Historicojogadas, int inicio, int fim) {
		Collections.sort(Historicojogadas);
		int cont = 0;
		for (int i = inicio; i <= fim; i+=2) {
			if (Historicojogadas.contains(i))
				cont++;
			if (cont == 3)
				return true;
		}
		return false;
	}
	
	private boolean verificaConsiçãoDiagonalEsquerda(List<Integer> Historicojogadas, int inicio, int fim) {
		Collections.sort(Historicojogadas);
		int cont = 0;
		for (int i = inicio; i <= fim; i+=4) {
			if (Historicojogadas.contains(i))
				cont++;
			if (cont == 3)
				return true;
		}
		return false;
	}



}
