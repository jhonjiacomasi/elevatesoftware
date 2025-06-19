# 🛗 Sistema de Análise de Uso de Elevadores - *Elevatesoftware*

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/jhonjiacomasi/elevatesoftware/blob/master/LICENSE)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

## 📌 Sobre o Projeto

Este projeto simula a análise de utilização de elevadores no prédio 99A da Tecnopuc. O objetivo é otimizar o sistema de controle dos elevadores com base nos dados de uso fornecidos.

A aplicação analisa um arquivo `input.json` com os registros de uso dos elevadores e gera estatísticas relevantes, como:

- 🚪 Andar menos utilizado pelos usuários  
- 🛗 Elevador mais utilizado e seu período de maior fluxo  
- 🛗 Elevador menos utilizado e seu período de menor fluxo  
- ⏰ Período de maior utilização entre todos os elevadores  
- 📊 Percentual de uso de cada elevador em relação ao total de serviços prestados

---

## 🚀 Tecnologias Utilizadas

### ✅ Back-end
- Java 17
- Spring Boot
- Maven
- Lombok
- Leitura de arquivos JSON
- Interface `IElevadorService` conforme especificado

---

## 🔧 Como Executar o Projeto

### 🔁 Clonando o Repositório

```bash
git clone https://github.com/jhonjiacomasi/elevatesoftware
cd elevatesoftware
```

### ⚙️ Pré-requisitos

Certifique-se de ter instalado:

- Java 17  
- Maven 3.3.9 ou superior

### 📦 Compilação e Execução

Para compilar e instalar as dependências:

```bash
mvn clean package
```

Para iniciar a aplicação:

```bash
mvn spring-boot:run
```

---

## 📡 APIs Disponíveis

O projeto oferece uma API REST que consome e produz dados em JSON. Abaixo estão os endpoints disponíveis:

| Método | Endpoint                         | Descrição                                                        |
|--------|---------------------------------|-----------------------------------------------------------------|
| GET    | `/andarMenosUtilizado`           | Retorna o(s) andar(es) menos utilizados                         |
| GET    | `/elevadorMaisUtilizadocomPeriodo` | Retorna o(s) elevador(es) mais utilizados e seus períodos de maior uso |
| GET    | `/elevadorMenosUtilizadocomPeriodo` | Retorna o(s) elevador(es) menos utilizados e seus períodos de menor uso |
| GET    | `/maiorUtilizacaoConjuntoElevadores` | Retorna o(s) período(s) de maior utilização considerando todos os elevadores |
| GET    | `/percentualDeUsoTodosElevadores` | Retorna o percentual de uso de cada elevador                   |

### 🧪 Exemplos de Respostas

#### `/andarMenosUtilizado`

```json
[0, 14]
```

#### `/elevadorMaisUtilizadocomPeriodo`

```json
{
  "elevador": "A",
  "periodos": ["M", "V"]
}
```

#### `/elevadorMenosUtilizadocomPeriodo`

```json
[
  {
    "elevador": "D",
    "periodos": ["N"]
  },
  {
    "elevador": "E",
    "periodos": ["N"]
  }
]
```

#### `/maiorUtilizacaoConjuntoElevadores`

```json
["M"]
```

#### `/percentualDeUsoTodosElevadores`

```json
{
  "A": 23.5,
  "B": 19.7,
  "C": 21.4,
  "D": 17.6,
  "E": 17.8
}
```

---

## 👤 Autor

**Jhonatan Santana Giacomasi Barros**  
🔗 [LinkedIn](https://www.linkedin.com/in/jhonatan-giacomasi/)  
🔗 [GitHub](https://github.com/jhonjiacomasi)
