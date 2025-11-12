package src.test.java;
public class KratikoTameio {
    private int tameio;

    public KratikoTameio(int arxikoPoso) {
        this.tameio = arxikoPoso;
    }

    public void prosthikiStoTameio(int poso) {
        tameio += poso;
    }

    public int getTameio() {
        return tameio;
    }
}
