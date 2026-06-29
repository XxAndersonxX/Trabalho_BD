CREATE TABLE Disciplina (
    codigo INTEGER AUTO_INCREMENT PRIMARY KEY,
    creditos INTEGER,
    curso VARCHAR(50),
    periodo INTEGER
);

CREATE TABLE Professor (
    id_professor INTEGER AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255),
    telefone VARCHAR(20)
);

CREATE TABLE Prova (
    id_prova INTEGER AUTO_INCREMENT PRIMARY KEY,
    peso DOUBLE,
    data DATE
);

CREATE TABLE Aluno (
    matricula INTEGER AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255),
    curso VARCHAR(50),
    senha VARCHAR(50),
    ira DOUBLE,
    periodo INTEGER,
    data_nascimento DATE
);

CREATE TABLE Grupo_Estudo (
    id_grupo INTEGER AUTO_INCREMENT PRIMARY KEY,
    descricao TEXT
);

CREATE TABLE Material (
    id_material INTEGER AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(50),
    link VARCHAR(255),
    codigo_FK INTEGER,
    
    FOREIGN KEY (codigo_FK)
        REFERENCES Disciplina(codigo)
        ON DELETE CASCADE
);

CREATE TABLE Turma (
    id_turma INTEGER AUTO_INCREMENT PRIMARY KEY,
    semestre INTEGER,
    horario TIME,
    codigo_FK INTEGER,
    id_professor_FK INTEGER,
    
    FOREIGN KEY (codigo_FK)
        REFERENCES Disciplina(codigo)
        ON DELETE CASCADE,
        
    FOREIGN KEY (id_professor_FK)
        REFERENCES Professor(id_professor)
        ON DELETE CASCADE
);

CREATE TABLE Notificacoes (
    id_notificacao INTEGER AUTO_INCREMENT PRIMARY KEY,
    data DATE,
    status VARCHAR(20),
    descricao TEXT,
    matricula_FK INTEGER,
    
    FOREIGN KEY (matricula_FK)
        REFERENCES Aluno(matricula)
        ON DELETE CASCADE
);

CREATE TABLE Tarefa (
    id_tarefa INTEGER AUTO_INCREMENT PRIMARY KEY,
    prazo DATE,
    status VARCHAR(20),
    matricula_FK INTEGER,
    
    FOREIGN KEY (matricula_FK)
        REFERENCES Aluno(matricula)
        ON DELETE CASCADE
);

CREATE TABLE Horario_Estudo (
    id_horario INTEGER AUTO_INCREMENT PRIMARY KEY,
    hora_inicio TIME,
    hora_fim TIME,
    id_grupo_FK INTEGER,
    
    FOREIGN KEY (id_grupo_FK)
        REFERENCES Grupo_Estudo(id_grupo)
        ON DELETE CASCADE
);

CREATE TABLE Metas_Estudo (
    id_metas INTEGER AUTO_INCREMENT PRIMARY KEY,
    hora_meta INTEGER,
    metas_estudo VARCHAR(255),
    id_grupo_FK INTEGER,
    
    FOREIGN KEY (id_grupo_FK)
        REFERENCES Grupo_Estudo(id_grupo)
        ON DELETE CASCADE
);

CREATE TABLE Tem (
    id_turma INTEGER,
    id_prova INTEGER,
    PRIMARY KEY (id_turma, id_prova),
    
    FOREIGN KEY (id_turma)
        REFERENCES Turma(id_turma)
        ON DELETE CASCADE,
        
    FOREIGN KEY (id_prova)
        REFERENCES Prova(id_prova)
        ON DELETE CASCADE
);

CREATE TABLE Matricula (
    id_turma INTEGER,
    matricula INTEGER,
    PRIMARY KEY (id_turma, matricula),
    
    FOREIGN KEY (id_turma)
        REFERENCES Turma(id_turma)
        ON DELETE CASCADE,
        
    FOREIGN KEY (matricula)
        REFERENCES Aluno(matricula)
        ON DELETE CASCADE
);

CREATE TABLE Participa (
    matricula INTEGER,
    id_grupo INTEGER,
    PRIMARY KEY (matricula, id_grupo),
    
    FOREIGN KEY (matricula)
        REFERENCES Aluno(matricula)
        ON DELETE CASCADE,
        
    FOREIGN KEY (id_grupo)
        REFERENCES Grupo_Estudo(id_grupo)
        ON DELETE CASCADE
);