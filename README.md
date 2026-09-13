# CONSTRUMOB

MVP acadêmico do **Sistema de Uberização para Serviços de Construção Civil**, desenvolvido para a disciplina de Engenharia de Software do Bacharelado em Ciência da Computação do IFPA – Campus Tucuruí.

## Stack da Macroetapa 14

- **Front-end:** Thymeleaf 3.x + Bootstrap 5.3.3 (interface web responsiva)
- **Back-end:** Java 21 LTS + Spring Boot 3.5.5
- **Persistência:** Spring Data JPA / Hibernate
- **Banco de dados:** MySQL 8.4 LTS
- **Build:** Apache Maven 3.9+
- **Testes:** JUnit 5 (via `spring-boot-starter-test`)
- **Versionamento:** Git + GitHub

## Funcionalidades implementadas no MVP

1. Cadastro de clientes.
2. Cadastro e validação de profissionais.
3. Cadastro de tipos de serviço.
4. Publicação de demanda de serviço com localidade e descrição.
5. Listagem e visualização de demandas.
6. Aceite da demanda por profissional validado.
7. Cálculo automático do total do pedido.
8. Pagamento modelado com Strategy/Factory (`PIX` ou `CARTAO`) para fins acadêmicos.
9. Cancelamento e finalização de pedido.
10. Avaliação do serviço com nota de 1 a 5.

> O processamento financeiro real continua fora do escopo do MVP. As classes de pagamento implementam apenas validação acadêmica do modelo definido no projeto.

## Arquitetura

O código segue **Arquitetura em Camadas**:

```text
controller -> service -> domain/repository -> MySQL
      |                     |
      +---- Thymeleaf ------+
```

Padrões utilizados:

- **Repository:** Spring Data JPA abstrai o acesso a dados.
- **Strategy:** subclasses `PagamentoPix` e `PagamentoCartao` encapsulam validações distintas.
- **Factory Method (fábrica simples):** `PagamentoFactory` centraliza a criação das estratégias de pagamento.

## Organização do repositório

```text
construmob/
├── pom.xml
├── docker-compose.yml
├── README.md
├── src/main/java/br/edu/ifpa/construmob/
│   ├── config/
│   ├── controller/
│   ├── domain/
│   │   └── enums/
│   ├── exception/
│   ├── repository/
│   └── service/
├── src/main/resources/
│   ├── application.properties
│   ├── static/css/
│   └── templates/
└── src/test/java/
```

## Como executar

### 1. Pré-requisitos

- JDK 21
- Maven 3.9+
- Docker + Docker Compose (recomendado) ou MySQL 8.4 local

### 2. Subir o banco

```bash
docker compose up -d
```

### 3. Executar a aplicação

```bash
mvn spring-boot:run
```

Acesse `http://localhost:8080`.

### 4. Executar testes

```bash
mvn test
```

## Variáveis de ambiente

| Variável | Valor padrão |
|---|---|
| `DB_URL` | `jdbc:mysql://localhost:3306/construmob?...` |
| `DB_USER` | `construmob` |
| `DB_PASSWORD` | `construmob123` |
| `SERVER_PORT` | `8080` |

Em produção, não mantenha credenciais no repositório: defina-as por variáveis de ambiente/segredos.

## Convenções de desenvolvimento

- Pacotes e variáveis em `lowerCamelCase`; classes em `PascalCase`; constantes em `UPPER_SNAKE_CASE`.
- Commits curtos e objetivos no padrão `tipo: descrição`, por exemplo `feat: criar fluxo de publicação de demanda`.
- Branches sugeridas: `feature/...`, `fix/...`, `docs/...`.
- Não versionar `target/`, arquivos de IDE, logs nem segredos.
- Toda regra de negócio fica em `domain`/`service`; controllers somente coordenam HTTP e navegação.
- Alterações relevantes devem vir acompanhadas de testes e atualização da documentação.

## Autor

**Marcelo Chaves de Miranda** — IFPA, Campus Tucuruí, 2026.
