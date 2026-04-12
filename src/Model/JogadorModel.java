package Model;

public class JogadorModel {
    private String nome;
//    private InventarioModel inventario;

    public JogadorModel(String nome) {
        this.nome = nome;
//        this.inventario = new InventarioModel();
    }

    public String getNome() { return nome; }
//    public InventarioModel getInventario() { return inventario; }
}