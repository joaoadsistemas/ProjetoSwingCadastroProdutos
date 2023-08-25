package controller;

import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoController {
	
	
	 private List<Produto> produtos = new ArrayList<>();
	
	
	public void criarProduto(String nomeProduto, String descProduto, double valorProduto, String disponivel) {
		
		Produto produto = new Produto();
		
		produto.setNomeProduto(nomeProduto);
		produto.setDescProduto(descProduto);
		produto.setDisponivel(disponivel);
		produto.setValorProduto(valorProduto);
		
		produtos.add(produto);
		
	}
	
	public List<Produto> getProdutos() {
        return produtos;
    }

}
