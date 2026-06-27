# Cenário 1 — Sistema de Clínica Veterinária

## Tabelas do Banco de Dados (PostgreSQL)

### tutor
| Campo | Tipo | Descrição |
| :--- | :--- | :--- |
| id | SERIAL PK | Identificador único |
| nome | VARCHAR(100) | Nome do tutor |
| endereco | VARCHAR(200) | Endereço do tutor |
| telefone | VARCHAR(20) | Telefone do tutor |

### animal
| Campo | Tipo | Descrição |
| :--- | :--- | :--- |
| id | SERIAL PK | Identificador único |
| nome | VARCHAR(100) | Nome do animal |
| especie | VARCHAR(50) | Espécie do animal |
| raca | VARCHAR(50) | Raça do animal |
| id_tutor | INTEGER FK | Referência ao tutor |

### consulta
| Campo | Tipo | Descrição |
| :--- | :--- | :--- |
| id | SERIAL PK | Identificador único |
| id_animal | INTEGER FK | Referência ao animal |
| data | DATE | Data da consulta |
| motivo | VARCHAR(200) | Motivo do atendimento |
| valor | NUMERIC(10,2) | Valor cobrado |
