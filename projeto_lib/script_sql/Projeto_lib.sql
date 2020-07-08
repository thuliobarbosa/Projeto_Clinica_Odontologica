CREATE DATABASE projeto_lib;

USE projeto_lib;

--> CRIA TABELA
CREATE TABLE agendamento (
	idAgendamento INT(6) NOT NULL AUTO_INCREMENT,
	dataAgendamento DATE NOT NULL,
	horario TIME NOT NULL,
	duracao DOUBLE DEFAULT 1,
	cpf VARCHAR(15) NOT NULL, 
	nomePaciente VARCHAR(50) NOT NULL,
	telefone VARCHAR(20) NOT NULL,
	dataNascimento DATE,
	nomeProfissional VARCHAR(50) NOT NULL,
	tipo VARCHAR(30) NOT NULL,
	valorConsulta DOUBLE DEFAULT 200.00,
	percDesconto INT(3),
	convenio INT(1) DEFAULT 0, 
	PRIMARY KEY (idAgendamento)
);

--> INSERE DADOS

--> 1
INSERT INTO agendamento(dataAgendamento,horario,duracao,cpf,nomePaciente,telefone,dataNascimento,
nomeProfissional,tipo,valorConsulta,percDesconto,convenio)
VALUES('2020-10-01', '13:00:00', 2, '321.654.987.-82', 'Fernando Bueno', '8998-5454', '1985-05-19',
'Bruna Candiani', 'Fsioterapeuta', 270.00, 0, 1);

--> 2
INSERT INTO agendamento(dataAgendamento,horario,duracao,cpf,nomePaciente,telefone,dataNascimento,
nomeProfissional,tipo,valorConsulta,percDesconto,convenio)
VALUES('2020-10-18', '16:30:00', 1, '742.951.852.-13', 'Ivan Pacheco', '9945-1452', '1998-03-13',
'Bruna Candiani', 'Fsioterapeuta', 211.00, 0, 0);

--> 3
INSERT INTO agendamento(dataAgendamento,horario,duracao,cpf,nomePaciente,telefone,dataNascimento,
nomeProfissional,tipo,valorConsulta,percDesconto,convenio)
VALUES('2020-11-12', '10:45:00', 1, '987.159.321.-77', 'Jhonata Vieira', '1587-9871', '2001-02-04',
'Marcelo Queiroz Rocha', 'Neurocirurgiao', 600.00, 0, 1);

--> 4
INSERT INTO agendamento(dataAgendamento,horario,duracao,cpf,nomePaciente,telefone,dataNascimento,
nomeProfissional,tipo,valorConsulta,percDesconto,convenio)
VALUES('2020-11-27', '11:00:00', 1, '777.958.333.-44', 'Edvaldo Paula', '7898-2222', '1970-01-29',
'Marcelo Queiroz Rocha', 'Neurocirurgiao', 789.00, 5, 0);

--> 5
INSERT INTO agendamento(dataAgendamento,horario,duracao,cpf,nomePaciente,telefone,dataNascimento,
nomeProfissional,tipo,valorConsulta,percDesconto,convenio)
VALUES('2020-12-12', '15:45:00', 1, '772.998.878.-22', 'Lucia Duarte', '8998-1456', '1988-05-21',
'Sonia Domingos', 'Sonia Domingos', 130.00, 10, 1);

--> 6
INSERT INTO agendamento(dataAgendamento,horario,duracao,cpf,nomePaciente,telefone,dataNascimento,
nomeProfissional,tipo,valorConsulta,percDesconto,convenio)
VALUES('2020-12-01', '15:00:00', 1, '987.145.666.-99', 'Matheus Rodrigues', '5547-1456', '1977-05-23',
'Sonia Domingos', 'Radiologista', 365.10, 3, 0);

--> 7
INSERT INTO agendamento(dataAgendamento,horario,duracao,cpf,nomePaciente,telefone,dataNascimento,
nomeProfissional,tipo,valorConsulta,percDesconto,convenio)
VALUES('2020-01-19', '17:00:00', 1, '332.546.731.-55', 'Everton Alves', '9874-3651', '1999-09-27',
'Sonia Domingos', 'Radiologista', 479.00, 5, 1);

--> 8
INSERT INTO agendamento(dataAgendamento,horario,duracao,cpf,nomePaciente,telefone,dataNascimento,
nomeProfissional,tipo,valorConsulta,percDesconto,convenio)
VALUES('2020-02-15', '14:15:00', 2, '111.836.721.-99', 'Juliano Marques', '3366-1621', '2003-09-11',
'Sonia Domingos', 'Radiologista', 190.00, 0, 0);

--> 9
INSERT INTO agendamento(dataAgendamento,horario,duracao,cpf,nomePaciente,telefone,dataNascimento,
nomeProfissional,tipo,valorConsulta,percDesconto,convenio)
VALUES('2020-04-03', '09:00:00', 1, '258.746.755.-95', 'Marcelo Ferreira', '8555-6321', '1994-01-29',
'Vitoria de Paula Silva', 'Odontologia', 300.00, 5, 1);

--> 10
INSERT INTO agendamento(dataAgendamento,horario,duracao,cpf,nomePaciente,telefone,dataNascimento,
nomeProfissional,tipo,valorConsulta,percDesconto,convenio)
VALUES('2020-07-16', '08:00:00', 1, '377.986.155-59', 'Willain Simoes', '2399-5521', '1999-11-09',
'Vitoria de Paula Silva', 'Odontologia', 900.00, 10, 0);




--> RELATORIOS

--> 1
SELECT idAgendamento,
	dataAgendamento,
	horario,
	duracao,
	cpf,
	nomePaciente,
	telefone,
	dataNascimento,
	nomeProfissional,
	tipo,
	valorConsulta,
	percDesconto, 
	convenio
FROM agendamento
ORDER BY dataAgendamento;

--> 2
SELECT nomeProfissional,
	dataAgendamento,
	horario,
	duracao,
	nomePaciente
FROM agendamento 
WHERE dataAgendamento BETWEEN 'Parâmetro desejado' AND 'Parâmetro desejado'
ORDER BY nomeProfissional;

--> 3
SELECT nomeProfissional,
	dataAgendamento,
	horario,
	duracao,
	nomePaciente
FROM agendamento 
WHERE dataAgendamento BETWEEN 'Parâmetro desejado' AND 'Parâmetro desejado'
	AND tipo = 'Parâmetro desejado'
ORDER BY dataAgendamento DESC, 
	horario;
	
--> 4
SELECT cpf,
	nomePaciente,
	telefone,
	dataNascimento,
	(TIMESTAMPDIFF(YEAR, dataNascimento, CURDATE())) AS idade
FROM agendamento " +
WHERE MONTH(dataNascimento) = 'Parâmetro desejado';

--> 5
SELECT nomeProfissional
FROM agendamento
WHERE nomeProfissional LIKE '% Parâmetro desejado %'
ORDER BY nomeProfissional;

--> 6
SELECT idAgendamento, 
	COUNT(*) AS quantidade 
FROM agendamento
WHERE percDesconto != ""
AND convenio = 0;

--> 7
SELECT tipo, 
	AVG(valorConsulta) AS media, 
	COUNT(*) AS quantidade
FROM agendamento
GROUP BY tipo
ORDER BY tipo

--> 8
SELECT nomeProfissional,
	SUM(valorConsulta)  AS valorTotal  
FROM agendamento
GROUP BY nomeProfissional
HAVING SUM(valorConsulta) > 500;

--> 9
SELECT COUNT(*) AS qtdConsultas,
	SUM((valorConsulta - ((valorConsulta * percDesconto)/100))) AS valorTotal
FROM agendamento
WHERE MONTH(dataAgendamento) = 'Parâmetro desejado'; 

--> 10
SELECT nomeProfissional, 
	COUNT(*) AS qtdConsultas
FROM agendamento
WHERE MONTH(dataAgendamento) = 'Parâmetro desejado'
GROUP BY nomeProfissional
HAVING qtdConsultas >= 10
ORDER BY qtdConsultas DESC;