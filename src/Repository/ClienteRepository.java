package Repository;

import Entities.Cliente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClienteRepository {
    private List<Cliente> clientes;
    private Integer proximoId;

    public ClienteRepository(){
        clientes = new ArrayList<>();
        proximoId = 1;
    }

    public Cliente criar(Cliente cliente){
        cliente.setId(proximoId);
        clientes.add(cliente);
        proximoId++;
        return cliente;
    }

// Essa função retorna a lista somente para leitura.

    public List<Cliente> listar(){
        return Collections.unmodifiableList(clientes);
    }

    public Cliente procurarPeloId(Integer id){
        Cliente cliente = clientes.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
        return cliente;
    }

    public Cliente atualizar(Cliente cliente){
        Cliente clienteExistente = procurarPeloId(cliente.getId());
        if(clienteExistente != null){
            clienteExistente.setName(cliente.getName());
            clienteExistente.setEmail(cliente.getEmail());
            return clienteExistente;
        }
        return null;
    }

    public boolean remover (Integer id){
        return clientes.removeIf(cliente -> cliente.getId().equals(id));
    }

}
