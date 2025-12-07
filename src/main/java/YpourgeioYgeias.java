public class YpourgeioYgeias extends Ypourgeia {
    private YpourgeioYgeias() {
        super("Υπουργείο Υγείας");
    }
    @Override
    public void orismosLogariasmwn() {
        logariasmoi.put("Νοσοκομεία", 0.0);
        logariasmoi.put("Κέντρα Υγείας", 0.0);
        logariasmoi.put("Φάρμακα & Υλικό", 0.0);
    }
    public static YpourgeioYgeias objygeias  = new YpourgeioYgeias();
    // Διαχειριση επιλογων υπουργειου υγειας 
    public static ygeia(int x) {
    if (x==1) {
        Main.isYpourgeiaPrepared = true; //για exception σε enum προθυπουργου    
        YpourgeioYgeias.objygeias.eisagwgiProipologismou();        
    } else if (x == 2) {
        objygeias.eisagwgiPosostwn();
    }
}
}
