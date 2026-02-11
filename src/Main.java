import Controller.PedidoController;
import Controller.ProdutoController;
import Entities.Produto;
import Repository.PedidoRepository;
import Repository.ProdutoRepository;
import Service.PedidoService;
import Service.ProdutoService;
import java.util.Scanner;

public class Main{
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PedidoRepository pedidoRepository = new PedidoRepository();
    ProdutoRepository produtoRepository = new ProdutoRepository();

    ProdutoService produtoService = new ProdutoService(produtoRepository);
    PedidoService pedidoService = new PedidoService(pedidoRepository,produtoService);

    PedidoController controller = new PedidoController(pedidoService);
    ProdutoController produtoController = new ProdutoController(produtoService);




    System.out.println("----MENU PRINCIPAL----");
    int opcao;

    do{
        System.out.println("----1.Administrar produtos----");
        System.out.println("----2.Pedidos----");
        System.out.println("----0.Sair----");

        opcao = sc.nextInt();

        switch (opcao){
            case 1: produtoController.iniciar();
            break;
            case 2:controller.iniciar();
            break;
            case 3: System.out.println("Encerrando o programa....");
            default: System.out.println("Opção inválida ");
            break;

        }

    }
    while(opcao != 0);



}

         }