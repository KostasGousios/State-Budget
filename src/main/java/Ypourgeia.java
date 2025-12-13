
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
    }
    public String getOnoma() {
        return onoma;
    }
    protected double zitoumeno;
    // Α) μεθοδος που ζηταει προυπολογισμο υπουργειου (1η επιλογη για τα υπουργεια στη main)
    public double eisagwgiProipologismou() {
        System.out.println("Δώστε τον πρϋπολογισμό σας: ");
         return this.zitoumeno = s.nextDouble();
    }
    // Β) μεθοδοι για 2η επιλογη για τα υπουργεια στη main 
    public void eisagwgiPosostwn() {
        System.out.println("Το ποσο που σας δόθηκε από τον πρωθυπουργό είναι :" + this.proipologismosDedomena);
        double sum = 0;
        for (String log : logariasmoi.keySet()) { //επαναλαμβανεται για οσα κλειδια εχει ο Map
            System.out.print("Δώστε ποσοστό για" + log + "(σε %):");
            double pososto = s.nextDouble();
            posostaKatanomis.put(log, pososto / 100.0);
            sum += pososto;
        }
        if (Math.abs(sum - 100) > 0.01) {
            throw new IllegalArgumentException(
                "Υπάρχει σφάλμα!: Τα ποσοστά που έχουν εισαχθεί δεν αθροίζουν στο 100%! Άθροισμα = " + sum + "%");
        }
        if (this.proipologismosDedomena > 0) {
        katanomiEsoterika();
        } else {
        System.out.println("\nΣημείωση: Δεν έχει εισαχθεί ακόμα προϋπολογισμός από τον Πρωθυπουργό. Η κατανομή θα γίνει αργότερα.");
        }
    }
    
    protected double proipologismosDedomena = 0.0;
    //μεθοδος στην οποια  πρωθυπουργος πραγματοποιει την δευτερη επιλογη του   
    public void katanomiProypApoProthypoyrgo() { 
        System.out.println("Το υπουργείο " + onoma + "έχει ζητήσει" + zitoumeno + "€" );
        System.out.println("\n Πόσα χρήματα θα δώσετε στο " + onoma + ";");
        double poso = s.nextDouble();
        this.proipologismosDedomena = poso; 
        
        System.out.println("Δόθηκαν " + poso + "€ στο " + onoma + ".");
       }
    public abstract void orismosLogariasmwn(); 
    

    protected void katanomiEsoterika() {
       System.out.println("\n--- ΕΣΩΤΕΡΙΚΗ ΚΑΤΑΝΟΜΗ ΠΡΟΫΠΟΛΟΓΙΣΜΟΥ ---");
       double diathesimoPoso = this.proipologismosDedomena;

    // Επανάληψη για κάθε λογαριασμό χρησιμοποιώντας τα αποθηκευμένα ποσοστά
       for (String log : logariasmoi.keySet()) {
           double posostoKatanomis = posostaKatanomis.get(log);
        
        // Υπολογισμός του ποσού που παίρνει ο λογαριασμός
           double katholikoPoso = diathesimoPoso * posostoKatanomis; 
        
        // Προσθήκη του ποσού στον λογαριασμό
           logariasmoi.put(log, logariasmoi.get(log) + katholikoPoso);
       }
    
    // Εμφάνιση αποτελεσμάτων
       System.out.println("Εσωτερική κατανομή για το " + onoma + "(Συνολικό Ποσό: " + diathesimoPoso + "€):");
       for (String log : logariasmoi.keySet()) {
            System.out.println("-> " + log + ": " + logariasmoi.get(log) + "€");
       }
    }
}



 

       

    
   
    
    
    
    
    
    
    
