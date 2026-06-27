# Cenário 2 — Sistema de Clínica Veterinária

## Tabelas do Banco de Dados (PostgreSQL)

### tutor
| Campo | Tipo | Descrição |
| :--- | :--- | :--- |
| id | SERIAL PK | Identificador único do tutor |
| nome | VARCHAR(100) | Nome do tutor |
| endereco | VARCHAR(200) | Endereço do tutor |
| telefone | VARCHAR(20) | Telefone do tutor |

### animal
| Campo | Tipo | Descrição |
| :--- | :--- | :--- |
| id | SERIAL PK | Identificador único |
| nome | VARCHAR(100) | Nome do animal |
| especie | VARCHAR(50) | Espécie do animal |
