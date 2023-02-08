package com.starking.diarista.web.mappers;

import org.springframework.stereotype.Component;

import com.starking.diarista.core.dtos.ServicoDTO;
import com.starking.diarista.core.model.Servico;

@Component
public class WebServicoMapper {

	public Servico toModel(ServicoDTO servicoDTO) {
		if(servicoDTO == null) {
			throw new IllegalArgumentException();
		}
		var model = new Servico();
		model.setNome(servicoDTO.getNome());
		model.setValorMinimo(servicoDTO.getValorMinimo());
		model.setQtdHoras(servicoDTO.getQtdHoras());
		model.setPorcentagemComissao(servicoDTO.getPorcentagemComissao());
		model.setPosicao(servicoDTO.getPosicao());
		model.setHorasQuarto(servicoDTO.getHorasQuarto());
		model.setValorQuarto(servicoDTO.getValorQuarto());
		model.setHorasSala(servicoDTO.getHorasSala());
		model.setValorSala(servicoDTO.getValorSala());
		model.setHorasBanheiro(servicoDTO.getHorasBanheiro());
		model.setValorBanheiro(servicoDTO.getValorBanheiro());
		model.setHorasCozinha(servicoDTO.getHorasCozinha());
		model.setValorCozinha(servicoDTO.getValorCozinha());
		model.setHorasQuintal(servicoDTO.getHorasQuintal());
		model.setHorasOutros(servicoDTO.getHorasOutros());
		model.setValorOutros(servicoDTO.getValorOutros());
		model.setIcone(servicoDTO.getIcone());
		model.setPosicao(servicoDTO.getPosicao());
		
		return model;
	}
	
	public ServicoDTO toDTO(Servico entity) {
		if(entity == null) {
			throw new IllegalArgumentException();
		}
		var dto = new ServicoDTO();
		dto.setNome(entity.getNome());
		dto.setValorMinimo(entity.getValorMinimo());
		dto.setQtdHoras(entity.getQtdHoras());
		dto.setPorcentagemComissao(entity.getPorcentagemComissao());
		dto.setPosicao(entity.getPosicao());
		dto.setHorasQuarto(entity.getHorasQuarto());
		dto.setValorQuarto(entity.getValorQuarto());
		dto.setHorasSala(entity.getHorasSala());
		dto.setValorSala(entity.getValorSala());
		dto.setHorasBanheiro(entity.getHorasBanheiro());
		dto.setValorBanheiro(entity.getValorBanheiro());
		dto.setHorasCozinha(entity.getHorasCozinha());
		dto.setValorCozinha(entity.getValorCozinha());
		dto.setHorasQuintal(entity.getHorasQuintal());
		dto.setHorasOutros(entity.getHorasOutros());
		dto.setValorOutros(entity.getValorOutros());
		dto.setIcone(entity.getIcone());
		dto.setPosicao(entity.getPosicao());
		
		return dto;
	}
}
