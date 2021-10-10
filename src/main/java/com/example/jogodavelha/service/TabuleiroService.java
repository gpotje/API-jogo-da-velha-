package com.example.jogodavelha.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jogodavelha.dto.TabuleiroDto;
import com.example.jogodavelha.exception.ObjectBadRequestException;
import com.example.jogodavelha.model.Jogador;
import com.example.jogodavelha.model.Tabuleiro;
import com.example.jogodavelha.repository.TabuleiroRepository;

@Service
public class TabuleiroService {

	ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private TabuleiroRepository repository;

	public void criaJogada(TabuleiroDto jogada) {

		if (repository.count() != 0) {
			verificarJogada(jogada);
		}

		if (jogada.getJogador() == Jogador.X)
			Tabuleiro.historicojogadorX.add(jogada.getCoordenada());
		else
			Tabuleiro.historicojogadorO.add(jogada.getCoordenada());

		Tabuleiro entity = modelMapper.map(jogada, Tabuleiro.class);

		repository.save(entity);
	}

	public void criaJogadaList(List<Tabuleiro> jogada) {

		for (Tabuleiro tabuleiro : jogada) {
			if (tabuleiro.getJogador() == Jogador.X)
				Tabuleiro.historicojogadorX.add(tabuleiro.getCoordenada());
			else
				Tabuleiro.historicojogadorO.add(tabuleiro.getCoordenada());

		}

		repository.saveAll(jogada);
	}

	private void verificarJogada(TabuleiroDto jogada) {
		if (!verificarCoodenada(jogada.getCoordenada())) {
			throw new ObjectBadRequestException("Apenas pode jogar em campos Vazios");
		}
		if (jogada.getJogador() == verificarUltimoJogador()) {
			throw new ObjectBadRequestException("Não é possivel jogar duas vezes seguidas");
		}
	}

	private Jogador verificarUltimoJogador() {
		Long jogadorId = repository.count();
		Tabuleiro UltimoJogar = consultaTabuleiroPorID(jogadorId);
		return UltimoJogar.getJogador();
	}

	public Tabuleiro consultaTabuleiroPorID(Long id) {
		return repository.findById(id).get();
	}

	private boolean verificarCoodenada(Integer coordenada) {
		return repository.findByCoordenada(coordenada) == null ? true : false;

	}

	public List<Tabuleiro> consultaTabuleiro() {
		List<Tabuleiro> aux = repository.findAll();
		VerificarGanhadorUtil util = new VerificarGanhadorUtil();
		if (repository.count() > 3) {
			System.out.println(util.verificaHorizontal());
			System.out.println(util.verificaVertical());
			System.out.println(util.verificaDiagonal());

		}
		return aux;
	}

}
