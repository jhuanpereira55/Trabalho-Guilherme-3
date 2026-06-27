# Cenário 3 — Sistema de Escola de Cursos Livres

## Tabelas do Banco de Dados (PostgreSQL)

### aluno
| Coluna | Tipo | Restrições |
| :--- | :--- | :--- |
| id | SERIAL | PRIMARY KEY |
| nome | VARCHAR(100) | NOT NULL |
| email | VARCHAR(150) | NOT NULL |
| telefone | VARCHAR(20) | NOT NULL |

### curso
| Coluna | Tipo | Restrições |
| :--- | :--- | :--- |
| id | SERIAL | PRIMARY KEY |
| nome | VARCHAR(100) | NOT NULL |
| descricao | TEXT | - |
| carga_horaria | INTEGER | NOT NULL, CHECK (> 0) |
| vagas_totais | INTEGER | NOT NULL, CHECK (> 0) |
| vagas_disponiveis | INTEGER | NOT NULL, CHECK (>= 0) |

### matricula
| Coluna | Tipo | Restrições |
| :--- | :--- | :--- |
| id | SERIAL | PRIMARY KEY |
| id_aluno | INTEGER | NOT NULL, FK → aluno(id) |
| id_curso | INTEGER | NOT NULL, FK → curso(id) |
| data_matricula | DATE | NOT NULL |
| valor | NUMERIC(10,2) | NOT NULL, CHECK (>= 0) |
| UNIQUE | (id_aluno, id_curso) | Impede matrícula duplicada |

---

## Comandos SQL (DDL)

```sql
CREATE TABLE aluno (
    id        SERIAL        PRIMARY KEY,
    nome      VARCHAR(100)  NOT NULL,
    email     VARCHAR(150)  NOT NULL,
    telefone  VARCHAR(20)   NOT NULL
);

CREATE TABLE curso (
    id                 SERIAL        PRIMARY KEY,
    nome               VARCHAR(100)  NOT NULL,
    descricao          TEXT,
    carga_horaria      INTEGER       NOT NULL CHECK (carga_horaria > 0),
    vagas_totais       INTEGER       NOT NULL CHECK (vagas_totais > 0),
    vagas_disponiveis  INTEGER       NOT NULL CHECK (vagas_disponiveis >= 0)
);

CREATE TABLE matricula (
    id              SERIAL   PRIMARY KEY,
    id_aluno        INTEGER  NOT NULL REFERENCES aluno(id),
    id_curso        INTEGER  NOT NULL REFERENCES curso(id),
    data_matricula  DATE     NOT NULL,
    valor           NUMERIC(10,2) NOT NULL CHECK (valor >= 0),
    UNIQUE (id_aluno, id_curso)
);
