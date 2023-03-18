# Gerenciador de Empresas

## Pré-requisitos
- JDK 17
- Postman

## Iniciar o Projeto
Para iniciar o projeto, abra o projeto no seu terminal e cole 

> $ javac GerenciadorDeEmpresasApplication.java
> 
> $ java GerenciadorDeEmpresasApplication
> 
### Caminhos para requisições
- Cadastrar Funcionário:
  - Método POST 
  - http://localhost:8080/funcionario/cadastro


- Listar todos Funcionários
  - Método GET
  - http://localhost:8080/funcionario/busca
  

- Buscar Funcionário
  - Método GET
  - http://localhost:8080/funcionario/busca/231
  - Troque o "231" pelo registro do funcionário ( Registros já cadastrados 231 / 2310)
  
- Gerar Extrato
  - Método GET
  - http://localhost:8080/funcionario/extrato/bruto
  - Troque "bruto" por "liquido", para mudar as respostas
  - Ou então gere os dois resultados usando a url:
  - http://localhost:8080/funcionario/extrato