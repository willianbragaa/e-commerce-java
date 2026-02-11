package Entities;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    public enum Status{
        Criado,
        Pago,
        Pendente

    }

    private Integer id;
    private Integer clienteId;
    private List<ItemPedido> itens;
    double valorTotal;
    Status status;

    public Pedido(List<ItemPedido> itens) {
        itens = new ArrayList<>();
    }

    public Pedido(Integer clienteId){
        this.clienteId = clienteId;
        this.itens = new ArrayList<>();
        calcularValorTotal();

    }

    public Pedido(Integer id, Integer clienteId, double valorTotal, List<ItemPedido> itens, Status status) {
        this.id = id;
        this.clienteId = clienteId;
        this.valorTotal = valorTotal;
        this.itens = new ArrayList<>();
        calcularValorTotal();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void calcularValorTotal(){
        this.valorTotal = 0.0;
        for(ItemPedido item : itens){
           this.valorTotal += item.getSubTotal();
        }
    }

    public void adicionarItemPedido(ItemPedido item){
        itens.add(item);
        calcularValorTotal();
    }

    public void removerItemPedido(Integer itemId){
        itens.removeIf(item -> item.getId() == itemId);
        calcularValorTotal();

    }

}
