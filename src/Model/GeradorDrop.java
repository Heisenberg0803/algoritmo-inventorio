package Model;

import java.util.Random;

public class GeradorDrop {
    private static final Random random = new Random();

    // Nomes base para os itens (para deixar o teste visualmente interessante)
    private static final String[] nomesItens = {"Espada", "Escudo", "Poção", "Anel", "Adaga", "Cajado"};

    /**
     * Gera um item aleatório baseado em probabilidades (pesos)
     */
    public static ItemModel gerarItem() {
        int chance = random.nextInt(100) + 1; // Gera de 1 a 100
        int raridadeSorteada;
        String prefixo;

        // --- SISTEMA DE PESOS (PROBABILIDADE ACUMULADA) ---
        if (chance <= 60) {          // 60% de chance (1 a 60)
            raridadeSorteada = 1;
            prefixo = "Comum";
        } else if (chance <= 85) {   // 25% de chance (61 a 85)
            raridadeSorteada = 2;
            prefixo = "Raro";
        } else if (chance <= 95) {   // 10% de chance (86 a 95)
            raridadeSorteada = 3;
            prefixo = "Épico";
        } else {                     // 5% de chance (96 a 100)
            raridadeSorteada = 4;
            prefixo = "Lendário";
        }

        // Sorteia um nome aleatório da lista
        String nomeBase = nomesItens[random.nextInt(nomesItens.length)];
        String nomeFinal = prefixo + " " + nomeBase;

        return new ItemModel(nomeFinal, raridadeSorteada);
    }
}