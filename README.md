# 📚 Projeto de Pesquisa em Banco de Dados: Exemplo com PostgreSQL

Este é um projeto que encontrei na internet e alterei para servir de exemplo para demonstrar como realizar operações básicas de banco de dados usando o PostgreSQL. Ele inclui a criação de tabelas, inserção de dados e consultas para visualizar os dados armazenados.

#### 🔧 Tecnologias Utilizadas

- Java
- PostgreSQL
- JDBC (Java Database Connectivity)
  
#### 🚀 Executando o Projeto

Certifique-se de ter o Java e o PostgreSQL instalados em sua máquina.
Faça o download ou clone o repositório deste projeto.
Importe o projeto em sua IDE favorita.
Configure as informações de conexão com o banco de dados PostgreSQL no arquivo DatabaseConnection.java (URL, usuário e senha).
Execute a classe Main.java para criar a tabela, inserir dados e visualizar os resultados.

#### 📋 Funcionalidades Principais

- createTable(): Cria a tabela "tabela_exemplo" no banco de dados, se ela ainda não existir.
- insertData(): Insere registros na tabela "tabela_exemplo" com valores exclusivos para o campo "id".
- main(): Executa a criação da tabela, a inserção de dados e exibe o número de registros e os dados armazenados na tabela.

#### 💡 Observações

- Se a tabela "tabela_exemplo" já existir no banco de dados, o programa irá considerá-la e não criará uma nova.
- Durante a inserção de dados, o programa obtém o próximo valor exclusivo para o campo "id" antes de inserir um novo registro.
- Certifique-se de fornecer as informações corretas de conexão com o banco de dados (URL, usuário e senha) no arquivo DatabaseConnection.java para estabelecer a conexão corretamente.
