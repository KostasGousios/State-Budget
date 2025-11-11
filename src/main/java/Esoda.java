public class Esoda {
    private int foroi;
    private int daneia;
    private int loipa;
    private int synolikaesoda;

    public Esoda(int foroi, int daneia, int loipa, KratikoTameio tameio) {
        this.foroi = foroi;
        this.daneia = daneia;
        this.loipa = loipa;
        synolikaesoda = foroi + daneia + loipa;
        if (tameio.getTameio() > 0) {
            synolikaesoda += tameio.getTameio();
        }
    }
    public int getSynolikaEsoda() {
        return synolikaesoda;
        
    }

    public int getAthroismaEsodon() {
        return foroi + daneia + loipa;
    }
}
