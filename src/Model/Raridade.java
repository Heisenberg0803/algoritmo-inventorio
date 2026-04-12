package Model;

public enum Raridade {
    COMUM(1), 
    RARA(2), 
    EPICA(3), 
    LENDARIA(4);

    private final int peso;

    Raridade(int peso) {
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }
}