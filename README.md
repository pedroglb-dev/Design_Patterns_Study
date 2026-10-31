# Sistema de Pagamentos com Design Patterns

Projeto simples de uma API de pagamentos, desenvolvido para aprofundar meus estudos em **Design Patterns** com Java, usando **Spring Boot**.

Desenvolvido como parte do curso *Design Patterns com Java: Dos Clássicos (GoF) ao Spring Framework* do bootcamp DIO + Itaú.

## Tecnologias

- Java 25
- Spring Boot
- Maven

## Design Patterns utilizados

| Padrão | Onde aparece | Como funciona |
|---|---|---|
| **Strategy** | Interface `Pagamento` e classes `Pix`, `CartaoCredito`, `Boleto` | Cada forma de pagamento implementa `pagar()` do seu jeito, e o service usa a interface sem saber qual é a implementação. |
| **Factory (versão simples)** | `PagamentoService` | Um `Map<String, Pagamento>` injetado pelo Spring escolhe a estratégia pelo nome, sem `if` ou `switch`. |
| **Singleton** | Beans `@Component` e `@Service` | O Spring cria uma única instância de cada bean e a reaproveita. |

> Obs.: o Singleton aqui é o gerenciado pelo container do Spring, e não o Singleton clássico do GoF (construtor privado + `getInstance()`).

## Estrutura do projeto

```
com.exemplo.pagamentos
├── controller
│   └── PagamentoController.java
├── service
│   └── PagamentoService.java
├── strategy
│   ├── Pagamento.java
│   ├── Pix.java
│   ├── CartaoCredito.java
│   └── Boleto.java
└── dto
    └── PagamentoRequest.java
```

## Como executar

```bash
git clone <url-do-repositorio>
cd <nome-do-projeto>
./mvnw spring-boot:run
```

A API sobe em `http://localhost:8080`.

## Exemplo de uso

**Requisição:**

```bash
curl -X POST http://localhost:8080/pagamentos \
  -H "Content-Type: application/json" \
  -d '{"tipo": "pix", "valor": 150.0}'
```

**Resposta:**

```
Pix de R$150.0 realizado com sucesso!
```

Tipos aceitos: `pix`, `cartao`, `boleto`. Qualquer outro retorna **400 Bad Request**.

## Como adicionar uma nova forma de pagamento

Basta criar uma nova classe, sem alterar o service nem o controller:

```java
@Component("debito")
public class Debito implements Pagamento {
    @Override
    public String pagar(double valor) {
        return "Débito de R$" + valor + " realizado com sucesso!";
    }
}
```

## Próximos passos

- Adicionar o padrão **Observer** para notificar o cliente após o pagamento
- Incluir testes unitários com JUnit
- Persistir os pagamentos em banco de dados
