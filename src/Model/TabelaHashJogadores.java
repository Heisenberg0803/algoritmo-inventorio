package Model;

public class TabelaHashJogadores {
    private JogadorModel[] tabela;
    private int tamanho;
    private final double CONSTANTE_KNUTH = 0.6180339887; // Razão Áurea

    public TabelaHashJogadores(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new JogadorModel[tamanho];
    }

    // --- FUNÇÕES DE ESPALHAMENTO ---

    // 1. Método da Divisão
    private int hashDivisao(String chave) {
        int valorNumerico = Math.abs(chave.hashCode()); // Transforma texto em número
        return valorNumerico % tamanho;
    }

    // 2. Método da Multiplicação
    private int hashMultiplicacao(String chave) {
        int valorNumerico = Math.abs(chave.hashCode());
        double temp = valorNumerico * CONSTANTE_KNUTH;
        return (int) (tamanho * (temp - Math.floor(temp)));
    }

    // --- OPERAÇÕES DA TABELA ---

    public void inserir(JogadorModel j, String metodo) {
        int indice;
        if (metodo.equalsIgnoreCase("divisao")) {
            indice = hashDivisao(j.getNome());
        } else {
            indice = hashMultiplicacao(j.getNome());
        }

        // Exemplo simples: Tratamento de colisão por "Linear Probing" 
        // (se a vaga estiver ocupada, tenta a próxima)
        while (tabela[indice] != null) {
            System.out.println("Colisão no índice " + indice + "! Tentando próximo...");
            indice = (indice + 1) % tamanho;
        }
        
        tabela[indice] = j;
        System.out.println("Jogador " + j.getNome() + " inserido no índice " + indice);
    }

    public JogadorModel buscar(String nome, String metodo) {
        int indice = metodo.equalsIgnoreCase("divisao") ? hashDivisao(nome) : hashMultiplicacao(nome);
        
        // Busca linear a partir do índice (caso tenha havido colisão na inserção)
        int inicio = indice;
        while (tabela[indice] != null) {
            if (tabela[indice].getNome().equals(nome)) {
                return tabela[indice];
            }
            indice = (indice + 1) % tamanho;
            if (indice == inicio) break; // Deu a volta na tabela e não achou
        }
        return null;
    }
}