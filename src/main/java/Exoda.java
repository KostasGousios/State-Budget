public class Exoda {
    private int misthoi;
    private int syntakseis;
    private int loipa_exoda;
    private int exodagiaypourgeia;

    public Exoda(int misthoi, int syntakseis, int loipa_exoda, int exodagiaypourgeia) {
        this.misthoi = misthoi;
        this.syntakseis = syntakseis;
        this.loipa_exoda = loipa_exoda;
        this.exodagiaypourgeia = exodagiaypourgeia;
    }

    public int getAthroismaExodon() {
        return misthoi + syntakseis + loipa_exoda + exodagiaypourgeia;
    }
}
