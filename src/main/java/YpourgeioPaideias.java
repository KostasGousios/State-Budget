public class YpourgeioPaideias extends Ypourgeia {
    public YpourgeioPaideias() {
        super("Υπουργείο Παιδείας");
    }
    @Override
    public void orismosLogariasmwn() {
        logariasmoi.put("Πρωτοβάθμια Εκπαίδευση", 0.0);
        logariasmoi.put("Δευτεροβάθμια Εκπαίδευση", 0.0);
        logariasmoi.put("Ανώτατα Ιδρύματα", 0.0);
    }
    public static YpourgeioPaideias objpaideias = new YpourgeioPaideias();
    public static paideia(int x) {
        if (x == 1) {
            YpourgeioPaideias obj = new YpourgeioPaideias();
            obj.eisagwgiProipologismou();
           Main.isYpourgeiaPrepared = true; // για exception σε enum προθυπουργου 
     }  else if (x==2) {
            

     }  else {

     }
        
    }
}  
