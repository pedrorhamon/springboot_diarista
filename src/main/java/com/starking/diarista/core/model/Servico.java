package com.starking.diarista.core.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.starking.diarista.core.model.enums.Icone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Servico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@ToString.Include
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private BigDecimal valorMinimo;
	
	private Integer qtdHoras;
	
	private BigDecimal porcentagemComissao;
	
	private Integer horasQuarto;
	
	private BigDecimal valorQuarto;
	
	private Integer horasSala;
	
	private BigDecimal valorSala;	
	
	private Integer horasBanheiro;
	
	private BigDecimal valorBanheiro;	
	
	private Integer horasCozinha;
	
	private BigDecimal valorCozinha;	
	
	private Integer horasQuintal;
	
	private BigDecimal valorQuintal;	
	
	private Integer horasOutros;
	
	private BigDecimal valorOutros;
	
	private Icone icone;
	
	private Integer posicao;
}
