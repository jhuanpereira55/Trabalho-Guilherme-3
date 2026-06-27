# Cenário 1 — Sistema de Clínica Veterinária

## Tabelas do Banco de Dados (PostgreSQL)

### tutor
| Campo | Tipo | Descrição |
| :--- | :--- | :--- |
| id | SERIAL | PRIMARY KEY |
| nome | VARCHAR(100) | NOT NULL |
| endereco | VARCHAR(200) | NOT NULL |
| telefone | VARCHAR(20) | NOT NULL |

### animal
| Campo | Tipo | Descrição |
| :--- | :--- | :--- |
| id | SERIAL | PRIMARY KEY |
| nome | VARCHAR(100) | NOT NULL |
| especie | VARCHAR(50) | NOT NULL |
| raca | VARCHAR(50) | NOT NULL |
| id_tutor | INTEGER | FK → tutor(id), NOT NULL |

### consulta
| Campo | Tipo | Descrição |
| :--- | :--- | :--- |
| id | SERIAL | PRIMARY KEY |
| id_animal | INTEGER | FK → animal(id), NOT NULL |
| data | DATE | NOT NULL |
| motivo | VARCHAR(200) | NOT NULL |
| valor | NUMERIC(10,2) | NOT NULL, CHECK >= 0 |

---

## Comandos SQL (DDL)

```sql
CREATE TABLE tutor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(200) NOT NULL,
    telefone VARCHAR(20) NOT NULL
);

CREATE TABLE animal (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    especie VARCHAR(50) NOT NULL,
    raca VARCHAR(50) NOT NULL,
    id_tutor INTEGER NOT NULL,
    FOREIGN KEY (id_tutor) REFERENCES tutor(id)
);

CREATE TABLE consulta (
    id SERIAL PRIMARY KEY,
    id_animal INTEGER NOT NULL,
    data DATE NOT NULL,
    motivo VARCHAR(200) NOT NULL,
    valor NUMERIC(10,2) NOT NULL CHECK (valor >= 0),
    FOREIGN KEY (id_animal) REFERENCES animal(id)
);
