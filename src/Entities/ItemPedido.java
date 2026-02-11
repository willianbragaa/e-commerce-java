package Entities;

import java.math.BigDecimal;

public class ItemPedido {
    private static int contador = 1;
    private Integer id;
    private Integer produtoId;
    private String nomeProduto;
    private Integer quantidade;
    private Double precoUnitario;
    private Double subTotal;



    public ItemPedido(){}

    public ItemPedido(Integer produtoId, String nomeProduto, Integer quantidade, Double precoUnitario) {
        this.id = contador++;
        this.produtoId = produtoId;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        calcularSubTotal();
    }

    public Integer getProdutoId() {return produtoId;}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public void calcularSubTotal(){
        if(quantidade > 0){
             this.subTotal = precoUnitario * quantidade;
        }

    }
}

