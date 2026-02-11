package Controller;

import Service.ProdutoService;
import Entities.Produto;

import java.util.List;
import java.util.Scanner;

public class ProdutoController {

    private final ProdutoService produtoService;
    private final Scanner scanner = new Scanner(System.in);

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public void iniciar() {
        int opcao;

        do {
            System.out.println("\n=== MENU PRODUTOS ===");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar produto por ID");
            System.out.println("0 - Voltar");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> cadastrarProduto();
                case 2 -> listarProdutos();
                case 3 -> buscarProduto();
            }

        } while (opcao != 0);
    }

    private void cadastrarProduto() {

        System.out.print("Nome do produto: ");
        scanner.nextLine(); // limpa buffer
        String nome = scanner.nextLine();

        System.out.print("Preço: ");
        Double preco = scanner.nextDouble();

        System.out.print("Estoque inicial: ");
        Integer estoque = scanner.nextInt();

        Produto produto = produtoService.criarProduto(nome, preco, estoque);

        if (produto == null) {
            System.out.println("Erro ao cadastrar produto.");
            return;
        }

        System.out.println("Produto cadastrado com ID: " + produto.getId());
    }

    private void listarProdutos() {

        List<Produto> produtos = produtoService.listarProdutos();

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        System.out.println("\n=== PRODUTOS ===");
        for (Produto p : produtos) {
            System.out.println(
                    "ID: " + p.getId() +
                            " | Nome: " + p.getName() +
                            " | Preço: R$ " + p.getPrice() +
                            " | Estoque: " + p.getEstoque()
            );
        }
    }

    private void buscarProduto() {

        System.out.print("ID do produto: ");
        Integer id = scanner.nextInt();

        Produto produto = produtoService.acharPorId(id);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        System.out.println(
                "ID: " + produto.getId() +
                        " | Nome: " + produto.getName() +
                        " | Preço: R$ " + produto.getPrice() +
                        " | Estoque: " + produto.getEstoque()
        );
    }
}



