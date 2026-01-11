public class TestKratikoTameio {
        private int tameio;

    public TestKratikoTameio(int arxikoPoso) {
        this.tameio = arxikoPoso;
    }

    public void prosthikiStoTameio(int poso) {
        tameio += poso;
    }

    public int getTameio() {
        return tameio;
    }
}
