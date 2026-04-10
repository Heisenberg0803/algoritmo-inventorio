package Model;
public class GeradorLCG {
    private long semente;
   
    private static final long A = 1664525L;
    private static final long C = 1013904223L;
    private static final long M = (long) Math.pow(2, 32);

    public GeradorLCG(long sementeInicial) {
        this.semente = sementeInicial;
    }

    public int proximoInt(int limite) {
        semente = (A * semente + C) % M;
        
        return (int) ((semente >>> 0) % limite); 
    }


    public long getSementeAtual() {
        return this.semente;
    }
}