
package Model;

public class InventarioModel {

    private ItemModel[] invetario;
    private int tamanhoInventario;

    public InventarioModel(ItemModel[] item) {
        this.invetario = item;
        this.tamanhoInventario = item.length;
        buildHeap();
    }

    public ItemModel[] getInvetario() {
        return invetario;
    }

    public void setInvetario(ItemModel[] invetario) {
        this.invetario = invetario;
    }

    public int getTamanhoInventario() {
        return tamanhoInventario;
    }

    public void setTamanhoInventario(int tamanhoInventario) {
        this.tamanhoInventario = tamanhoInventario;
    }

    void buildHeap() {
        
        for (int i = this.tamanhoInventario / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    void heapify(int root_index) {
        int max_index = root_index;
        int child = root_index * 2 + 1;

        
        if (child < tamanhoInventario) {
            if (invetario[child].getRaridade().getPeso() > invetario[max_index].getRaridade().getPeso()) {
                max_index = child;
            }
        }

        
        if (child + 1 < tamanhoInventario) {
            if (invetario[child + 1].getRaridade().getPeso() > invetario[max_index].getRaridade().getPeso()) {
                max_index = child + 1;
            }
        }

        if (max_index != root_index) {
            swap(invetario, root_index, max_index);
            heapify(max_index);
        }
    }

    void swap(ItemModel[] arr, int a, int b) {
        ItemModel temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public ItemModel extractRoot() {
        if (tamanhoInventario <= 0) return null;
        
        ItemModel max = invetario[0];
        invetario[0] = invetario[--tamanhoInventario];
        heapify(0);

        return max;
    }

    public int getSize() {
        return tamanhoInventario;
    }
}


    
class HeapSort {
    public static void main(String args[]) {
   // 1. Criando uma lista de itens (simulando drops)
        // O LCG interno do ItemModel cuidará de sortear a raridade de cada um
        ItemModel[] dropsDoMundo = {
            new ItemModel("Espada de Ferro"),
            new ItemModel("Escudo Quebrado"),
            new ItemModel("Adaga das Sombras"),
            new ItemModel("Poção de Cura"),
            new ItemModel("Anel Lendário de Artorias"),
            new ItemModel("Armadura de Pano"),
            new ItemModel("Cajado Arcano"),
            new ItemModel("Sopa"),
            new ItemModel("coco"),
            new ItemModel("aleatorio"),
            new ItemModel("Pitufo vivo")
        };

        System.out.println("=== Itens Dropados (Ordem Aleatória) ===");
        for (ItemModel item : dropsDoMundo) {
            System.out.println("- " + item.getNome() + " | Raridade: " + item.getRaridade());
        }

        System.out.println("\n--- Organizando Inventário (Build Heap) ---\n");

        // 2. Inicializando o Inventário com a nossa Heap
        // A buildHeap() será chamada automaticamente no construtor
        InventarioModel inventario = new InventarioModel(dropsDoMundo);

        // 3. Extraindo os itens (Eles sairão do mais raro para o mais comum)
        System.out.println("=== Itens Extraídos por Prioridade (Mais Raros Primeiro) ===");
        while (inventario.getSize() > 0) {
            ItemModel itemExtraido = inventario.extractRoot();
            System.out.println("Saindo do Inventário: " + itemExtraido.getNome() + 
                               " [" + itemExtraido.getRaridade() + "]");
        }
    }
    }

