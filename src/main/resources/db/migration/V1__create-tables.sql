-- DROP TABLES
DROP TABLE IF EXISTS result_exam;
DROP TABLE IF EXISTS exam;
DROP TABLE IF EXISTS prescription;
DROP TABLE IF EXISTS medication;
DROP TABLE IF EXISTS treatment;
DROP TABLE IF EXISTS appointments;
DROP TABLE IF EXISTS pet;
DROP TABLE IF EXISTS species;
DROP TABLE IF EXISTS doctor;
DROP TABLE IF EXISTS specialty;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS user;


CREATE TABLE user (
  iduser bigint UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
  login varchar(255) UNIQUE NOT NULL,
  password varchar(255) NOT NULL,
  acess_level varchar(255),
  blocked boolean DEFAULT false,
  change_password boolean DEFAULT true,
  two_steps boolean DEFAULT false,
  dt_create datetime DEFAULT (now()),
  last_acess datetime DEFAULT (now())
);

CREATE TABLE client (
  idclient bigint UNIQUE PRIMARY KEY NOT NULL,
  name_client varchar(255) NOT NULL,
  cpf_client varchar(255) UNIQUE NOT NULL,
  rg_client varchar(255),
  email_client varchar(255),
  dt_birth date,
  iduser bigint
);

CREATE TABLE specialty (
  idspecialty bigint UNIQUE PRIMARY KEY NOT NULL,
  name_specialty varchar(255) NOT NULL
);

CREATE TABLE doctor (
  iddoctor bigint UNIQUE PRIMARY KEY NOT NULL,
  name_Doctor varchar(255) NOT NULL,
  CRM varchar(255) UNIQUE NOT NULL,
  cpf_Doctor varchar(255) UNIQUE NOT NULL,
  rg_Doctor varchar(255),
  email_Doctor varchar(255),
  dt_birth date,
  idspecialty bigint,
  iduser bigint
);

CREATE TABLE species (
  idspecies bigint UNIQUE PRIMARY KEY NOT NULL,
  name_species varchar(255)
);

CREATE TABLE pet (
  idpet bigint UNIQUE PRIMARY KEY NOT NULL,
  name_Pet varchar(255) NOT NULL,
  age int,
  dt_birth date,
  size varchar(255) NOT NULL,
  idspecies bigint,
  idclient bigint
);

CREATE TABLE appointments (
  idappointments bigint UNIQUE PRIMARY KEY NOT NULL,
  diagnosis_appointments varchar(255),
  dt_appointments datetime,
  obs_appointments varchar(255),
  iddoctor bigint,
  idpet bigint
);

CREATE TABLE treatment (
  idtreatment bigint UNIQUE PRIMARY KEY NOT NULL,
  desc_treatment varchar(255),
  dt_start date NOT NULL DEFAULT (now()),
  dt_end date,
  prize DECIMAL(10,2),
  idappointments bigint
);

CREATE TABLE medication (
  IDmedication bigint UNIQUE PRIMARY KEY NOT NULL,
  name_medication varchar(255) NOT NULL,
  prize DECIMAL(10,2)
);

CREATE TABLE prescription (
  IDPrescription bigint UNIQUE PRIMARY KEY NOT NULL,
  idtreatment bigint,
  idmedication bigint,
  dosage_medication varchar(255) NOT NULL,
  frequency_medication varchar(255) NOT NULL,
  dt_start date NOT NULL DEFAULT (now()),
  dt_end date,
  obs_medication varchar(255)
);

CREATE TABLE exam (
  idexam bigint UNIQUE PRIMARY KEY NOT NULL,
  name_exam varchar(255) NOT NULL,
  dt_request datetime NOT NULL,
  idappointments bigint
);

CREATE TABLE result_exam (
  IDResult_Exam bigint UNIQUE PRIMARY KEY NOT NULL,
  name_result_exam varchar(255) NOT NULL,
  desc_result_exam varchar(255),
  dt_result_exam datetime,
  idexam bigint
);

ALTER TABLE user COMMENT = 'Tabela de Usuarios';

ALTER TABLE client COMMENT = 'Tabela de Clientes';

ALTER TABLE specialty COMMENT = 'Tabela de Especialidades Medicas';

ALTER TABLE doctor COMMENT = 'Tabela de Medicos';

ALTER TABLE species COMMENT = 'Tabela de Especies';

ALTER TABLE pet COMMENT = 'Tabela de Animais';

ALTER TABLE appointments COMMENT = 'Tabela de Consulta';

ALTER TABLE treatment COMMENT = 'Tabela de Tratamento';

ALTER TABLE medication COMMENT = 'Tabela de Medicacao';

ALTER TABLE prescription COMMENT = 'Tabela de Receita';

ALTER TABLE exam COMMENT = 'Tabela de Exames';

ALTER TABLE result_exam COMMENT = 'Tabela de Resultado de Exames';

ALTER TABLE client ADD FOREIGN KEY (iduser) REFERENCES user (iduser);

ALTER TABLE doctor ADD FOREIGN KEY (idspecialty) REFERENCES specialty (idspecialty);

ALTER TABLE doctor ADD FOREIGN KEY (iduser) REFERENCES user (iduser);

ALTER TABLE pet ADD FOREIGN KEY (idspecies) REFERENCES species (idspecies);

ALTER TABLE pet ADD FOREIGN KEY (idclient) REFERENCES client (idclient);

ALTER TABLE appointments ADD FOREIGN KEY (iddoctor) REFERENCES doctor (iddoctor);

ALTER TABLE appointments ADD FOREIGN KEY (idpet) REFERENCES pet (idpet);

ALTER TABLE treatment ADD FOREIGN KEY (idappointments) REFERENCES appointments (idappointments);

ALTER TABLE prescription ADD FOREIGN KEY (idtreatment) REFERENCES treatment (idtreatment);

ALTER TABLE prescription ADD FOREIGN KEY (idmedication) REFERENCES medication (idmedication);

ALTER TABLE exam ADD FOREIGN KEY (idappointments) REFERENCES appointments (idappointments);

ALTER TABLE result_exam ADD FOREIGN KEY (idexam) REFERENCES exam (idexam);
