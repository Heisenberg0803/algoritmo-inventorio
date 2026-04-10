import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Model.ItemModel;

public class App {
    public static void main(String[] args) throws Exception {
      Scanner scanner = new Scanner(System.in);
      List<ItemModel> listaItens = new ArrayList<ItemModel>();
      
      System.out.println("Digite o numero de itens que serão criados");
      int iteracoes = scanner.nextInt() ;


      for(int i = 0; i < iteracoes; i++){
        ItemModel item = new ItemModel();
        listaItens.add(item);
        System.out.println(listaItens.get(i).getRaridade() + " id: " + listaItens.get(i).getValorSorteado());

      }
}
}