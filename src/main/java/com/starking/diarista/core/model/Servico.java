package com.starking.diarista.core.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.starking.diarista.core.enums.Icone;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	
	@Column(length = 50)
	private String nome;
	
	@Column(name = "valor_minimo")
	private BigDecimal valorMinimo;
	
	@Column(name = "qtd_horas")
	private Integer qtdHoras;
	
	@Column(name = "porcentagem_Comissao")
	private BigDecimal porcentagemComissao;
	
	@Column(name = "horas_Quarto")
	private Integer horasQuarto;
	
	@Column(name = "valor_Quarto")
	private BigDecimal valorQuarto;
	
	@Column(name = "horas_Sala")
	private Integer horasSala;
	
	@Column(name = "valor_Sala")
	private BigDecimal valorSala;	
	
	@Column(name = "horas_Banheiro")
	private Integer horasBanheiro;
	
	@Column(name = "valor_Banheiro")
	private BigDecimal valorBanheiro;	
	
	@Column(name = "horas_Cozinha")
	private Integer horasCozinha;
	
	@Column(name = "valor_Cozinha")
	private BigDecimal valorCozinha;	
	
	@Column(name = "horas_Quintal")
	private Integer horasQuintal;
	
	@Column(name = "valor_Quintal")
	private BigDecimal valorQuintal;	
	
	@Column(name = "horas_Outros")
	private Integer horasOutros;
	
	@Column(name = "valor_Outros")
	private BigDecimal valorOutros;
	
	@Column(length = 14)
	@Enumerated(EnumType.STRING)
	private Icone icone;
	
	@Column(nullable = false)
	private Integer posicao;
}
