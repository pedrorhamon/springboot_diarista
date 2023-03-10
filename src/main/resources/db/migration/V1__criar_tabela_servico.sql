CREATE TABLE `servico` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `horas_banheiro` int(11) DEFAULT NULL,
  `horas_cozinha` int(11) DEFAULT NULL,
  `horas_outros` int(11) DEFAULT NULL,
  `horas_quarto` int(11) DEFAULT NULL,
  `horas_quintal` int(11) DEFAULT NULL,
  `horas_sala` int(11) DEFAULT NULL,
  `icone` varchar(14) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `porcentagem_comissao` decimal(19,2) DEFAULT NULL,
  `posicao` int(11) DEFAULT NULL,
  `qtd_horas` int(11) DEFAULT NULL,
  `valor_banheiro` decimal(19,2) DEFAULT NULL,
  `valor_cozinha` decimal(19,2) DEFAULT NULL,
  `valor_minimo` decimal(19,2) DEFAULT NULL,
  `valor_outros` decimal(19,2) DEFAULT NULL,
  `valor_quarto` decimal(19,2) DEFAULT NULL,
  `valor_quintal` decimal(19,2) DEFAULT NULL,
  `valor_sala` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
);