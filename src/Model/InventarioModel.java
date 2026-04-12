//package Model;
//
//
//import java.util.Collections;
//import java.util.PriorityQueue;
//
//public class InventarioModel {
//
//    private PriorityQueue<ItemModel> heapItens;
//
//    public InventarioModel(){
//        this.heapItens = new PriorityQueue<>(Collections.reverseOrder());
//
//    }
//    // Adiciona um item ao inventário - O(log n)
//    public void adicionarItem(ItemModel item) {
//        heapItens.offer(item);
//    }
//
//    // Remove e retorna o item mais raro - O(log n)
//    public ItemModel removerMaisRaro() {
//        return heapItens.poll();
//    }
//
//    // Apenas olha o item mais raro sem remover - O(1)
//    public ItemModel espiarMaisRaro() {
//        return heapItens.peek();
//    }
//
//    public int totalItens() {
//        return heapItens.size();
//    }
//}
//
//private int hashDivisao(String chave) {
//    int valorNumerico = Math.abs(chave.hashCode()); // Transforma texto em número
//    return valorNumerico % tamanho;
//}
//
//
//
//
//
//
