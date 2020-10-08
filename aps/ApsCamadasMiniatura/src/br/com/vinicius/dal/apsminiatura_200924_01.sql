-- ----------------------------------------------------------------------------------------------->
-- Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
-- Criado em  : 08/10/2020 02:01:59 
-- Instituição: FACULDADE SENAI FATESG
-- Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
-- Disciplina : Arquitetura e Projeto de Software
-- Aluno      : Vinicius Araujo Lopes
-- Projeto    : ARQUITETURA EM CAMADAS
-- Exercício  : Cadastro de Miniatura em camadas
-- ------------------------------------------------------------------------------------------------
-- Script de criação do banco de dados para as miniaturas
-- -----------------------------------------------------------------------------------------------| 

--
-- DROPs para recriar o banco
--
DROP TABLE IF EXISTS
	"Miniaturas",
	"Fotos",
	"Fabricantes",
	"TiposMiniaturas",
	"Temas"
;

--
-- Temas de Miniaturas
--
CREATE TABLE "Temas"
(
	tema_id SERIAL PRIMARY KEY,
	tema_nome VARCHAR(50) UNIQUE NOT NULL
);

--
-- Tipos de Miniaturas
--
CREATE TABLE "TiposMiniaturas"
(
	tipo_id SERIAL PRIMARY KEY,
	tipo_nome VARCHAR(50) UNIQUE NOT NULL
);

--
-- Fabricantes de Miniaturas
--
CREATE TABLE "Fabricantes"
(
	fabricante_id SERIAL PRIMARY KEY,
	fabricante_nome VARCHAR(50) UNIQUE NOT NULL
);

--
-- Miniaturas
--
CREATE TABLE "Miniaturas"
(
	miniatura_id SERIAL PRIMARY KEY,
	miniatura_modelo VARCHAR(50) NOT NULL,
	miniatura_ano CHAR(4) NOT NULL,
	miniatura_observacoes VARCHAR(255),
	miniatura_edicao VARCHAR(20) NOT NULL,
	miniatura_escala VARCHAR(20) NOT NULL,
	miniatura_valor NUMERIC(9,2) DEFAULT 0.00,
	miniatura_fabricante_id INTEGER NOT NULL,
	miniatura_tipo_id INTEGER NOT NULL,
	miniatura_tema_id INTEGER NOT NULL,
	FOREIGN KEY (miniatura_fabricante_id) REFERENCES "Fabricantes" (fabricante_id),
	FOREIGN KEY (miniatura_tipo_id) REFERENCES "TiposMiniaturas" (tipo_id),
	FOREIGN KEY (miniatura_tema_id) REFERENCES "Temas" (tema_id)
);

--
-- Fotos
--
CREATE TABLE "Fotos"
(
	foto_id SERIAL PRIMARY KEY,
	foto_caminho VARCHAR(255) NOT NULL,
	foto_descricao VARCHAR(255) NOT NULL,
	foto_miniatura_id INTEGER NOT NULL,
	FOREIGN KEY (foto_miniatura_id) REFERENCES "Miniaturas" (miniatura_id) ON DELETE CASCADE
);