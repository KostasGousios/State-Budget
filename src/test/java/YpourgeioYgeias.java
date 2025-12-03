public class YpourgeioYgeias extends Ypourgeia {
    public YpourgeioYgeias() {
        super("Υπουργείο Υγείας");
    }
    @Override
    public void orismosLogariasmwn() {
        logariasmoi.put("Νοσοκομεία", 0.0);
        logariasmoi.put("Κέντρα Υγείας", 0.0);
        logariasmoi.put("Φάρμακα & Υλικό", 0.0);
    }
}
