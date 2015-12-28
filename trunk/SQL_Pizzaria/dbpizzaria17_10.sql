-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: Nov 17, 2011 as 06:46 PM
-- Versão do Servidor: 5.1.36
-- Versão do PHP: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `dbpizzaria`
--
CREATE DATABASE `dbpizzaria` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `dbpizzaria`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `autenticacao`
--

CREATE TABLE IF NOT EXISTS `autenticacao` (
  `aut_usuario` varchar(20) NOT NULL,
  `aut_senha` varchar(8) DEFAULT NULL,
  `aut_acesso` char(1) DEFAULT NULL,
  PRIMARY KEY (`aut_usuario`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `autenticacao`
--

INSERT INTO `autenticacao` (`aut_usuario`, `aut_senha`, `aut_acesso`) VALUES
('admin', '123', '1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `bairro`
--

CREATE TABLE IF NOT EXISTS `bairro` (
  `bai_id` int(11) NOT NULL AUTO_INCREMENT,
  `cid_id` int(11) NOT NULL,
  `bai_nome` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`bai_id`),
  KEY `Bairro_FKIndex1` (`cid_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `bairro`
--

INSERT INTO `bairro` (`bai_id`, `cid_id`, `bai_nome`) VALUES
(1, 1, 'Aterrado');

-- --------------------------------------------------------

--
-- Estrutura da tabela `bebida`
--

CREATE TABLE IF NOT EXISTS `bebida` (
  `beb_id` int(11) NOT NULL AUTO_INCREMENT,
  `beb_desc` varchar(45) DEFAULT NULL,
  `beb_preco` decimal(7,2) DEFAULT NULL,
  `beb_tam` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`beb_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `bebida`
--

INSERT INTO `bebida` (`beb_id`, `beb_desc`, `beb_preco`, `beb_tam`) VALUES
(1, 'coca', '1.50', 'media'),
(2, 'fanta', '1.50', 'litro');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

CREATE TABLE IF NOT EXISTS `cidade` (
  `cid_id` int(11) NOT NULL AUTO_INCREMENT,
  `est_uf` varchar(2) NOT NULL,
  `cid_nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cid_id`),
  KEY `Cidade_FKIndex1` (`est_uf`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `cidade`
--

INSERT INTO `cidade` (`cid_id`, `est_uf`, `cid_nome`) VALUES
(1, 'RJ', 'Volta Redonda');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `cli_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cli_nome` varchar(50) NOT NULL,
  `cli_sexo` char(1) NOT NULL,
  `cli_cpf` varchar(14) NOT NULL,
  `cli_rg` varchar(15) DEFAULT NULL,
  `cli_data_nasc` date NOT NULL,
  `log_id` int(10) unsigned NOT NULL,
  `cli_numero` varchar(10) NOT NULL,
  `cli_compl` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cli_id`),
  KEY `FKlog_id` (`log_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`cli_id`, `cli_nome`, `cli_sexo`, `cli_cpf`, `cli_rg`, `cli_data_nasc`, `log_id`, `cli_numero`, `cli_compl`) VALUES
(7, 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', 'M', '111.111.111-11', '11111111111', '1111-11-11', 1, '111', 'casa01');

-- --------------------------------------------------------

--
-- Estrutura da tabela `entregador`
--

CREATE TABLE IF NOT EXISTS `entregador` (
  `ent_cod` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) DEFAULT NULL,
  `telefone` longtext,
  PRIMARY KEY (`ent_cod`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `entregador`
--

INSERT INTO `entregador` (`ent_cod`, `nome`, `telefone`) VALUES
(1, 'gustavo', '3333-3333');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estado`
--

CREATE TABLE IF NOT EXISTS `estado` (
  `est_uf` varchar(2) NOT NULL,
  `est_nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`est_uf`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `estado`
--

INSERT INTO `estado` (`est_uf`, `est_nome`) VALUES
('RJ', 'Rio de Janeiro');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE IF NOT EXISTS `funcionario` (
  `fun_mat` int(11) NOT NULL AUTO_INCREMENT,
  `fun_nome` varchar(25) DEFAULT NULL,
  `fun_tel` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`fun_mat`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`fun_mat`, `fun_nome`, `fun_tel`) VALUES
(1, 'Gustavo', '(24) 3333-3333');

-- --------------------------------------------------------

--
-- Estrutura da tabela `item_pedido`
--

CREATE TABLE IF NOT EXISTS `item_pedido` (
  `ped_num` int(11) NOT NULL,
  `beb_id` int(11) NOT NULL DEFAULT '0',
  `piz_id` int(11) NOT NULL DEFAULT '0',
  `quantidade` int(11) NOT NULL,
  `valor_total` decimal(4,2) NOT NULL,
  `itp_preco` decimal(4,2) NOT NULL,
  PRIMARY KEY (`beb_id`,`piz_id`,`ped_num`),
  KEY `item_pedido_FKIndex1` (`ped_num`),
  KEY `item_pedido_FKIndex2` (`piz_id`),
  KEY `item_pedido_FKIndex3` (`beb_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `item_pedido`
--

INSERT INTO `item_pedido` (`ped_num`, `beb_id`, `piz_id`, `quantidade`, `valor_total`, `itp_preco`) VALUES
(10, 0, 1, 2, '39.00', '19.00'),
(9, 0, 1, 1, '19.00', '19.00'),
(17, 0, 2, 1, '19.00', '19.00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `logradouro`
--

CREATE TABLE IF NOT EXISTS `logradouro` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `tplogra_id` int(11) NOT NULL,
  `bai_id` int(11) NOT NULL,
  `log_nome` varchar(30) DEFAULT NULL,
  `log_cep` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`log_id`),
  KEY `Logradouro_FKIndex1` (`bai_id`),
  KEY `Logradouro_FKIndex2` (`tplogra_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `logradouro`
--

INSERT INTO `logradouro` (`log_id`, `tplogra_id`, `bai_id`, `log_nome`, `log_cep`) VALUES
(1, 1, 1, 'Calex', '22.222-222');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

CREATE TABLE IF NOT EXISTS `pedido` (
  `ped_num` int(11) NOT NULL AUTO_INCREMENT,
  `ent_cod` int(11) NOT NULL,
  `fun_mat` int(11) NOT NULL,
  `cli_id` int(11) NOT NULL,
  `ped_data` date DEFAULT NULL,
  PRIMARY KEY (`ped_num`),
  KEY `Pedido_FKIndex3` (`cli_id`),
  KEY `Pedido_FKIndex2` (`fun_mat`),
  KEY `Pedido_FKIndex1` (`ent_cod`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Extraindo dados da tabela `pedido`
--

INSERT INTO `pedido` (`ped_num`, `ent_cod`, `fun_mat`, `cli_id`, `ped_data`) VALUES
(1, 1, 1, 7, '2011-11-17'),
(2, 1, 1, 7, '2011-11-17'),
(3, 1, 1, 7, '2011-11-17'),
(4, 1, 1, 7, '2011-11-17'),
(5, 1, 1, 7, '2011-11-17'),
(6, 1, 1, 7, '2011-11-17'),
(7, 1, 1, 7, '2011-11-17'),
(8, 1, 1, 7, '2011-11-17'),
(9, 1, 1, 7, '2011-11-17'),
(10, 1, 1, 7, '2011-11-17'),
(11, 1, 1, 7, '2011-11-17'),
(12, 1, 1, 7, '2011-11-17'),
(13, 1, 1, 7, '2011-11-17'),
(14, 1, 1, 7, '2011-11-17'),
(15, 1, 1, 7, '2011-11-17'),
(16, 1, 1, 7, '2011-11-17'),
(17, 1, 1, 7, '2011-11-17');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pizza`
--

CREATE TABLE IF NOT EXISTS `pizza` (
  `piz_id` int(11) NOT NULL AUTO_INCREMENT,
  `piz_desc` varchar(30) DEFAULT NULL,
  `piz_sabor` varchar(20) DEFAULT NULL,
  `piz_tam` varchar(20) DEFAULT NULL,
  `piz_preco` decimal(4,2) DEFAULT NULL,
  PRIMARY KEY (`piz_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `pizza`
--

INSERT INTO `pizza` (`piz_id`, `piz_desc`, `piz_sabor`, `piz_tam`, `piz_preco`) VALUES
(1, 'Quatro queijos', 'Quatro queijos', 'Maracanã', '19.00'),
(2, 'calabresa, mussarela', 'calabresa', 'Grande', '19.00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefone`
--

CREATE TABLE IF NOT EXISTS `telefone` (
  `tel_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tel_telefone` varchar(15) NOT NULL,
  `cli_id` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`tel_id`,`cli_id`),
  KEY `FKcli_tel` (`cli_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `telefone`
--

INSERT INTO `telefone` (`tel_id`, `tel_telefone`, `cli_id`) VALUES
(1, '(  )    -    ', 6),
(2, '(  )    -    ', 7),
(3, '(22)2222-2222', 7);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_log`
--

CREATE TABLE IF NOT EXISTS `tipo_log` (
  `tplogra_id` int(11) NOT NULL AUTO_INCREMENT,
  `tplogra_descr` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`tplogra_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `tipo_log`
--

INSERT INTO `tipo_log` (`tplogra_id`, `tplogra_descr`) VALUES
(1, 'Rua');

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE IF NOT EXISTS `venda` (
  `venda_id` int(11) NOT NULL AUTO_INCREMENT,
  `fun_mat` int(11) NOT NULL,
  `ped_num` int(11) NOT NULL,
  PRIMARY KEY (`venda_id`),
  KEY `venda_FKIndex1` (`ped_num`),
  KEY `venda_FKIndex2` (`fun_mat`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `venda`
--

