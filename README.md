# Cenário 3 — Sistema de Escola de Cursos Livres

## Tabelas do Banco de Dados (PostgreSQL)

### aluno
| Campo | Tipo | Descrição |
| :--- | :--- | :--- |
| id | SERIAL PK | Identificador único do aluno |
| nome | VARCHAR(100) | Nome completo do estudante |
| email | VARCHAR(100) | Correio eletrónico de contacto |
| telefone | VARCHAR(20) | Número de telefone/telemóvel |

### curso
| Campo | Tipo | Descrição |
| :--- | :--- | :--- |
| id | SERIAL PK | Identificador único do curso |
| nome | VARCHAR(100) | Nome da disciplina/curso |
| descricao | TEXT | Detalhes sobre a ementa |
| carga_horaria | INT | Carga horária total |
| vagas_totais | INT | Limite físico de vagas livres |

### matricula
| Campo | Tipo | Descrição |
| :--- | :--- | :--- |
| id | SERIAL PK | Protocolo único da inscrição |
| id_aluno | INT FK | Vínculo com a tabela aluno |
| id_curso | INT FK | Vínculo com a tabela curso |
| data_matricula | DATE | Data de efetivação da inscrição |
| valor | NUMERIC(10,2) | Aporte financeiro investido |
