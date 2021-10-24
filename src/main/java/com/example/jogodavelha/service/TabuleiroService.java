package com.example.jogodavelha.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jogodavelha.dto.GanhadorDto;
import com.example.jogodavelha.dto.TabuleiroDto;
import com.example.jogodavelha.exception.ObjectBadRequestException;
import com.example.jogodavelha.model.Tabuleiro;
import com.example.jogodavelha.model.enuns.Jogador;
import com.example.jogodavelha.repository.TabuleiroRepository;
import com.example.jogodavelha.service.util.VerificarGanhadorUtil;

@Service
public class TabuleiroService {

	ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private TabuleiroRepository repository;

	public void criaJogada(TabuleiroDto jogada) {

		if (repository.count() > 0) {
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
		Long jogadorId = repository.findMaxId();
		Tabuleiro UltimoJogar = consultaTabuleiroPorID(jogadorId);
		return UltimoJogar.getJogador();
	}

	public Tabuleiro consultaTabuleiroPorID(Long id) {
		return repository.findById(id).orElseThrow();
	}

	private boolean verificarCoodenada(Integer coordenada) {
		return repository.findByCoordenada(coordenada) == null ? true : false;

	}

	public GanhadorDto consultaTabuleiro() {
		VerificarGanhadorUtil util = new VerificarGanhadorUtil();
		GanhadorDto dtoRetorno = util.verificarTodosPossibilidadesVitoria();
		GanhadorDto dto = new GanhadorDto();
		dto.setJogadas(repository.findAll());

		if (repository.count() > 4 && dtoRetorno.getGanhador()) {
			dto.setCoordenada(dtoRetorno.getCoordenada());
			dto.setGanhador(dtoRetorno.getGanhador());
			dto.setJogador(dtoRetorno.getJogador());
			return dto;
		}
		dto.setGanhador(false);
		return dto;
	}

	public void deleteEmployees() {
		Long tamanhoList = repository.count();
		if (tamanhoList > 0) {
			List<Tabuleiro> listTabuleiro = repository.findAll();
			for (Tabuleiro tabuleiro : listTabuleiro) {
				repository.deleteById(tabuleiro.getId());
			}

		} else {
			throw new ObjectBadRequestException("Inda não houve jogadas, sendo imposivel resetar o jogo");
		}

	}

}
