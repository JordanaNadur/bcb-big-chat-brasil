BCB - Big Chat Brasil
=====================

Sistema de envio de mensagens via web e mobile

**Requisitos**

* Java 21
* Spring Boot
* Spring JPA
* Spring Cloud
* Postgre
* Angular

**Passo a Passo para Execução do Sistema**

1. Crie um novo projeto Spring Boot com Spring JPA e Spring Cloud.
2. Configure o banco de dados Postgre.
3. Desenvolva a API RESTful para cadastro de clientes e envio de mensagens.
4. Desenvolva o frontend em Angular com autenticação simples por login.
5. Implemente a lógica de negócios para verificar o tipo de plano de pagamento e créditos do cliente.
6. Implemente as funcionalidades do backoffice.
7. Teste o sistema com a collection de testes fornecida abaixo.

**Collection de Testes**

* Cadastro de cliente:
    + Nome: João Silva
    + E-mail: joao.silva@example.com
    + Telefone: 11999999999
    + CPF responsável: 12345678909
    + CNPJ: 12345678901234
    + Nome empresa: Empresa XYZ
* Envio de mensagem:
    + Número telefone: 11999999999
    + Flag WhatsApp: true
    + Texto: Olá, como você está?
* Verificação de créditos:
    + Cliente pre-pago com 10 créditos
    + Envio de mensagem com custo
