    --/* 
    -- *  ----------------------------------------------------------------------------------------------->
    -- *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
    -- *  Criado em  : 09/10/2020 19:05:56 
    -- *  Instituição: FACULDADE SENAI FATESG
    -- *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
    -- *  Disciplina : PP - Padrões de Projeto
    -- *  Aluno      : Vinicius Araujo Lopes
    -- *  Projeto    : SINGLETON / DECORATOR / TEMPLATE / FACTORY
    -- *  Exercício  : Colaboradores de uma empresa
    -- *  ------------------------------------------------------------------------------------------------
    -- *  Script para criação do banco de dados.
    -- *  -----------------------------------------------------------------------------------------------| 
    -- */
    --/**
    -- * Author:  vovostudio
    -- * Created: 9 de out de 2020
    -- */

    DROP TABLE IF EXISTS
        habilidades_stack,
        stacks,
        habilidades_colaborador,
        habilidades_origem,
        habilidades,
        colaboradores,
        setores,
        empresas
    ;

    CREATE TABLE empresas
    (
        empresa_id SERIAL PRIMARY KEY,
        empresa_nome VARCHAR(50) UNIQUE NOT NULL
    );

    CREATE TABLE setores
    (
        setor_id SERIAL PRIMARY KEY,
        setor_nome VARCHAR(50) UNIQUE NOT NULL,
        setor_empresa_id INTEGER NOT NULL,
        FOREIGN KEY (setor_empresa_id) REFERENCES empresas (empresa_id)
    );

    CREATE TABLE colaboradores
    (
            colaborador_id SERIAL PRIMARY KEY,
            colaborador_nome VARCHAR(50) NOT NULL,
            colaborador_setor_id INTEGER NOT NULL,
            FOREIGN KEY (colaborador_setor_id) REFERENCES setores (setor_id),
            UNIQUE (colaborador_nome, colaborador_setor_id)
    );

    CREATE TABLE habilidades_origem
    (
            origem_id SERIAL PRIMARY KEY,
            origem_nome VARCHAR(20) UNIQUE NOT NULL
    );

    CREATE TABLE habilidades
    (
            habilidade_id SERIAL PRIMARY KEY,
            habilidade_origem_id INTEGER NOT NULL,
            habilidade_descricao VARCHAR(100) NOT NULL,
            FOREIGN KEY (habilidade_origem_id) REFERENCES habilidades_origem (origem_id)
    );

    CREATE TABLE habilidades_colaborador
    (
            habilidade_id INTEGER NOT NULL,
            colaborador_id INTEGER NOT NULL,
            PRIMARY KEY (habilidade_id, colaborador_id),
            FOREIGN KEY (habilidade_id) REFERENCES habilidades (habilidade_id),
            FOREIGN KEY (colaborador_id) REFERENCES colaboradores (colaborador_id)
    );

    CREATE TABLE stacks
    (
        stack_id SERIAL PRIMARY KEY,
        stack_nome VARCHAR (30) UNIQUE NOT NULL
    );

    CREATE TABLE habilidades_stack
    (
        stack_id INTEGER NOT NULL,
        habilidade_id INTEGER NOT NULL,
        PRIMARY KEY (stack_id, habilidade_id),
        FOREIGN KEY (stack_id) REFERENCES stacks (stack_id),
        FOREIGN KEY (habilidade_id) REFERENCES habilidades (habilidade_id)
    );

    INSERT INTO empresas (empresa_nome) VALUES ('COUVES Soluções em Tecnologia');
    INSERT INTO setores (setor_nome, setor_empresa_id) VALUES ('Desenvolvimento', 1);

    INSERT INTO habilidades_origem (origem_nome) VALUES
        ('Pessoas'),
        ('Profissionais'),
        ('Alunos')
    ;

    INSERT INTO habilidades (habilidade_id, habilidade_origem_id, habilidade_descricao) VALUES
        (DEFAULT, 1, 'Analisar'),
        (DEFAULT, 1, 'Beber café'),
        (DEFAULT, 1, 'Cochilar'),
        (DEFAULT, 1, 'Comer'),
        (DEFAULT, 1, 'Estudar'),
        (DEFAULT, 1, 'Desenhar'),
        (DEFAULT, 1, 'Dormir'),
        (DEFAULT, 1, 'Lecionar'),
        (DEFAULT, 1, 'Pesquisar'), 
        (DEFAULT, 2, 'Angular'),
        (DEFAULT, 2, 'Arquitetura de Software'),
        (DEFAULT, 2, 'Criar bugs'),
        (DEFAULT, 2, 'C#'),
        (DEFAULT, 2, 'CSS 3'),
        (DEFAULT, 2, 'Gestão de Pessoas'),
        (DEFAULT, 2, 'Gestão de Projetos'),
        (DEFAULT, 2, 'HTML 5'),
        (DEFAULT, 2, 'Identificar bugs'),
        (DEFAULT, 2, 'Java'),
        (DEFAULT, 2, 'JavaScript'),
        (DEFAULT, 2, 'MySql'),
        (DEFAULT, 2, 'Oracle DataBases'),
        (DEFAULT, 2, 'Php'),
        (DEFAULT, 2, 'Planejamento'),
        (DEFAULT, 2, 'POO'),
        (DEFAULT, 2, 'PostgreSQL'),
        (DEFAULT, 2, 'Power BI'),
        (DEFAULT, 2, 'Padrões de Projetos'),
        (DEFAULT, 2, 'Programar'),
        (DEFAULT, 2, 'Python'),
        (DEFAULT, 2, 'ReactJs'),
        (DEFAULT, 2, 'ShellScript'),
        (DEFAULT, 2, 'Spring Boot'), 
        (DEFAULT, 3, 'Tabelão de Excel'),
        (DEFAULT, 3, 'Colorir de Roxo'),
        (DEFAULT, 3, 'Dormir na aula e continuar conectado'),
        (DEFAULT, 3, 'Falar com o microfone mutado'),
        (DEFAULT, 3, 'Falar longe do microfone'),
        (DEFAULT, 3, 'Insistir em usar Debian'),
        (DEFAULT, 3, 'Inventar moda e complicar o que é fácil'),
        (DEFAULT, 3, 'Interromper a aula'),
        (DEFAULT, 3, 'Perguntar se já fez chamada'),
        (DEFAULT, 3, 'Sair mais cedo'),
        (DEFAULT, 3, 'Semear a discórdia'),
        (DEFAULT, 3, 'Usar fones de ouvido longe da orelha')
    ;

    INSERT INTO stacks (stack_nome) VALUES

        ('Java'),
        ('Microsoft'),
        ('OpenSource'),
        ('POG'),
        ('Programador'),
        ('WEB')
    ;

    INSERT INTO habilidades_stack (stack_id, habilidade_id) VALUES
        (1, 2),
        (1, 10),
        (1, 12),
        (1, 19),
        (1, 29),
        (1, 33),
        (1, 26),
        (2, 2),
        (2, 13),
        (2, 22),
        (2, 27),
        (2, 29),
        (3, 2),
        (3, 20),
        (3, 21),
        (3, 23),
        (3, 29),
        (3, 30),
        (3, 31),
        (3, 32),
        (3, 39),
        (3, 44),
        (4, 2),
        (4, 12),
        (4, 29),
        (4, 34),
        (4, 40),
        (5, 2),
        (5, 29),
        (6, 10),
        (6, 14),
        (6, 17),
        (6, 20),
        (6, 21),
        (6, 23),
        (6, 29),
        (6, 30),
        (6, 31),
        (6, 32),
        (6, 33)
    ;