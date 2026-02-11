package Service;

import Entities.ItemPedido;
import Entities.Pedido;
import Entities.Produto;
import Repository.PedidoRepository;

public class PedidoService {
    PedidoRepository pedidoRepository;
    ProdutoService produtoService;

    public PedidoService(PedidoRepository pedidoRepository, ProdutoService produtoService){
        this.pedidoRepository = pedidoRepository;
        this.produtoService = produtoService;
    }

    public Pedido criarPedido(Integer clienteId){
        Pedido pedido = new Pedido(clienteId);
        pedido.setStatus(Pedido.Status.Criado);
        return pedidoRepository.criar(pedido);
    }

    public Pedido adicionarItemAoPedido(Integer pedidoId, Integer produtoId, Integer quantidade){
        Pedido pedido = pedidoRepository.buscarPeloId(pedidoId);
        if( pedido == null){
            return null;
        }

        Produto produto = produtoService.acharPorId(produtoId);
        if(produto == null){
            return null;
        }

        produtoService.diminuirEstoque(produtoId, quantidade);

        ItemPedido item = new ItemPedido(produto.getId(),produto.getName(), quantidade, produto.getPrice());
        pedido.adicionarItemPedido(item);

        pedido.calcularValorTotal();

        pedidoRepository.atualizar(pedido);

        return pedido;
    }

    public Pedido removerItemdoPedido(Integer pedidoId, Integer itemId){
        Pedido pedido = pedidoRepository.buscarPeloId(pedidoId);

        if (pedido == null){
            return null;
        }

        ItemPedido itemParaRemover = pedido.getItens().stream().filter(x -> x.getId().equals(itemId)).findFirst().orElse(null);

        if(itemParaRemover == null){
            return null;
        }

        produtoService.aumentarEstoque(itemParaRemover.getId(), itemParaRemover.getQuantidade());

        pedido.removerItemPedido(itemId);

        pedido.calcularValorTotal();

        pedidoRepository.atualizar(pedido);
        return pedido;

    }

    public Pedido finalizarPedido(Integer pedidoId){
        Pedido pedido = pedidoRepository.buscarPeloId(pedidoId);

        if(pedido == null){
            return null;
        }

        if(pedido.getStatus() != Pedido.Status.Criado){
            return null;
        }

        pedido.setStatus(Pedido.Status.Pago);

        pedidoRepository.atualizar(pedido);

        return pedido;
    }

    public Pedido buscarPedido(Integer pedidoId) {
        return pedidoRepository.buscarPeloId(pedidoId);
    }
}
