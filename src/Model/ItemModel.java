package Model;

import java.util.Scanner;

public class ItemModel{
    Scanner scanner = new Scanner(System.in);

    private String nome;
    private Raridade raridade;
    private int valorSorteado;
    private static GeradorLCG geradorLCG = new GeradorLCG(465842168522L);
    private static GeradorXorshift geradorXorshift = new GeradorXorshift(465842168522L);



    public ItemModel(){
        this.valorSorteado =  geradorXorshift.proximoInt(200);
        this.raridade = AtribuirRaridade();
  
    }
    public ItemModel(String nome) {
        this.nome = nome;
        this.valorSorteado =  geradorXorshift.proximoInt(200);
        this.raridade = AtribuirRaridade();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Raridade getRaridade() {
        return raridade;
    }
    public void setRaridade(Raridade raridade) {
        this.raridade = raridade;
    }

    public int GerarRaridade() {
        return geradorLCG.proximoInt(200);
    }

    public int getValorSorteado() { return valorSorteado; }

    
    public Raridade AtribuirRaridade(){
        int sorteio = valorSorteado;

        if(sorteio <= 140){
            return raridade.COMUM;
        }else if(sorteio > 140 && sorteio < 184){
            return raridade.RARA;
        }else if(sorteio >= 184 && sorteio <=198){
            return raridade.EPICA;
        }else{
            return raridade.LENDARIA;
        }
    
    }
    
    
}
