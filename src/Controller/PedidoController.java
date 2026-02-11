package Controller;
import java.util.Scanner;

import Entities.ItemPedido;
import Entities.Pedido;
import Service.PedidoService;

public class PedidoController {
    private PedidoService pedidoService;
    private Scanner sc = new Scanner(System.in);

    public PedidoController(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }

    public void iniciar(){
        int opcao;

        do{
            System.out.println("\n=== MENU PEDIDOS ===");
            System.out.println("1 - Criar pedido");
            System.out.println("2 - Adicionar item");
            System.out.println("3 - Remover item");
            System.out.println("4 - Finalizar pedido");
            System.out.println("5 - Listar o pedido");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();

            switch (opcao){
                case 1: criarPedido();
                    break;
                case 2:adicionarItem();
                break;
                case 3:removerItem();
                break;
                case 4: finalizarPedido();
                break;
                case 5:listarPedido();
                break;
            }

        }
        while( opcao != 0);
    }

    private void criarPedido(){
        System.out.println("ID do cliente: ");
        Integer clienteId = sc.nextInt();

        Pedido pedido = pedidoService.criarPedido(clienteId);

        if(pedido == null){
            System.out.println("Erro ao criar pedido");
            return;
        }
        System.out.println("Pedido criado com Id: " + pedido.getId());

    }
    private void adicionarItem() {

        System.out.print("ID do pedido: ");
        Integer pedidoId = sc.nextInt();

        System.out.print("ID do produto: ");
        Integer produtoId = sc.nextInt();

        System.out.print("Quantidade: ");
        Integer quantidade = sc.nextInt();

        Pedido pedido = pedidoService.adicionarItemAoPedido(pedidoId, produtoId, quantidade);

        if (pedido == null) {
            System.out.println("Não foi possível adicionar o item ao pedido.");
            return;
        }

        System.out.println("Item adicionado com sucesso!");
    }

    private void removerItem() {

        System.out.print("ID do pedido: ");
        Integer pedidoId = sc.nextInt();

        System.out.print("ID do item: ");
        Integer itemId = sc.nextInt();

        Pedido pedido = pedidoService.removerItemdoPedido(pedidoId, itemId);

        if (pedido == null) {
            System.out.println("Não foi possível remover o item do pedido.");
            return;
        }

        System.out.println("Item removido com sucesso!");
    }

    private void finalizarPedido() {
        System.out.print("ID do pedido: ");
        Integer pedidoId = sc.nextInt();

        Pedido pedido = pedidoService.finalizarPedido(pedidoId);

        if (pedido == null) {
            System.out.println("Não foi possível finalizar o pedido.");
            return;
        }

        System.out.println("Pedido finalizado com sucesso!");
    }

    private void listarPedido() {

        System.out.print("ID do pedido: ");
        Integer pedidoId = sc.nextInt();

        Pedido pedido = pedidoService.buscarPedido(pedidoId);

        if (pedido == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        System.out.println("\n=== PEDIDO ===");
        System.out.println("ID: " + pedido.getId());
        System.out.println("Status: " + pedido.getStatus());
        System.out.println("Valor total: R$ " + pedido.getValorTotal());

        System.out.println("\n--- ITENS ---");

        if (pedido.getItens().isEmpty()) {
            System.out.println("Pedido sem itens.");
            return;
        }

        for (ItemPedido item : pedido.getItens()) {
            System.out.println(
                    "Item ID: " + item.getId() +
                            " | Produto: " + item.getNomeProduto() +
                            " | Qtd: " + item.getQuantidade() +
                            " | Preço: R$ " + item.getPrecoUnitario() +
                            " | Subtotal: R$ " + (item.getQuantidade() * item.getPrecoUnitario())
            );
        }
    }

}
