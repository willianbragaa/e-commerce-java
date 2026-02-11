package Repository;

import Entities.Pedido;
import jdk.jshell.Snippet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoRepository {
    private List<Pedido> pedidos;
    private Integer proximoId;

    public PedidoRepository() {
        pedidos = new ArrayList<>();
        proximoId = 1;
    }

    public Pedido criar(Pedido pedido) {
        pedido.setId(proximoId);
        pedidos.add(pedido);
        proximoId++;
        return pedido;

    }

    public List<Pedido> listar() {
        return Collections.unmodifiableList(pedidos);
    }

    public Pedido buscarPeloId (Integer id){
        Pedido pedido = pedidos.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
        return pedido;
    }

    public Pedido atualizar (Pedido pedido){
        Pedido pedidoExistente = buscarPeloId(pedido.getId());
        if (pedidoExistente != null){
            pedidoExistente.setStatus(pedido.getStatus());
            pedidoExistente.setItens(pedido.getItens());
            return pedidoExistente;
        }
        return null;
    }

    public boolean remover (Integer id){
       return pedidos.removeIf(pedido -> pedido.getId().equals(id));
    }

    public List <Pedido> buscarPeloClienteId (Integer id){
        List<Pedido> pedidosDoCliente = new ArrayList<>();
        for(Pedido pedido : pedidos){
            if(pedido.getClienteId().equals(id)){
                pedidosDoCliente.add(pedido);

            }
        }
        return pedidosDoCliente;
    }

    public List <Pedido> buscarPeloStatus (Pedido.Status status){

        return pedidos.stream().filter(pedido -> pedido.getStatus().equals(status)).collect(Collectors.toList());
        }
    }








