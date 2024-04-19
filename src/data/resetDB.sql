DROP TABLE IF EXISTS Administrador;

CREATE TABLE
  Administrador (
    id_adm integer primary key autoincrement not null,
    cpf text not null,
    telefone text not null,
    data_nascimento date not null,
    sexo bool not null,
    salario double not null,
    "horario_trabalho_inicio" time not null,
    "horario_trabalho_final" time not null,
    login text not null,
    senha text not null,
    nome varchar not null,
    "data_admissao" DATE NOT NULL
  );

DROP TABLE IF EXISTS Consulta;

CREATE TABLE
  Consulta (
    id_consulta INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    data_consulta DATE NOT NULL,
    hora_consulta TIME,
    sintomas TEXT,
    precisa_internar BOOL,
    encaminhamento text,
    id_paciente integer,
    id_medico integer,
    FOREIGN KEY (id_paciente) REFERENCES Paciente (id_paciente),
    FOREIGN KEY (id_medico) REFERENCES Medico (id_medico)
  );

DROP TABLE IF EXISTS Enfermaria;

CREATE TABLE Enfermaria (
    id_enfermaria INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    qnt_leitos INTEGER NOT NULL,
    leitos_disponiveis INTEGER NOT NULL,
    id_enfermeiro INTEGER, 
    id_enfermeiro2 INTEGER,
    id_enfermeiro3 INTEGER, 
    FOREIGN KEY (id_enfermeiro) REFERENCES Enfermeiro (id_enfermeiro),
    FOREIGN KEY (id_enfermeiro2) REFERENCES Enfermeiro (id_enfermeiro),
    FOREIGN KEY (id_enfermeiro3) REFERENCES Enfermeiro (id_enfermeiro)
);

DROP TABLE IF EXISTS Enfermeiro;

CREATE TABLE
  Enfermeiro (
    id_enfermeiro integer primary key autoincrement not null,
    cpf text not null,
    telefone text not null,
    data_nascimento date not null,
    sexo bool not null,
    salario double not null,
    "horario_trabalho_inicio" time not null,
    "horario_trabalho_final" time not null,
    coren text not null,
    nome varchar not null,
    "data_admissao" date not null
  );

DROP TABLE IF EXISTS Internacao;

CREATE TABLE
  Internacao (
    id_internacao INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    data_internacao DATE NOT NULL,
    dat_alta DATE,
    id_paciente INTEGER,
    id_enfermaria INTEGER,
    FOREIGN KEY (id_paciente) REFERENCES Paciente (id_paciente),
    FOREIGN KEY (id_enfermaria) REFERENCES Enfermaria (id_enfermaria)
  );

DROP TABLE IF EXISTS Med_presc;

CREATE TABLE
  Med_presc (
    id_prescricao integer,
    id_medicamento integer,
    FOREIGN KEY (id_prescricao) REFERENCES Prescricao (id_prescricao),
    FOREIGN KEY (id_medicamento) REFERENCES Medicamento (id_medicamento)
  );

DROP TABLE IF EXISTS Medicamento;

CREATE TABLE
  Medicamento (
    id_medicamento INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    nome TEXT NOT NULL
  );

DROP TABLE IF EXISTS Medico;

CREATE TABLE Medico (
  id_medico INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  nome TEXT NOT NULL,
  cpf TEXT NOT NULL,
  telefone TEXT NOT NULL,
  data_nascimento DATE NOT NULL,
  sexo BOOL NOT NULL,
  salario REAL NOT NULL,
  data_admissao DATE NOT NULL DEFAULT CURRENT_DATE,
  horario_trabalho_inicio TIME NOT NULL,
  horario_trabalho_final TIME NOT NULL,  
  crm TEXT NOT NULL,
  especialidade TEXT NOT NULL,
  plantao BOOL NOT NULL
);

DROP TABLE IF EXISTS Paciente;

CREATE TABLE Paciente (
  id_paciente INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	nome TEXT NOT NULL,
  cpf TEXT NOT NULL,
  telefone TEXT NOT NULL,
  data_nascimento DATE NOT NULL,
  sexo BOOL NOT NULL,
  internado BOOL NOT NULL,
  plano_saude BOOL NOT NULL
);

DROP TABLE IF EXISTS Prescricao;

CREATE TABLE
  Prescricao (
    id_prescricao INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    medicacao TEXT,
    dosagem TEXT,
    posologia TEXT
  )