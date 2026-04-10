import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import Model.GeradorDrop;
import Model.GeradorLCG;
import Model.ItemModel;
import Model.JogadorModel;
import Model.TabelaHashJogadores;

public class App {
    public static void main(String[] args) throws Exception {

      List<ItemModel> listaItens = new ArrayList<ItemModel>();
      
      int iteracoes = 20;

      for(int i = 0; i<iteracoes; i++){
        ItemModel item = new ItemModel();
        listaItens.add(item);
        System.out.println(listaItens.get(i).getRaridade() + " id: " + listaItens.get(i).getValorSorteado());
      }
}
}