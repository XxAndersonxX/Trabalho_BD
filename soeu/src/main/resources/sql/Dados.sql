INSERT INTO Disciplina (nome, creditos, curso, periodo)
VALUES
('BD',4,'CC',5),
('POO',4,'CC',3),
('ED',4,'CC',2),
('ES',4,'CC',6),
('SO',4,'CC',4),
('IA',4,'CC',7),
('CG',4,'CC',5),
('RC',4,'CC',4);

INSERT INTO Professor (nome, email, telefone)
VALUES
('Carlos Alberto','carlos.alberto@unb.br','(61)99999-1001'),
('Maria Fernanda','maria.fernanda@unb.br','(61)99999-1002'),
('João Pedro','joao.pedro@unb.br','(61)99999-1003'),
('Ana Paula','ana.paula@unb.br','(61)99999-1004'),
('Ricardo Gomes','ricardo.gomes@unb.br','(61)99999-1005'),
('Patrícia Lima','patricia.lima@unb.br','(61)99999-1006'),
('Felipe Santos','felipe.santos@unb.br','(61)99999-1007'),
('Juliana Costa','juliana.costa@unb.br','(61)99999-1008');

INSERT INTO Aluno
(nome,email,curso,senha,ira,periodo,data_nascimento)
VALUES
('Daniel Alves','daniel.alves@unb.br','CC','123456',8.75,5,'2003-04-18'),
('Lucas Martins','lucas.martins@unb.br','CC','123456',7.90,3,'2004-02-10'),
('Mariana Souza','mariana.souza@unb.br','CC','123456',9.10,6,'2002-11-25'),
('Pedro Henrique','pedro.henrique@unb.br','CC','123456',8.20,2,'2004-06-30'),
('Gabriela Rocha','gabriela.rocha@unb.br','CC','123456',9.30,7,'2002-09-15'),
('Bruno Silva','bruno.silva@unb.br','CC','123456',7.85,4,'2003-12-08'),
('Amanda Oliveira','amanda.oliveira@unb.br','CC','123456',8.95,5,'2003-05-27'),
('Matheus Pereira','matheus.pereira@unb.br','CC','123456',8.10,6,'2002-08-19');

INSERT INTO Grupo_Estudo (descricao)
VALUES
('Grupo BD'),
('Grupo POO'),
('Grupo ED'),
('Grupo IA'),
('Grupo SO');

INSERT INTO Material
(tipo,link,nome_arquivo,arquivo,codigo_FK)
VALUES
('PDF','https://aprender.unb.br/bd.pdf','BD.pdf',NULL,1),
('Slides','https://aprender.unb.br/poo.pdf','POO.pdf',NULL,2),
('PDF','https://aprender.unb.br/ed.pdf','ED.pdf',NULL,3),
('Slides','https://aprender.unb.br/es.pdf','ES.pdf',NULL,4),
('PDF','https://aprender.unb.br/so.pdf','SO.pdf',NULL,5),
('Vídeo','https://youtube.com/videoIA',NULL,NULL,6),
('PDF','https://aprender.unb.br/cg.pdf','CG.pdf',NULL,7),
('Slides','https://aprender.unb.br/rc.pdf','RC.pdf',NULL,8);

INSERT INTO Turma
(semestre,horario,codigo_FK,id_professor_FK)
VALUES
(20261,'08:00:00',1,1),
(20261,'10:00:00',2,2),
(20261,'14:00:00',3,3),
(20261,'16:00:00',4,4),
(20261,'18:00:00',5,5),
(20261,'09:00:00',6,6),
(20261,'13:00:00',7,7),
(20261,'19:00:00',8,8);

INSERT INTO Prova (peso,data)
VALUES
(2.0,'2026-08-01'),
(3.0,'2026-08-05'),
(2.5,'2026-08-10'),
(4.0,'2026-08-18'),
(3.5,'2026-08-25'),
(5.0,'2026-09-01'),
(2.0,'2026-09-08'),
(4.5,'2026-09-15');

INSERT INTO Notificacoes
(data,status,descricao,matricula_FK)
VALUES
('2026-07-08','Lido','Prova de BD',1),
('2026-07-09','Lido','Prova de POO',1),
('2026-07-10','Lido','Prova de ED',2),
('2026-07-11','Lido','Prova de ES',2),
('2026-07-12','Lido','Prova de SO',3),
('2026-07-13','Lido','Prova de IA',3),
('2026-07-14','Lido','Prova de CG',4),
('2026-07-08','Lido','Prova de RC',5),
('2026-07-09','Lido','Prova de BD',6),
('2026-07-10','Lido','Prova de SO',7),
('2026-07-11','Lido','Prova de IA',8);

INSERT INTO Tarefa
(prazo,status,matricula_FK)
VALUES
('2026-07-18','Pendente',1),
('2026-07-20','Em andamento',2),
('2026-07-19','Pendente',3),
('2026-07-25','Concluída',4),
('2026-07-21','Pendente',5),
('2026-07-22','Em andamento',6),
('2026-07-24','Pendente',7),
('2026-07-26','Concluída',8);

INSERT INTO Horario_Estudo
(hora_inicio,hora_fim,id_grupo_FK)
VALUES
('08:00:00','10:00:00',1),
('10:00:00','12:00:00',2),
('14:00:00','16:00:00',3),
('16:00:00','18:00:00',4),
('19:00:00','21:00:00',5);

INSERT INTO Metas_Estudo
(hora_meta,metas_estudo,id_grupo_FK)
VALUES
(20,'Resolver lista BD',1),
(18,'Implementar projeto POO',2),
(15,'Estudar árvores',3),
(12,'Treinar algoritmos IA',4),
(10,'Revisar processos SO',5);

INSERT INTO Tem
(id_turma,id_prova)
VALUES
(1,1),
(2,2),
(3,3),
(4,4),
(5,5),
(6,6),
(7,7),
(8,8);

INSERT INTO Matricula
(id_turma,matricula)
VALUES
(1,1),
(2,1),
(3,1),
(4,2),
(5,2),
(6,3),
(7,4),
(8,5),
(2,6),
(3,7),
(1,8);

INSERT INTO Participa
(matricula,id_grupo)
VALUES
(1,1),
(1,2),
(2,2),
(3,3),
(4,4),
(5,5),
(6,1),
(7,3),
(8,5);