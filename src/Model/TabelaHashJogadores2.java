package Model;

import Model.JogadorModel;
import java.util.List;
import java.math.BigInteger;

public class TabelaHashJogadores2 {


    private JogadorModel[] tabelaJogadores;

    public JogadorModel[] getTabelaJogadores() {
        return tabelaJogadores;
    }

    public void setTabelaJogadores(JogadorModel[] tabelaJogadores) {
        this.tabelaJogadores = tabelaJogadores;
    }



    private int numJogadores;

    public int getNumJogadores() {
        return numJogadores;
    }

    public void setNumJogadores(int numJogadores) {
        this.numJogadores = numJogadores;
    }



    public void definirTamanho(){
        int conta = numJogadores * 2;
        BigInteger num = BigInteger.valueOf(conta);
        int tabela = num.nextProbablePrime().intValue();
        this.tabelaJogadores = new JogadorModel[tabela];

    }


    private int SondagemLinear(String chave, int tamanho) {
        int indice = 0;
        int soma = 0;
        do{
            int valorNumerico = Math.abs(chave.hashCode()); // Transforma texto em número
            soma = (valorNumerico + indice) % tamanho;
            indice++;
        }while(tabelaJogadores[soma]!=null);
        return soma;

    }

    private int quadraticProbing(String chave, int tamanho) {
        int indice = 0;
        int soma = 0;
        do{
            int valorNumerico = Math.abs(chave.hashCode());
            soma = ((valorNumerico % tamanho)+ (indice * indice)) % tamanho;
            indice++;
        }while(tabelaJogadores[soma]!=null);
        return soma;
    }

    public void inserir(JogadorModel jogador, String metodo) {
        String chave = jogador.getNome();
        int tamanho = tabelaJogadores.length; //para não ficar preso no paradoxo da função definirTamanho usar o .length é pq o numJogadores será passado na main quando for puxado
        int indiceFinal;

        if (metodo.equalsIgnoreCase("linear")) {
            indiceFinal = SondagemLinear(chave, tamanho);
        } else if (metodo.equalsIgnoreCase("quadratica")) {
            indiceFinal = quadraticProbing(chave, tamanho);
        } else {
            indiceFinal = SondagemLinear(chave, tamanho);
        }


        tabelaJogadores[indiceFinal] = jogador;

        System.out.println("Jogador " + chave + " inserido com sucesso no índice: " + indiceFinal);
    }

    public void imprimirTabela() {
        System.out.println("\n========== TABELA HASH DE JOGADORES ==========");
        System.out.printf("%-10s | %-20s\n", "ÍNDICE", "JOGADOR");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < tabelaJogadores.length; i++) {
            if (tabelaJogadores[i] != null) {
                // Imprime o índice e o nome do jogador
                System.out.printf("[%02d]  | %-20s\n", i, tabelaJogadores[i].getNome());
            } else {
                // Imprime que o slot está vazio para facilitar a visualização
                System.out.printf("[%02d]  | %-20s\n", i, "[ VAZIO ]");
            }
        }
        System.out.println("==============================================\n");
    }






}
