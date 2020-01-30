# Terceiras
## Introdução
  Por vezes precisamos do suporte/chamado as empresas de prestação de serviço para que resolvam alguma questão relacionada ao fornecimento. 
  Como uma árvore que caiu na rede de energia elétrica, um hidrômetro que não está funcionando corretamente, uma solicitação de reestabelecimento 
  do fornecimento e por aí vai. Essas empresas costumam trabalhar com empresas terceirizadas para realizar esses serviços. Daí vem a ideia 
  desse projeto. O intuito é fornecer uma aplicação que permita o cliente relatar a empresa prestadora de serviço o problema que o aflinge.
  
  O cliente relata o problema, requisição é enviada para empresa e então a ordem de serviço é repassada para uma das terceirizadas. A partir
  daí a terceirizada encarregada do serviço vai atualizando o status do serviço e o cliente pode verificar esse status.

## Microservices
* netflix-eureka-naming-server
    >aplicação onde os micro-serviços são registrados. Utiliza Netflix Eeureka Discovery para isso.
* netflix-zuul-api-gateway-server
    >aplicação que recebe primeiro as requisições externas e então repassa para os outros microserviços.
* main-company-service
    >serviço que recebe as Ordens de Serviço, salva no banco e encaminha para a fila/mensageria.
* registro-os-service
    >serviço que fornece api para que as Ordens de Servico sejam criadas.
* central-terceiras-service
    >serviço que retira a Ordem de Serviço da fila e atribui uma terceirizada para realizar o serviço.
* terceiras-service
    >serviço que permite alterar informações a cerca da Ordem de Serviço(status, observação).
    
## Interfaces
* terceiras-user-client
    >aplicação que fornece interface para o Cliente logar, solicitar serviços e acompanhar o status.
* terceiras-terceira-client
    >aplicação que fornece interface para a Terceirizada logar, verificar serviços que lhe foram delegados e atualizar informações a respeito deles.

## Serviços e Portas

|Serviço|Porta|
|-------|-----|
|RabbitMQ|15672,5672|
|MySQL|3306|
|PostgreSQL|5432|
|naming-server|8761|
|zuul-api-gateway-server|8765|
|main-company-service|8080|
|registro-os-service|8181|
|central-terceiras-service|8383|
|terceiras-service|8484|
|terceiras-user-client|4300|
|terceiras-terceira-client|4200|

## URLs

|Aplicação|URL|
|-------|-----|
|RabbitMQ|http://localhost:15672/#/queues|
|Eureka Discovery|http://localhost:8761/|
|main-company-service|http://localhost:8080/swagger-ui.html#/|
|registro-os-service|http://localhost:8181/swagger-ui.html#/|
|central-terceiras-service|http://localhost:8383/swagger-ui.html#/|
|terceiras-service|http://localhost:8484/swagger-ui.html#/|
|Aplicação dos Clientes|http://localhost:4300|
|Aplicação das Terceirizadas|http://localhost:4200|

## Dados Pré-Definidos
Clientes:
```
[
  {
    "uc": 102,
    "endereco": {
      "rua": "Rua Tralalá",
      "bairro": "Centro",
      "numero": "1235",
      "cep": "75200000",
      "cidade": "Pires do Rio",
      "estado": "GO"
    },
    "cpf": "a123456789",
    "nome": "José João",
    "telefone": "6434613461",
    "email": "teste@gmail.com"
  },
  {
    "uc": 103,
    "endereco": {
      "rua": "Rua Migrantes",
      "bairro": "Jardins",
      "numero": "51",
      "cep": "75280000",
      "cidade": "Orizona",
      "estado": "GO"
    },
    "cpf": "b123456789",
    "nome": "Teldo Fungis",
    "telefone": "6434613474",
    "email": "teste2@gmail.com"
  }
]
```
Terceirizadas:
```
[
  {
    "cnpj": "y123456789",
    "razaoSocial": "EletriCity"
  },
  {
    "cnpj": "z123456789",
    "razaoSocial": "Charger"
  }
]
```
