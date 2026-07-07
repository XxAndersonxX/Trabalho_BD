INSERT INTO Disciplina (nome_disciplina, creditos, curso, periodo) VALUES
('Banco de Dados', 4, 'Ciência da Computação', 4),
('Estrutura de Dados', 4, 'Ciência da Computação', 3),
('Programação Orientada a Objetos', 4, 'Ciência da Computação', 2),
('Engenharia de Software', 4, 'Ciência da Computação', 5),
('Inteligência Artificial', 4, 'Ciência da Computação', 6);

INSERT INTO Professor (nome_professor, email, telefone) VALUES
('Carlos Silva', 'carlos@ufg.br', '61999990001'),
('Ana Souza', 'ana@ufg.br', '61999990002'),
('Marcos Lima', 'marcos@ufg.br', '61999990003'),
('Fernanda Costa', 'fernanda@ufg.br', '61999990004'),
('João Oliveira', 'joao@ufg.br', '61999990005');

INSERT INTO Prova (peso, data) VALUES
(2.0,'2026-08-10'),
(3.0,'2026-08-20'),
(2.5,'2026-09-01'),
(4.0,'2026-09-15'),
(5.0,'2026-10-01');

INSERT INTO Aluno
(nome, email, curso, senha, ira, periodo, data_nascimento)
VALUES
('Ana','ana@email.com','Ciencia da Computacao','123',8.5,5,'2002-04-12'),
('Bruno', 'bruno@email.com','Ciencia da Computacao','456',7.8,3,'2003-02-10'),
('Carla' ,'carla@email.com','Engenharia Software','789',9.2,6,'2001-11-25'),
('Diego', 'diego@email.com','Sistemas Informacao','321',6.7,2,'2004-06-18'),
('Elisa', 'elisa@email.com','Ciencia da Computacao','654',8.9,4,'2002-09-30');

INSERT INTO Disciplina
(nome, creditos, curso, periodo)
VALUES
('Banco de Dados',4,'CIC',1),
('Inteligência Artificial',6,'Ciencia da Computacao',2),
('Calculo 1',4,'Engenharia Software',3),
('Sistemas Operacionais',5,'Sistemas Informacao',4),
('Calculo 2',4,'Ciencia da Computacao',5);

INSERT INTO Professor
(nome,email, telefone)
VALUES
('João', 'joao@universidade.com','61999990001'),
('Maria','maria@universidade.com','61999990002'),
('Carlos','carlos@universidade.com','61999990003'),
('Juliana','juliana@universidade.com','61999990004'),
('Roberto','roberto@universidade.com','61999990005');

INSERT INTO Aluno (email, curso, senha, ira, periodo, data_nascimento) VALUES
('daniel@aluno.ufg.br','Ciência da Computação','123',8.5,4,'2003-04-15'),
('maria@aluno.ufg.br','Ciência da Computação','123',9.1,5,'2002-07-18'),
('pedro@aluno.ufg.br','Ciência da Computação','123',7.8,3,'2004-01-20'),
('julia@aluno.ufg.br','Ciência da Computação','123',8.9,6,'2002-09-30'),
('lucas@aluno.ufg.br','Ciência da Computação','123',7.5,2,'2005-05-05');

INSERT INTO Grupo_Estudo (descricao) VALUES
('Grupo de Banco de Dados'),
('Grupo de Estrutura de Dados'),
('Grupo de POO'),
('Grupo de Engenharia de Software'),
('Grupo de IA');

INSERT INTO Material (tipo, link, codigo_FK) VALUES
('PDF','https://material.com/bd.pdf',1),
('Vídeo','https://material.com/ed.mp4',2),
('Slides','https://material.com/poo.pdf',3),
('Livro','https://material.com/es.pdf',4),
('PDF','https://material.com/ia.pdf',5);

INSERT INTO Turma (semestre, horario, codigo_FK, id_professor_FK) VALUES
(20261,'08:00:00',1,1),
(20261,'10:00:00',2,2),
(20261,'14:00:00',3,3),
(20261,'16:00:00',4,4),
(20261,'19:00:00',5,5);

INSERT INTO Notificacoes (data, status, descricao, matricula_FK) VALUES
('2026-07-08','Pendente','Entrega da atividade de Banco de Dados.',1),
('2026-07-10','Pendente','Reunião do grupo de estudos.',2),
('2026-07-12','Pendente','Estudar para prova de POO.',3),
('2026-07-13','Pendente','Prazo final para envio do trabalho.',4),
('2026-07-15','Pendente','Início da semana de apresentações.',5),
('2026-07-20','Pendente','Entrega do projeto final.',1);

INSERT INTO Notificacoes
(data,status,descricao,matricula_FK)
VALUES
('2026-06-11','Pendente','Nova atividade',1),
('2026-06-12','Lida','Prova marcada',2),
('2026-06-13','Pendente','Grupo atualizado',3),
('2026-06-14','Lida','Material disponível',4),
('2026-06-15','Pendente','Prazo alterado',5);

INSERT INTO Tarefa (prazo, status, matricula_FK) VALUES
('2026-07-15','Em andamento',1),
('2026-07-18','Pendente',2),
('2026-07-20','Concluída',3),
('2026-07-22','Pendente',4),
('2026-07-25','Em andamento',5);

INSERT INTO Horario_Estudo (hora_inicio, hora_fim, id_grupo_FK) VALUES
('08:00:00','10:00:00',1),
('10:30:00','12:00:00',2),
('14:00:00','16:00:00',3),
('16:30:00','18:00:00',4),
('19:00:00','21:00:00',5);

INSERT INTO Metas_Estudo (hora_meta, metas_estudo, id_grupo_FK) VALUES
(10,'Concluir exercícios de Banco de Dados',1),
(8,'Resolver listas de Estrutura de Dados',2),
(12,'Implementar projeto em Java',3),
(15,'Finalizar documentação do sistema',4),
(20,'Treinar modelos de IA',5);

INSERT INTO Tem (id_turma, id_prova) VALUES
(1,1),
(2,2),
(3,3),
(4,4),
(5,5);

INSERT INTO Matricula (id_turma, matricula) VALUES
(1,1),
(2,2),
(3,3),
(4,4),
(5,5);

INSERT INTO Participa (matricula, id_grupo) VALUES
(1,1),
(2,2),
(3,3),
(4,4),
(5,5);