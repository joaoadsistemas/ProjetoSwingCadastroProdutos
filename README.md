# ProjetoSwingCadastroProdutos

# Projeto de Cadastro de Itens 🛍️

Este projeto consiste em um sistema simples de cadastro de produtos, onde é possível adicionar informações sobre produtos, como nome, descrição, valor e disponibilidade para venda. Os dados são armazenados em um banco de dados MySQL e podem ser listados posteriormente.

## 🚀 Funcionalidades

- Cadastro de novos produtos, incluindo nome, descrição, valor e disponibilidade.
- Listagem de produtos cadastrados.

## 🛠️ Pré-requisitos

- Java 8 ou superior
- Biblioteca de driver JDBC do MySQL (mysql-connector-java)
- MySQL Server instalado e em execução

## 🔧 Configuração

1. Clone este repositório para o seu ambiente de desenvolvimento.
2. Certifique-se de que a biblioteca de driver JDBC do MySQL (mysql-connector-java) esteja incluída nas dependências do projeto.
3. Configure as informações de conexão com o banco de dados no código, no arquivo `ProdutoController.java`, na constante `DATABASE_URL`. Substitua as informações de usuário, senha e nome do banco de dados de acordo com o seu ambiente.

## 📖 Como Usar

1. Compile e execute a classe `viewCadastro.java` para abrir a interface de cadastro de produtos.
2. Preencha os campos necessários (nome, descrição, valor, disponibilidade) e clique em "Cadastrar".
3. Os produtos cadastrados serão armazenados no banco de dados.
4. Para listar os produtos cadastrados, execute a classe `viewListarProdutos.java`. Ela exibirá uma tabela com os produtos cadastrados.
5. Você pode adicionar novos produtos clicando no botão "Novo Cadastro".
6. Para finalizar o programa, clique em "Finalizar" nas telas de cadastro ou listagem.

## 📝 Observações

- Este projeto é um exemplo didático e simplificado, não contemplando todos os aspectos de segurança e boas práticas recomendadas para aplicações em produção.
- As informações de autenticação do banco de dados estão presentes no código apenas para fins de demonstração. Em um ambiente de produção, considere utilizar variáveis de ambiente ou outros mecanismos seguros para gerenciar essas informações.

## 📜 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
