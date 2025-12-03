public class Esoda {
    private int foroi;
    private int daneia;
    private int loipa_esoda;
    private int synolikaesoda;

    public Esoda(int foroi, int daneia, int loipa_esoda, KratikoTameio tameio) {
        this.foroi = foroi;
        this.daneia = daneia;
        this.loipa_esoda = loipa_esoda;
        synolikaesoda = foroi + daneia + loipa_esoda;
        if (tameio.getTameio() > 0) {
            synolikaesoda += tameio.getTameio();
        }
    }
    public int getSynolikaEsoda() {
        return synolikaesoda;
        
    }

    public int getAthroismaEsodon() {
        return foroi + daneia + loipa_esoda;
    }
}
