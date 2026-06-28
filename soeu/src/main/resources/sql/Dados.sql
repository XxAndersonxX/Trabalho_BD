INSERT INTO Aluno
(email, curso, senha, ira, periodo, data_nascimento)
VALUES
('ana@email.com','Ciencia da Computacao','123',8.5,5,'2002-04-12'),
('bruno@email.com','Ciencia da Computacao','456',7.8,3,'2003-02-10'),
('carla@email.com','Engenharia Software','789',9.2,6,'2001-11-25'),
('diego@email.com','Sistemas Informacao','321',6.7,2,'2004-06-18'),
('elisa@email.com','Ciencia da Computacao','654',8.9,4,'2002-09-30');

INSERT INTO Disciplina
(creditos, curso, periodo)
VALUES
(4,'Ciencia da Computacao',1),
(6,'Ciencia da Computacao',2),
(4,'Engenharia Software',3),
(5,'Sistemas Informacao',4),
(4,'Ciencia da Computacao',5);

INSERT INTO Professor
(email, telefone)
VALUES
('joao@universidade.com','61999990001'),
('maria@universidade.com','61999990002'),
('carlos@universidade.com','61999990003'),
('juliana@universidade.com','61999990004'),
('roberto@universidade.com','61999990005');

INSERT INTO Grupo_Estudo
(descricao)
VALUES
('Grupo Algoritmos'),
('Grupo Banco de Dados'),
('Grupo IA'),
('Grupo Redes'),
('Grupo Programacao Java');

INSERT INTO Horario_Estudo
(hora_inicio,hora_fim,id_grupo_FK)
VALUES
('08:00:00','10:00:00',1),
('14:00:00','16:00:00',2),
('10:00:00','12:00:00',3),
('19:00:00','21:00:00',4),
('15:00:00','17:00:00',5);

INSERT INTO Metas_Estudo
(hora_meta, metas_estudo, id_grupo_FK)
VALUES
(10,'Resolver exercicios',1),
(12,'Estudar SQL',2),
(8,'Ler artigos IA',3),
(15,'Configurar redes',4),
(20,'Praticar Java',5);

INSERT INTO Material
(tipo, link, codigo_FK)
VALUES
('PDF','https://material1.com',1),
('Video','https://material2.com',2),
('Livro','https://material3.com',3),
('Slides','https://material4.com',4),
('PDF','https://material5.com',5);

INSERT INTO Prova
(peso,data)
VALUES
(2.5,'2026-07-10'),
(3.0,'2026-07-15'),
(1.5,'2026-07-20'),
(2.0,'2026-07-25'),
(4.0,'2026-07-30');

INSERT INTO Turma
(semestre,horario,codigo_FK,id_professor_FK)
VALUES
(20261,'08:00:00',1,1),
(20261,'10:00:00',2,2),
(20261,'14:00:00',3,3),
(20261,'16:00:00',4,4),
(20261,'19:00:00',5,5);

INSERT INTO Notificacoes
(data,status,descricao,matricula_FK)
VALUES
('2026-06-01','Pendente','Nova atividade',1),
('2026-06-02','Lida','Prova marcada',2),
('2026-06-03','Pendente','Grupo atualizado',3),
('2026-06-04','Lida','Material disponível',4),
('2026-06-05','Pendente','Prazo alterado',5);

INSERT INTO Tarefa
(prazo,status,matricula_FK)
VALUES
('2026-07-01','Pendente',1),
('2026-07-02','Concluida',2),
('2026-07-03','Pendente',3),
('2026-07-04','Concluida',4),
('2026-07-05','Pendente',5);

INSERT INTO Matricula
(id_turma,matricula)
VALUES
(1,1),
(2,2),
(3,3),
(4,4),
(5,5);

INSERT INTO Participa
(matricula,id_grupo)
VALUES
(1,1),
(2,2),
(3,3),
(4,4),
(5,5);

INSERT INTO Tem
(id_prova,id_turma)
VALUES
(1,1),
(2,2),
(3,3),
(4,4),
(5,5);