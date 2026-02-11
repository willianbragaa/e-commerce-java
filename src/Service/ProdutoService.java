package Service;

import Entities.Produto;
import Repository.ProdutoRepository;

import java.util.List;

public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public ProdutoService (ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public Produto criarProduto(String nome, Double preco, Integer estoque) {
        Produto produto = new Produto();
        produto.setName(nome);
        produto.setPrice(preco);
        produto.setEstoque(estoque);

        return produtoRepository.criar(produto);
    }

    public List<Produto> listarProdutos (){
        return produtoRepository.listar();
    }

    public Produto acharPorId (Integer id){
        return produtoRepository.procurarPeloId(id);
    }

    public Produto atualizarProduto (Produto produto){
        return produtoRepository.atualizar(produto);
    }

    public boolean removerProduto (Integer id)
    {
        return produtoRepository.delete(id);
    }

    public boolean diminuirEstoque (Integer id, Integer quantity){
        Produto produto = produtoRepository.procurarPeloId(id);
        if(produto == null){
            return false;
        }

        if (produto.getEstoque() < quantity) {
            return false;
        }

        produto.setEstoque(produto.getEstoque() - quantity);
        produtoRepository.atualizar(produto);
        return true;
    }

    public boolean aumentarEstoque(Integer id, Integer quantity){
        Produto produto = produtoRepository.procurarPeloId(id);
        if(produto == null){
            return false;
        }

        if (quantity < 0){
            return false;
        }

        produto.setEstoque(produto.getEstoque() + quantity);
        produtoRepository.atualizar(produto);
        return true;
    }

}
