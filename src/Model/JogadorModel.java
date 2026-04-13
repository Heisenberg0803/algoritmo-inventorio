package Model;

public class JogadorModel {
    private String nome;
    private InventarioModel inventario;

    public void setInventario(InventarioModel inventario) {
        this.inventario = inventario;
    }

    public JogadorModel(String nome) {
        this.nome = nome;
        this.inventario = inventario;
    }

    public String getNome() { return nome; }
    public InventarioModel getInventario() { return inventario; }
}