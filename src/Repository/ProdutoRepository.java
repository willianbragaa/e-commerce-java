package Repository;

import Entities.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {

    private List<Produto> produtos;
    private Integer proximoId;

    public ProdutoRepository() {
        produtos = new ArrayList<>();
        proximoId = 1;
    }

    public Produto criar(Produto produto){
        produto.setId(proximoId);
        produtos.add(produto);
        proximoId++;
        return produto;
    }

    public List <Produto>listar() {
        return produtos;
    }

    public Produto procurarPeloId(Integer id){

        Produto produto = produtos.stream().filter( x -> x.getId().equals(id)).findFirst().orElse(null);
        return produto;

    }

    public Produto atualizar(Produto produto){
        Produto produtoExistente = procurarPeloId(produto.getId());
        if(produtoExistente != null){
            produtoExistente.setName(produto.getName());
            produtoExistente.setPrice(produto.getPrice());
            produtoExistente.setEstoque(produto.getEstoque());
            produtoExistente.setCategoria(produto.getCategoria());
            return produtoExistente;
        }
        return null;
    }

    public boolean delete(Integer id){
        return produtos.removeIf(produto -> produto.getId().equals(id));

    }


}
