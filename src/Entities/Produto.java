package Entities;

import java.math.BigDecimal;

public class Produto {
    private Integer id;
    private String name;
    private Double price;
    private Integer estoque;
    private String categoria;

    public Produto(){}

    public Produto(Integer id, String name, Double price, Integer estoque, String categoria) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", estoque=" + estoque +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
