# Desafio Técnico - Desenvolvedor Java com Spring Junior

## Introdução

Neste desafio técnico, você será responsável por desenvolver um sistema CRUD web usando Java com Spring Framework. O sistema deverá receber um payload contendo o código de um vendedor e uma lista de pagamentos, onde cada pagamento é composto por um código identificador, o documento (CPF/CNPJ) do pagador e o status do pagamento (PAGO, NÃO PAGO, CANCELADO). O sistema deverá salvar esses dados em uma base de dados, que pode ser um banco H2, e permitir a consulta e alteração do status dos pagamentos.

## Requisitos Funcionais

1. O sistema deve ter um endpoint para criar um novo vendedor, recebendo um payload com o código do vendedor.
2. O sistema deve ter um endpoint para adicionar pagamentos ao vendedor, recebendo um payload contendo a lista de pagamentos.
3. Cada pagamento deve ser composto por um código identificador, o documento do pagador (CPF/CNPJ) e o status do pagamento.
4. O sistema deve permitir a consulta de um pagamento específico, filtrando pelo código do pagamento.
5. O sistema deve permitir a alteração do status de um pagamento específico, identificado pelo código do pagamento.

## Requisitos Técnicos

1. O projeto deve ser desenvolvido em Java utilizando o framework Spring.
2. Utilize a abordagem de injeção de dependências do Spring para gerenciar os componentes.
3. O banco de dados utilizado deve ser o H2 Database.
4. Crie testes unitários para garantir o correto funcionamento das funcionalidades do sistema.
5. Disponibilize uma pequena documentação no repositório, especificando os paths das rotas e a porta do serviço para que possa ser invocado por ferramentas como o Postman.


## Entregáveis

1. O código do projeto desenvolvido, com todas as funcionalidades implementadas e testes unitários.
2. O banco de dados configurado e populado para demonstração do sistema.
3. A documentação no repositório, detalhando as rotas disponíveis, suas descrições e a porta do serviço.


**Sugestão de payload de Entrada:**
```json
POST /api/payment
{
  "seller_code": "VEN001",
  "payment":[
    {
        "payment_code":"PAY001",
        "doc_payer":"00000000000",
        "status":"PAYED"
    }
  ]  
}

```

**Sugestão payload de Saida:**

```json
GET /api/payment/payment_code
{
    "seller_code": "VEN001",
    "payment_code":"PAY001",
    "doc_payer":"00000000000",
    "status":"PAYED"
}

```

## Considerações Finais

Neste desafio, você será avaliado quanto à qualidade do código, a abstração utilizada na modelagem, a implementação dos testes unitários, a modelagem do banco de dados relacional e o uso correto do Spring Framework.


Boa sorte e mãos à obra!
