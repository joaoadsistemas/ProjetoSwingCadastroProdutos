package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DataBase;
import model.Produto;

public class ProdutoController extends DataBase {
	
	public ProdutoController() {
		
		try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
	        createTable(connection); // Chama a função para criar a tabela
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void criarProduto(String nomeProduto, String descProduto, double valorProduto, String disponivel) {
		
		 try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
		        insertProduct(connection, nomeProduto, descProduto, valorProduto, disponivel);
		        System.out.println("Produto inserido com sucesso.");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		
	}
	
	public List<Produto> getProdutos() {
	    List<Produto> produtos = new ArrayList<>();
	    try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
	        readProducts(connection, produtos);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return produtos;
	}

}
