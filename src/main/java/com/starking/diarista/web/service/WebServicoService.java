package com.starking.diarista.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starking.diarista.core.dtos.ServicoDTO;
import com.starking.diarista.core.model.Servico;
import com.starking.diarista.core.repositories.ServicoRepository;
import com.starking.diarista.web.exceptions.ServicoNaoEncontradoException;
import com.starking.diarista.web.mappers.WebServicoMapper;

@Service
public class WebServicoService {

	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private WebServicoMapper mapper;
	
	public List<Servico> buscarTodos() {
		return this.servicoRepository.findAll();
	}
	
	public Servico cadastrar(ServicoDTO dto) {
		var model = this.mapper.toModel(dto);
		
		return this.servicoRepository.save(model);
	}
	
	public Servico buscarPorId(Long id) {
		var servicoEncontrado = this.servicoRepository.findById(id);
		if(servicoEncontrado.isPresent()) {
			return servicoEncontrado.get();
		}
		
		var mensagem = String.format("Serviço com ID %d não encontrado", id);
		throw new ServicoNaoEncontradoException(mensagem);
	}
	
	public Servico editar(ServicoDTO dto, Long id) {
		var servicoEncontrado = buscarPorId(id);
		var model = this.mapper.toModel(dto);
		model.setId(servicoEncontrado.getId());
		
		return this.servicoRepository.save(model);
	}
	
	public void excluirPorId(Long id) {
		var servicoEncontrado = buscarPorId(id);
		
		this.servicoRepository.delete(servicoEncontrado);
	}
}
