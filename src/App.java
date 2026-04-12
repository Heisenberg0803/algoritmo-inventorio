//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//import Model.ItemModel;
import Model.JogadorModel;
import Model.TabelaHashJogadores2;

public class App {
  public static void main(String[] args) throws Exception {
//      Scanner scanner = new Scanner(System.in);
//      List<ItemModel> listaItens = new ArrayList<ItemModel>();
//
//      System.out.println("Digite o numero de itens que serão criados");
//      int iteracoes = scanner.nextInt() ;
//
//
//      for(int i = 0; i < iteracoes; i++){
//        ItemModel item = new ItemModel();
//        listaItens.add(item);
//        System.out.println(listaItens.get(i).getRaridade() + " id: " + listaItens.get(i).getValorSorteado());
//
//      }
//}
//}




    // 1. Criamos a instância da sua Tabela Hash
    TabelaHashJogadores2 minhaTabela = new TabelaHashJogadores2();

    // 2. Definimos a expectativa de jogadores
    // Se colocar 5, a tabela terá tamanho 11 (primo após 5*2)
    minhaTabela.setNumJogadores(5);
    minhaTabela.definirTamanho();

    System.out.println("Tamanho real da tabela (primo): " + minhaTabela.getTabelaJogadores().length);
    System.out.println("--------------------------------------");

    // 3. Criamos alguns jogadores para testar
    JogadorModel j1 = new JogadorModel("gugu");
    JogadorModel j2 = new JogadorModel("gaga");
    JogadorModel j3 = new JogadorModel("gege");
    JogadorModel j4 = new JogadorModel("gigi");
    JogadorModel j5 = new JogadorModel("gogo");

    // 4. Testando a inserção com Sondagem Linear
    System.out.println("Inserindo com Sondagem Linear:");
    minhaTabela.inserir(j1, "quadratica");
    minhaTabela.inserir(j2, "quadratica");
    minhaTabela.inserir(j3, "quadratica");
    minhaTabela.inserir(j4, "quadratica");
    minhaTabela.inserir(j5, "quadratica");


    minhaTabela.imprimirTabela();
  }
}