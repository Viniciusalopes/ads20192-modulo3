-- ATIVIDADE MINIATURA
--
-- ALUNOS: Lucas Araujo
--         Marcos Job Dias Lima
--         Marcos Paulo Paixao
--         Vinicius Araujo Lopes
--
-- Um grupo de colecionadores de miniaturas de veículos (carros, motos, aviões, etc) desejam cadastrar suas coleções. 
--
-- Cada mini terá um modelo, edição, ano, fabricante, escala, tema (sem tema, Star Wars, Simpsons, Batman, etc ),
--   status (coleção própria, venda, procuro ou troca), em caso de venda, informar o valor e por fim as observações do estado do mini.
--
-- Todos os minis registrados deverão conter no mínimo uma foto para demonstrar o real estado do mesmo.Porém, quanto mais fotos melhor.
--
-- Os membros do grupo podem interagir com outros membros informando que existe um interesse em um determinado mini (venda) ou que possua
--   um mini a qual o outro membro esteja a procura/troca.
--
-- Além disso, ao longo do ano existem vários eventos do grupo a fim de estreitar os laços de amizade entre os membros.
--
-- O registro dos eventos devem conter data, título, descrição, endereço e valor.
-- Para cada evento é registrado se tal membro possui a inscrição paga ou não.
--
--

-- DROPS para refazer a estrutura do banco.
--
DROP TABLE "FotosMiniatura";
DROP TABLE "Miniaturas";
DROP TABLE "TemasMiniatura";
DROP TABLE "Fabricantes";
DROP TABLE "StatusMiniatura";
DROP TABLE "TiposMiniatura";
DROP TABLE "Inscricoes";
DROP TABLE "StatusInscricao";
DROP TABLE "Colecionadores";
DROP TABLE "Eventos";
DROP TABLE "Enderecos";
DROP TABLE "Municipios";
DROP TABLE "UF";

-- Fim.