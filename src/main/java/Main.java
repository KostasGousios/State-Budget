import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.SQLException;
public class Main {
     
    public static boolean isYpourgeiaPrepared = false;
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
     try {
        Database.getConnection();  // Δημιουργεί τη βάση
        System.out.println("Επιτυχής δημιουργία βάσης δεδομένων");
     } catch (SQLException e) {
        System.out.println("Σφάλμα: " + e.getMessage());
     }
     
     
           // ΔΙΑΧΕΙΡΗΣΗ ΜΕΝΟΥ ΕΠΙΛΟΓΩΝ enum 
        
        System.out.println("διαλεξε μια απο τις παρακατω επιλογες");

        for (MenuOptions option : MenuOptions.values()) {
             System.out.println((option.ordinal() + 1) + "." + option.getDescription());
        }
        int  choice = readSafeInt();

        MenuOptions selectedOption = MenuOptions.values()[choice - 1];
        System.out.println("επελεξες" + selectedOption.getDescription());
        
        
        // ΠΡΟΘΥΠΟΥΡΓΟΣ-ΥΠΟΥΡΓΕΙΟ ΟΙΚΟΝΟΜΙΚΩΝ 
        
        if (choice == 1  ) { 
         System.out.println("ΔΙΑΛΕΞΕ ΜΙΑ ΑΠΟ ΤΙΣ ΠΑΡΑΚΑΤΩ ΕΠΙΛΟΓΕΣ ");

         for (MenuOptionsProthipourgos option : MenuOptionsProthipourgos.values()) {
              System.out.println((option.ordinal() + 1) + "." + option.getDescriptionProthipourgos());
         }
         int choiceProthipourgou = readSafeInt();

         MenuOptionsProthipourgos selectedChoice = MenuOptionsProthipourgos.values()[choiceProthipourgou-1];
         System.out.println("επελεξες" + "." + selectedChoice.getDescriptionProthipourgos());
        
         // διαχειριση επιλογων προθυπουργου 
         EisagwgiPoswn obj1 = new EisagwgiPoswn();
     try {

          if (choiceProthipourgou == 1 ) {
              obj1.provlepomena();
       }  else if (choiceProthipourgou == 2) {
           // εξαιρεση - δεν μπορει ο προθυπουργοσ να πατησει 2 αν τα υπουργεια δεν πατησουν 1
            if (isYpourgeiaPrepared == false) {
              throw new IllegalStateException("Δεν μπορείς να επιλέξεις 2 πριν γίνει η επιλογή 1 στα Υπουργεία!");
            } 
            YpourgeioPaideias.objpaideias.katanomiProypApoProthypoyrgo(); // προθυπουργοσ βλεπει τι ζητησε το καθε υπουργειο
            YpourgeioYgeias.objygeias.katanomiProypApoProthypoyrgo();  // και δινει τα ποσα που θελει 
     
       }  else if (choiceProthipourgou == 3) {
          System.out.println("--- Εισαγωγή Πραγματικών Εσόδων/Εξόδων ---");
          obj1.pragmatika(); 
          System.out.println("Η ενημέρωση των πραγματικών ποσών ολοκληρώθηκε.");
       }  else if (choiceProthipourgou == 4) {
          System.out.println("Πραγματικά, προβλεπόμενα και είδος προυπολογισμού στο τέλος του έτους");
          obj1.telika();
       }
     } catch (IllegalStateException e) {
          System.out.println("ΣΦΑΛΜΑ: " + e.getMessage());
          System.out.println("Παρακαλώ ακολουθήστε τη σωστή σειρά των ενεργειών.");
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
          }
     }
}
       
       
       
       
       
            

       
