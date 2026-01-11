public class TestEsoda {
    private int foroi;
    private int daneia;
    private int loipa;
    private int synolikaesoda;

    public TestEsoda(int foroi, int daneia, int loipa, TestKratikoTameio tameio) {
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
