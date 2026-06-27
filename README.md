# Cenário 2 — Sistema de Oficina Mecânica

## 📊 Tabelas do Banco de Dados (PostgreSQL)

### cliente
| Campo | Tipo | Restrição |
| :--- | :--- | :--- |
| id | SERIAL | PRIMARY KEY |
| nome | VARCHAR(100) | NOT NULL |
| telefone | VARCHAR(20) | NOT NULL |

### veiculo
| Campo | Tipo | Restrição |
| :--- | :--- | :--- |
| id | SERIAL | PRIMARY KEY |
| placa | VARCHAR(10) | NOT NULL, UNIQUE |
| modelo | VARCHAR(100) | NOT NULL |
| ano | INTEGER | NOT NULL |
| id_cliente | INTEGER | FK → cliente(id), NOT NULL |

### ordem_servico
| Campo | Tipo | Restrição |
| :--- | :--- | :--- |
| id | SERIAL | PRIMARY KEY |
| id_veiculo | INTEGER | FK → veiculo(id), NOT NULL |
| descricao | TEXT | NOT NULL |
| valor | NUMERIC(10,2) | NOT NULL, CHECK >= 0 |
| status | VARCHAR(20) | NOT NULL, DEFAULT 'ABERTA' |

---

## 🛠️ Comandos SQL (DDL)

```sql
CREATE TABLE cliente (
    id       SERIAL       PRIMARY KEY,
    nome     VARCHAR(100) NOT NULL,
    telefone VARCHAR(20)  NOT NULL
);

CREATE TABLE veiculo (
    id         SERIAL       PRIMARY KEY,
    placa      VARCHAR(10)  NOT NULL UNIQUE,
    modelo     VARCHAR(100) NOT NULL,
    ano        INTEGER      NOT NULL,
    id_cliente INTEGER      NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

CREATE TABLE ordem_servico (
    id         SERIAL        PRIMARY KEY,
    id_veiculo INTEGER       NOT NULL,
    descricao  TEXT          NOT NULL,
    valor      NUMERIC(10,2) NOT NULL CHECK (valor >= 0),
    status     VARCHAR(20)   NOT NULL DEFAULT 'ABERTA',
    FOREIGN KEY (id_veiculo) REFERENCES veiculo(id)
);
