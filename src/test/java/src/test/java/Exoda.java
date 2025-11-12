package src.test.java;
public class Exoda {
    private int misthoi;
    private int syntakseis;
    private int loipa;

    public Exoda(int misthoi, int syntakseis, int loipa) {
        this.misthoi = misthoi;
        this.syntakseis = syntakseis;
        this.loipa = loipa;
    }

    public int getAthroismaExodon() {
        return misthoi + syntakseis + loipa;
    }
}
