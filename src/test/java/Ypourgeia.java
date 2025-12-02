
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Ypourgeia {
    protected String onoma;
    protected static final Scanner s = new Scanner(System.in);
    protected Map<String, Double> logariasmoi = new HashMap<>(); //κενος πινακας με λογαριασμους και ποσα
     protected Map<String, Double> posostaKatanomis = new HashMap<>(); //κενο πινακας με τα ποσοστα κατανομης που θα δωσει ο χρηστης
    public Ypourgeia(String onoma) {
        this.onoma = onoma;
        orismosLogariasmwn();
        eisagwgiPosostwn();
    }
    public String getOnoma() {
        return onoma;
    }
    // Α) μεθοδος που ζηταει προυπολογισμο υπουργειου (1η επιλογη για τα υπουργεια στη main)
    public double eisagwgiProipologismou() {
        System.out.println("Δώσε τον προϋπολογισμό σου: ");
        return s.nextDouble();
    }
    // Β) μεθοδοι για 2η επιλογη για τα υπουργεια στη main 
    private void eisagwgiPosostwn() {
        System.out.println("Δώσε ποσοστό για:" + onoma);
        double sum = 0;
        for (String log : logariasmoi.keySet()) { //επαναλαμβανεται για οσα κλειδια εχει ο Map
            System.out.print("Δώσε ποσοστό για" + log + "(σε %):");
            double pososto = s.nextDouble();
            posostaKatanomis.put(log, pososto / 100.0);
            sum += pososto;
        }
        if (Math.abs(sum - 100) > 0.01) {
            throw new IllegalArgumentException(
                "Υπάρχει σφάλμα!: Τα ποσοστά που έχουν εισαχθεί δεν αθροίζουν στο 100%! Άθροισμα = " + sum + "%");
        }
    }
    //μεθοδος που ζηταει απο πρωθυπουργο τον προυπολογισμο καθε υπουργειου
    public void katanomiProypApoProthypoyrgo() { 
        System.out.println("\n Πόσα χρήματα θα δώσετε στο " + onoma + ";");
        double poso = s.nextDouble();
         for (String log : logariasmoi.keySet()) { //επαναληψη για καθε λογαριασμο του υπουργειου μεσω του πινακα Map 
            double katholikoPoso = poso * posostaKatanomis.get(log); // ποσο που τελικα παιρνει ο καθε λογαριασμος του καθε υπουργειου
            logariasmoi.put(log, logariasmoi.get(log) + katholikoPoso);
        }
        // εμφανιση αποτελεσματων
        for (String log : logariasmoi.keySet()) {
            System.out.println(log + ": " + logariasmoi.get(log) + "€"); 
        } // εμφανιζουμε για καθε υπουργειο το ονομα λογαριασμου και το υπολοιπο του σε ευρω
    }
    public abstract void orismosLogariasmwn(); 
    //καθε υπουργειο δηλωνει μονο τι λογαριασμους διαχειριζεται 
}
