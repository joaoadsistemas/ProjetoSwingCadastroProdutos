package model;

public class Produto {
	
	
	private String nomeProduto;
	private String descProduto;
	private double valorProduto;
	private String disponivel;
	
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getDescProduto() {
		return descProduto;
	}
	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}
	public double getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}
	public String isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(String disponivel) {
		this.disponivel = disponivel;
	}
	
	
	

}
