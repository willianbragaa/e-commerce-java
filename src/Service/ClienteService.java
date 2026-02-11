package Service;

import Entities.Cliente;
import Repository.ClienteRepository;

import java.util.List;

public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public Cliente criarCliente (Cliente cliente){
        return clienteRepository.criar(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.listar();
    }

    public Cliente procurarPeloId(Integer id){
        return clienteRepository.procurarPeloId(id);
    }

    public Cliente atualizarCliente(Cliente cliente){
        return clienteRepository.atualizar(cliente);
    }


    public boolean removerCliente(Integer id){
        return clienteRepository.remover(id);
    }





}
