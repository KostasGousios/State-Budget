import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.SQLException;
public class Main {
     
    public static boolean isPaideiaReady = false; 
    public static boolean isYgeiaReady = false;
    static Scanner input = new Scanner(System.in); //Δημιουργία αντικειμένου για εισαγωγή αριθμών

// μεθοδοι για να ελεγχουμε οτι ο χρηστησ πληκτρολογει σωστου τυπου δεδομενα 
    public static int readSafeInt() {
        while (true) {
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("ΣΦΑΛΜΑ: Πρέπει να δώσετε ακέραιο αριθμό!");
                System.out.print("Προσπαθήστε ξανά: ");
                input.nextLine(); // Καθαρισμός του Scanner από το "λάθος" input
            }
        }
    }
    
    // Αν χρειάζεσαι και για δεκαδικούς
    public static double readSafeDouble() {
        while (true) {
            try {
                return input.nextDouble();
            } catch (InputMismatchException e) {
                System.err.println("ΣΦΑΛΜΑ: Πρέπει να δώσετε αριθμό (π.χ. 1000,50)!");
                System.out.print("Προσπαθήστε ξανά: ");
                input.nextLine();
            }
        }
    }
    public static void main(String[] args) {
        EisagwgiPoswn obj1 = new EisagwgiPoswn();
        try {
        Database.getConnection();  // Δημιουργεί τη βάση
        System.out.println("Επιτυχής δημιουργία βάσης δεδομένων");
        } catch (SQLException e) {
        System.out.println("Σφάλμα: " + e.getMessage());
        }
     
     
           // ΔΙΑΧΕΙΡΗΣΗ ΜΕΝΟΥ ΕΠΙΛΟΓΩΝ enum 
        while(true) {
            System.out.println("ΚΕΝΤΡΙΚΟ ΜΕΝΟΥ ΕΠΙΛΟΓΩΝ. Διάλεξε ένα από τα παρακάτω");

            for (MenuOptions option : MenuOptions.values()) {
             System.out.println((option.ordinal() + 1) + "." + option.getDescription());
            }
            System.out.println("0. Έξοδος από την εφαρμογή");
            int  choice = readSafeInt();
            if (choice == 0) break;
            if (choice < 1 || choice > MenuOptions.values().length) {
                System.out.println("Λάθος επιλογή! Προσπαθήστε ξανά.");
                continue;
            } //Ελεγχος για να μην κρασαρει το enum αν μπουν τιμες εκτος οριων
            MenuOptions selectedOption = MenuOptions.values()[choice - 1];
            System.out.println("επελεξες" + selectedOption.getDescription());
        
        
            // ΠΡΟΘΥΠΟΥΡΓΟΣ-ΥΠΟΥΡΓΕΙΟ ΟΙΚΟΝΟΜΙΚΩΝ 
            try {
                if (choice == 1  ) { 
                    System.out.println("ΔΙΑΛΕΞΕ ΜΙΑ ΑΠΟ ΤΙΣ ΠΑΡΑΚΑΤΩ ΕΠΙΛΟΓΕΣ ");

                    for (MenuOptionsProthipourgos option : MenuOptionsProthipourgos.values()) {
                    System.out.println((option.ordinal() + 1) + "." + option.getDescriptionProthipourgos());
                    }
                    int choiceProthipourgou = readSafeInt();

                    MenuOptionsProthipourgos selectedChoice = MenuOptionsProthipourgos.values()[choiceProthipourgou-1];
                    System.out.println("επελεξες" + "." + selectedChoice.getDescriptionProthipourgos());
            
                    // διαχειριση επιλογων προθυπουργου
                    if (choiceProthipourgou == 1 ) {
                        obj1.provlepomena();
                    } else if (choiceProthipourgou == 2) {
                    // εξαιρεση - δεν μπορει ο προθυπουργοσ να πατησει 2 αν τα υπουργεια δεν πατησουν 1
                        if (!isPaideiaReady || !isYgeiaReady) {
                            throw new IllegalStateException("Δεν μπορείς να επιλέξεις 2 πριν δώσουν ποσά και τα ΔΥΟ Υπουργεία!"); //
                        } 
                    YpourgeioPaideias.objpaideias.katanomiProypApoProthypoyrgo(); // προθυπουργοσ βλεπει τι ζητησε το καθε υπουργειο
                    YpourgeioYgeias.objygeias.katanomiProypApoProthypoyrgo();  // και δινει τα ποσα που θελει 
        
                    } else if (choiceProthipourgou == 3) {
                        System.out.println("--- Εισαγωγή Πραγματικών Εσόδων/Εξόδων ---");
                        obj1.pragmatika(); 
                        System.out.println("Η ενημέρωση των πραγματικών ποσών ολοκληρώθηκε.");
                    } else if (choiceProthipourgou == 4) {
                        System.out.println("Πραγματικά, προβλεπόμενα και είδος προυπολογισμού στο τέλος του έτους");
                        obj1.telika();
                    } else if (choiceProthipourgou == 5) {
                        System.out.print("Σε περιπτωση πανδημιας το Υπ.Υγειας εχει μεγαλυτερο budget για να διαχειριστει την κριση");
                        senarioPandimia();
                    } else if (choiceProthipourgou == 6) {
                        System.out.println("Σε περίπτωση φυσικής καταστροφής η κυβέρνηση λαμβάνει περισσότερα λεφτά από τα αποθεματικά για καλύτερη διαχείριση");
                        FysikiKatastrofi.diacheirisi(obj1.tameio, obj1);
                    }
                }
        

        
                // ΔΙΑΧΕΙΡΙΣΗ ΜΕΝΟΥ ΕΠΙΛΟΓΩΝ ΓΙΑ ΥΠΟΥΡΓΕΙΟ Παιδειας 
                if (choice == 2) {
                    System.out.println("διαλεξε μια απο  τις παρακατω επιλογες");

                    for (MenouOptionsforYpPaideias option : MenouOptionsforYpPaideias.values()) {
                    System.out.println((option.ordinal() + 1) + "." + option.getDescriptionPaideia());
                }
                int choice2 = readSafeInt();

                MenouOptionsforYpPaideias selectedOpt = MenouOptionsforYpPaideias.values()[choice2-1];
                System.out.println("επελεξες" + "." + selectedOpt.getDescriptionPaideia());
            
                YpourgeioPaideias.objpaideias.paideia(choice2);
                if (choice2 == 1) isPaideiaReady = true; //ενημεσωρη σημαιας υπουργειου παιδειας
                }
            
            
                // ΔΙΑΧΕΙΡΙΣΗ ΜΕΝΟΥ ΕΠΙΛΟΓΩΝ ΓΙΑ ΥΠΟΥΡΓΕΙΟ ΥΓΕΙΑΣ 
                if (choice == 3) {
                    System.out.println("διαλεξε μια απο  τις παρακατω επιλογες");

                    for (MenouOPtionsforYpYgeias option : MenouOPtionsforYpYgeias.values()) {
                        System.out.println((option.ordinal() + 1) + "." + option.getDescriptionYgeias());
                    }
                    int choice3 = readSafeInt();

                    MenouOPtionsforYpYgeias selectedOptygeias  = MenouOPtionsforYpYgeias.values()[choice3-1];
                    System.out.println("επελεξες" + "." + selectedOptygeias.getDescriptionYgeias()); 
                    YpourgeioYgeias.objygeias.ygeia(choice3); //καλω την static μεθοδο που διαχειριζεται τισ επιλογες του Υπουργειου υγειας
                    if (choice3 == 1) isYgeiaReady = true; //ενημερωση σημαιας υπουργειου υγειας
                }
            } catch (IllegalStateException e) {
                // *** ΔΙΟΡΘΩΣΗ: Εμφάνιση σφάλματος και επιστροφή στο loop ***
                System.out.println("\n[ΠΡΟΣΟΧΗ]: " + e.getMessage());
                System.out.println("Επιστροφή στο κεντρικό μενού...");
            }
        }
        System.out.println("Το πρόγραμμα τερματίστηκε.");


        //ΜΕΘΟΔΟΣ ΓΙΑ ΣΕΝΑΡΙΟ ΠΑΝΔΗΜΙΑΣ 
        public static void senarioPandimia() {
        System.out.println("--- ΕΝΕΡΓΟΠΟΙΗΣΗ ΣΕΝΑΡΙΟΥ ΠΑΝΔΗΜΙΑΣ ---");
    
        // Υπολογιζω του 50% του τρέχοντος ποσού της Παιδείας
        double posoMetaphoras = YpourgeioPaideias.objpaideias.proipologismosDedomena * 0.5;
    
        // Αφαίρεση από την Παιδεία
        YpourgeioPaideias.objpaideias.proipologismosDedomena -= posoMetaphoras;
    
        // Προσθήκη στην Υγεία
        YpourgeioYgeias.objygeias.proipologismosDedomena += posoMetaphoras;
    
        System.out.println("Μεταφέρθηκαν " + posoMetaphoras + "€ από το Υπ. Παιδείας στο Υπ. Υγείας.");

        // Πρέπει να μηδενίσουμε τους λογαριασμούς και να ξαναμοιράσουμε
        YpourgeioPaideias.objpaideias.orismosLogariasmwn(); // Μηδενισμός
        YpourgeioPaideias.objpaideias.katanomiEsoterika(); // Νέο μοίρασμα
    
        YpourgeioYgeias.objygeias.orismosLogariasmwn(); // Μηδενισμός
        YpourgeioYgeias.objygeias.katanomiEsoterika(); // Νέο μοίρασμα
        }
    }
}
    
       
       
       
       
            

       
