package Model;

import java.util.Scanner;

public class ItemModel{
    Scanner scanner = new Scanner(System.in);

    private String nome;
    private String raridade;
    private int valorSorteado;
    private long seed = scanner.nextLong();
    private static GeradorLCG geradorLCG = new GeradorLCG();

    public ItemModel(){
        this.valorSorteado =  geradorLCG.proximoInt(200, seed);
        this.raridade = AtribuirRaridade();
  
    }
    public ItemModel(String nome) {
        this.nome = nome;
        this.valorSorteado =  geradorLCG.proximoInt(200,seed);
        this.raridade = AtribuirRaridade();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getRaridade() {
        return raridade;
    }
    public void setRaridade(String raridade) {
        this.raridade = raridade;
    }

    public int GerarRaridade() {
        return geradorLCG.proximoInt(200,seed);
    }

    public int getValorSorteado() { return valorSorteado; }

    public String AtribuirRaridade(){
        int sorteio = valorSorteado;

        if(sorteio <= 140){
            return "COMUM";
        }else if(sorteio > 140 && sorteio < 184){
            return "RARA";
        }else if(sorteio > 184 && sorteio <=198){
            return "ÉPICA";
        }else{
            return "LENDARIA";
        }
    
    }
    
    
}
