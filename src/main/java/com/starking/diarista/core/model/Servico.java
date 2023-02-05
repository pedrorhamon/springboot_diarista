package com.starking.diarista.core.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.starking.diarista.core.model.enums.Icone;

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
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(name = "valor_minimo", nullable = false)
	private BigDecimal valorMinimo;
	
	@Column(name = "qtd_horas", nullable = false)
	private Integer qtdHoras;
	
	@Column(name = "porcentagem_Comissao", nullable = false)
	private BigDecimal porcentagemComissao;
	
	@Column(name = "horas_Quarto", nullable = false)
	private Integer horasQuarto;
	
	@Column(name = "valor_Quarto", nullable = false)
	private BigDecimal valorQuarto;
	
	@Column(name = "horas_Sala", nullable = false)
	private Integer horasSala;
	
	@Column(name = "valor_Sala", nullable = false)
	private BigDecimal valorSala;	
	
	@Column(name = "horas_Banheiro", nullable = false)
	private Integer horasBanheiro;
	
	@Column(name = "valor_Banheiro", nullable = false)
	private BigDecimal valorBanheiro;	
	
	@Column(name = "horas_Cozinha", nullable = false)
	private Integer horasCozinha;
	
	@Column(name = "valor_Cozinha", nullable = false)
	private BigDecimal valorCozinha;	
	
	@Column(name = "horas_Quintal", nullable = false)
	private Integer horasQuintal;
	
	@Column(name = "valor_Quintal", nullable = false)
	private BigDecimal valorQuintal;	
	
	@Column(name = "horas_Outros", nullable = false)
	private Integer horasOutros;
	
	@Column(name = "valor_Outros", nullable = false)
	private BigDecimal valorOutros;
	
	@Enumerated(EnumType.STRING)
	private Icone icone;
	
	@Column(nullable = false)
	private Integer posicao;
}
