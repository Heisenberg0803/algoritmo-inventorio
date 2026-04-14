package Model;

public class GeradorXorshift {
    private Long semente;

    public GeradorXorshift(long sementeInicial) {
       
        if (sementeInicial == 0) {
            this.semente = (Long) System.currentTimeMillis();
        } else {
            this.semente = sementeInicial;
        }
    }

    public int proximoInt(int limite) {
        
        long x = this.semente;
        x ^= (x << 13);
        x ^= (x >>> 17);
        x ^= (x << 5);
        this.semente = x;

    
        int resultado = (int) (x & Integer.MAX_VALUE); 
        return resultado % limite;
    }

    public long getSementeAtual() {
        return this.semente;
    }
}