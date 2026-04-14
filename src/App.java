import Model.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TabelaHashJogadores tabelaHash = new TabelaHashJogadores();
        Runtime runtime = Runtime.getRuntime();

        // 1. GERAÇÃO AUTOMATIZADA DE JOGADORES (Para facilitar testes de escala)
        System.out.print("Quantidade de jogadores para criar: ");
        int qtdJogadores = scanner.nextInt();
        scanner.nextLine();

        long t0 = System.nanoTime();
        long m0 = runtime.totalMemory() - runtime.freeMemory();

        tabelaHash.setNumJogadores(qtdJogadores);
        tabelaHash.definirTamanho();


        System.out.println("Digite o método Hash que deseja usar (linear/quadratica): ");
        String metodoEscolhido = scanner.nextLine();

        for (int i = 0; i < qtdJogadores; i++) {
            // Criando jogadores com nomes Jogador_0, Jogador_1...
            JogadorModel novo = new JogadorModel("Jogador_" + i);
            tabelaHash.inserir(novo, metodoEscolhido);
        }

        long t1 = System.nanoTime();
        long m1 = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("\n[MÉTRICA HASH] Criação de " + qtdJogadores + " jogadores:");
        System.out.println("Tempo: " + (t1 - t0) + " ns | Memória: " + (m1 - m0) / 1024 + " KB");

        // 2. GERAÇÃO DA POOL DE ITENS
       System.out.print("\nQuantidade de itens totais no mundo: ");
        int qtdItensGlobal = scanner.nextInt();

        // 1. Captura o estado inicial (Tempo e Memória)
        long t3 = System.nanoTime();
        long m3 = runtime.totalMemory() - runtime.freeMemory();

        // 2. Executa a lógica de criação
        ItemModel[] poolGlobal = new ItemModel[qtdItensGlobal];
        for (int i = 0; i < qtdItensGlobal; i++) {
            poolGlobal[i] = new ItemModel("Item_" + i);
        }

        // 3. Captura o estado final
        long t4 = System.nanoTime();
        long m4 = runtime.totalMemory() - runtime.freeMemory();

        // 4. Exibe os resultados
        System.out.println("\n[MÉTRICA POOL] Criação de " + qtdItensGlobal + " itens:");
        System.out.println("Tempo: " + (t4 - t3) + " ns | Memória: " + (m4 - m3) / 1024 + " KB");

        // 3. MENU INTERATIVO (Permite múltiplas ações)
        boolean rodando = true;
        while (rodando) {
            System.out.println("\n----------- MENU -----------");
            System.out.println("1. Alocar itens para um jogador");
            System.out.println("2. Buscar jogador e Ver Inventário (Heap)");
            System.out.println("3. Imprimir Tabela Hash completa");
            System.out.println("4. Sair");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: // ALOCAÇÃO DE ITENS (Mede HEAP)
                    System.out.print("Digite o nome do jogador (ex: Jogador_0): ");
                    String nomeAlvo = scanner.nextLine();
                    JogadorModel jDestino = tabelaHash.buscarJogador(nomeAlvo, metodoEscolhido);

                    if (jDestino != null) {
                        System.out.print("Quantos itens da pool deseja entregar? (Máx " + qtdItensGlobal + "): ");
                        int qtd = scanner.nextInt();
                        if (qtd <= qtdItensGlobal) {
                            
                            long tIniHeap = System.nanoTime();
                            long mIniHeap = runtime.totalMemory() - runtime.freeMemory();

                            ItemModel[] itensJogador = new ItemModel[qtd];
                            System.arraycopy(poolGlobal, 0, itensJogador, 0, qtd);
                            
                            // O construtor abaixo executa o BuildHeap
                            jDestino.setInventario(new InventarioModel(itensJogador));

                            long tFimHeap = System.nanoTime();
                            long mFimHeap = runtime.totalMemory() - runtime.freeMemory();
                            
                            System.out.println(">> [MÉTRICA HEAP] Itens alocados e organizados!");
                            System.out.println("Tempo BuildHeap: " + (tFimHeap - tIniHeap) + " ns | Memória: " + (mFimHeap - mIniHeap) / 1024 + " KB");
                        }
                    } else {
                        System.out.println("Jogador não encontrado.");
                    }
                    break;

                case 2: // BUSCA E EXIBIÇÃO (Mede BUSCA HASH)
                    System.out.print("Nome do jogador para buscar: ");
                    String nomeBusca = scanner.nextLine();

                    long tIniBusca = System.nanoTime();
                    JogadorModel alvo = tabelaHash.buscarJogador(nomeBusca, metodoEscolhido); // Chama sua função original

                    long tFimBusca = System.nanoTime();

                    if (alvo != null) {
                        System.out.println("\nInventário de " + alvo.getNome() + " (Ordem de Raridade):");
                        if (alvo.getInventario() != null) {
                            // Clonamos ou acessamos o inventário para extrair
                            InventarioModel inv = alvo.getInventario();
                            int tamanhoOriginal = inv.getSize();
                            
                            // Extraindo da Heap para mostrar a prioridade
                            for (int k = 0; k < tamanhoOriginal; k++) {
                                ItemModel item = inv.extractRoot();
                                System.out.println(" - " + item.getNome() + " | Raridade: " + item.getRaridade());
                            }
                            System.out.println("(Nota: Inventário foi extraído/esvaziado para exibição)");
                        } else {
                            System.out.println("[ Inventário Vazio ]");
                        }
                    }
                    System.out.println("\n>> [MÉTRICA BUSCA] Tempo na Hash: " + (tFimBusca - tIniBusca) + " ns");
                    break;

                case 3:
                    tabelaHash.imprimirTabela();
                    break;

                case 4:
                    rodando = false;
                    break;
            }
        }
    }


}
