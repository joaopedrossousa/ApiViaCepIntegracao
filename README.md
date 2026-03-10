# Consulta de CEP via API (Java)

## 📌 Descrição

Este projeto consiste em uma aplicação **Java executada via terminal** que realiza consultas de **CEP utilizando a API pública ViaCEP**.

O sistema permite que o usuário informe um CEP, consulte os dados do endereço e armazene o histórico das consultas realizadas em arquivos **JSON** e **TXT**.

A aplicação utiliza a biblioteca **Gson** para conversão de JSON e a **Java HTTP Client API** para realizar as requisições HTTP.

---

## ⚙️ Tecnologias utilizadas

* Java 11+
* API HTTP Client (`java.net.http`)
* Biblioteca **Gson**
* API pública **ViaCEP**
* Programação orientada a objetos

---

## 📂 Estrutura do projeto

```
src
│
├── Main.java
│
└── br/dev/viacep
    ├── InfoCep.java
    └── InfoCepJson.java
```

### Main.java

Responsável por:

* Ler o CEP informado pelo usuário
* Fazer requisição para a API ViaCEP
* Converter o JSON recebido
* Exibir as informações no terminal
* Salvar as consultas em arquivos



---

### InfoCep.java

Classe responsável por representar os **dados tratados do CEP** retornados pela API.

Ela recebe um objeto `InfoCepJson` e extrai os campos necessários.

Campos armazenados:

* Cidade
* Estado
* Região
* DDD

Também implementa `toString()` para formatar a saída no terminal.



---

### InfoCepJson.java

`record` que representa diretamente a **estrutura JSON retornada pela API**.

Ele é utilizado pela biblioteca Gson para fazer o **parse automático do JSON**.

Campos:

* `localidade`
* `estado`
* `regiao`
* `ddd`



---

## 🌐 API utilizada

ViaCEP

Endpoint utilizado:

```
https://viacep.com.br/ws/{CEP}/json/
```

Exemplo:

```
https://viacep.com.br/ws/01001000/json/
```

Retorno em JSON contendo dados do endereço referente ao CEP.

---

## ▶️ Como executar

1. Clone o repositório

```
git clone https://github.com/joaopedrossousa/seu-repositorio.git
```

2. Abra o projeto em uma IDE (IntelliJ, Eclipse ou VSCode)

3. Adicione a dependência do **Gson**

Exemplo Maven:

```xml
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.10.1</version>
</dependency>
```

4. Execute a classe:

```
Main.java
```

---

## 💻 Exemplo de execução

```
Seja bem vindo ao sistema de consulta de CEP :)

Informe o CEP que deseja consultar (Apenas Numeros):

01001000

Cidade: São Paulo
Estado: SP
Regiao: Sudeste
DDD: 11
```

Para encerrar o sistema:

```
SAIR
```

---

## 📁 Arquivos gerados

A aplicação gera dois arquivos automaticamente:

### cepsConsultados.json

Armazena todas as consultas realizadas em formato JSON.

Exemplo:

```json
[
  {
    "nomeCidade": "São Paulo",
    "nomeEstado": "SP",
    "regiao": "Sudeste",
    "ddd": "11"
  }
]
```

### cepsConsultados.txt

Armazena as consultas de forma **legível para humanos**.

Exemplo:

```
Cidade: São Paulo
Estado: SP
Regiao: Sudeste
DDD: 11
```

---

## 🚧 Tratamento de erros

O sistema possui tratamento para:

* CEP inválido
* Erros de conversão JSON
* Parâmetros inválidos

Utilizando:

* `JsonSyntaxException`
* `IllegalArgumentException`

---

## 📚 Objetivo do projeto

Este projeto foi desenvolvido com fins **educacionais** para praticar:

* Consumo de APIs REST em Java
* Manipulação de JSON
* Uso de `HttpClient`
* Organização de código em classes
* Persistência simples em arquivos

---

## 👨‍💻 Autor

Projeto desenvolvido para estudo de **integração com APIs em Java**.
