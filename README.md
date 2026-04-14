# Sistema de Inventário de Jogadores - Estrutura de Dados II

**Integrantes:**
* Gustavo Kêm Fukuda
* Rafael Nogueira

## 1. Descrição do Projeto
Este projeto implementa um sistema de gerenciamento de inventário de jogadores utilizando estruturas de dados clássicas implementadas manualmente, sem o uso de bibliotecas prontas do Java (como `HashMap` ou `PriorityQueue`), conforme os requisitos da disciplina. 

O sistema integra:
* **Tabela Hash:** Para armazenamento e busca rápida de jogadores pelo Nick.
* **Heap (Max-Heap):** Para organizar o inventário de cada jogador por raridade de itens.
* **Geradores de Números Aleatórios:** Implementações manuais (LCG e XorShift) para criação de drops de itens e testes de estresse.

## 2. Estrutura de Arquivos

### Pacote `Model`
* **`JogadorModel.java`**: Representa o jogador e contém seu inventário próprio.
* **`ItemModel.java`**: Define o item, sua raridade e o valor sorteado pelo gerador.
* **`InventarioModel.java`**: Implementação manual de um **Max-Heap** para organizar itens por peso de raridade.
* **`TabelaHashJogadores.java`**: Implementação da Tabela Hash com suporte a **Sondagem Linear** e **Sondagem Quadrática**.
* **`GeradorLCG.java`**: Gerador Congruencial Linear para números aleatórios.
* **`GeradorXorShift.java`**: Segundo método de geração aleatória (XorShift).
* **`Raridade.java`**: Enum que define os pesos das raridades (Comum, Rara, Épica, Lendária).

### Pacote `Main` / Raiz
* **`App.java`**: Ponto de entrada do programa que permite configurar a `seed`, o tamanho da entrada e o método de colisão.
* **`GeradorGraficos.java`** (opcional): Script ou classe utilizada para exportar as métricas de tempo e colisões.

## 3. Como Executar

### Pré-requisitos
* Java JDK 17 ou superior.
* Terminal ou IDE (VS Code, IntelliJ, Eclipse).

### Passo a Passo
1. No terminal, navegue até a pasta raiz do projeto.
2. Compile os arquivos:
   ```bash
   javac Model/*.java App.java