public class Esoda {
    private int foroi;
    private int daneia;
    private int loipa;

    public Esoda(int foroi, int daneia, int loipa) {
        this.foroi = foroi;
        this.daneia = daneia;
        this.loipa = loipa;
    }

    public int getAthroismaEsodon() {
        return foroi + daneia + loipa;
    }
}
