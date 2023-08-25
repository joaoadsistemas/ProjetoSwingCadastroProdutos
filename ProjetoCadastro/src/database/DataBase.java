package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.Produto;

public class DataBase {
	
	
	protected static final String DATABASE_URL = "jdbc:mysql://localhost:3306/products?user=root&password=B1234hj1%2326346";

	protected static void createTable(Connection connection) throws SQLException {
	    Statement statement = connection.createStatement();
	    
	    String createTableQuery = "CREATE TABLE IF NOT EXISTS Produtos (" +
	                              "id INT AUTO_INCREMENT PRIMARY KEY, " +
	                              "nomeProduto VARCHAR(255), " +
	                              "descProduto TEXT, " + 
	                              "valorProduto DOUBLE, " +
	                              "disponivel VARCHAR(10))";
	    
	    statement.executeUpdate(createTableQuery);
	    
	    System.out.println("Tabela criada com sucesso.");
	}

	protected static void insertProduct(Connection connection, String nome, String descricao, double valor, String disponivel) throws SQLException {
	    Statement statement = connection.createStatement();
	    String insertQuery = "INSERT INTO Produtos (nomeProduto, descProduto, valorProduto, disponivel) VALUES " +
	            "('" + nome + "', '" + descricao + "', " + valor + ", '" + disponivel + "')";
	    statement.executeUpdate(insertQuery);
	    System.out.println("Produto inserido com sucesso.");
	}

	
	protected static void readProducts(Connection connection, List<Produto> produtos) throws SQLException {
	    Statement statement = connection.createStatement();
	    String selectQuery = "SELECT * FROM Produtos";
	    ResultSet resultSet = statement.executeQuery(selectQuery);

	    while (resultSet.next()) {
	        int id = resultSet.getInt("id");
	        String nome = resultSet.getString("nomeProduto");
	        String descricao = resultSet.getString("descProduto");
	        double valor = resultSet.getDouble("valorProduto");
	        String disponivel = resultSet.getString("disponivel");
	        
	        Produto produto = new Produto();
	        produto.setId(id);
	        produto.setNomeProduto(nome);
	        produto.setDescProduto(descricao);
	        produto.setValorProduto(valor);
	        produto.setDisponivel(disponivel);
	        
	        produtos.add(produto);
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * protected static final String DATABASE_URL =
	 * "jdbc:sqlite:C:/Users/jones/OneDrive/Documentos/GitHub/Oak/OakDesafios/src/products.db\"";
	 * 
	 * 
	 * 
	 * protected static void createTable(Connection connection) throws SQLException
	 * { Statement statement = connection.createStatement();
	 * 
	 * String createTableQuery = "CREATE TABLE IF NOT EXISTS Produtos (" +
	 * "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "nomeProduto TEXT, " +
	 * "descProduto TEXT, " + "valorProduto REAL, " + "disponivel TEXT)";
	 * 
	 * statement.executeUpdate(createTableQuery);
	 * 
	 * System.out.println("Tabela criada com sucesso."); }
	 * 
	 * protected static void insertProduct(Connection connection, String nome,
	 * String descricao, double valor, String disponivel) throws SQLException {
	 * Statement statement = connection.createStatement(); String insertQuery =
	 * "INSERT INTO Produtos (nomeProduto, descProduto, valorProduto, disponivel) VALUES "
	 * + "('" + nome + "', '" + descricao + "', " + valor + ", '" + disponivel +
	 * "')"; statement.executeUpdate(insertQuery);
	 * System.out.println("Produto inserido com sucesso."); }
	 * 
	 * protected static void readProducts(Connection connection, List<Produto>
	 * produtos) throws SQLException { Statement statement =
	 * connection.createStatement(); String selectQuery = "SELECT * FROM Produtos";
	 * ResultSet resultSet = statement.executeQuery(selectQuery);
	 * 
	 * while (resultSet.next()) { int id = resultSet.getInt("id"); String nome =
	 * resultSet.getString("nomeProduto"); String descricao =
	 * resultSet.getString("descProduto"); double valor =
	 * resultSet.getDouble("valorProduto"); String disponivel =
	 * resultSet.getString("disponivel");
	 * 
	 * Produto produto = new Produto(); produto.setId(id);
	 * produto.setNomeProduto(nome); produto.setDescProduto(descricao);
	 * produto.setValorProduto(valor); produto.setDisponivel(disponivel);
	 * 
	 * produtos.add(produto); } }
	 */
	 

}
