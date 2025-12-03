import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
               Scanner input = new Scanner(System.in); //Δημιουργία αντικειμένου για εισαγωγή αριθμών
               
        // ΔΙΑΧΕΙΡΗΣΗ ΜΕΝΟΥ ΕΠΙΛΟΓΩΝ enum 
        System.out.println("διαλεξε μια απο τις παρακατω επιλογες");

        for (MenuOptions option : MenuOptions.values()) {
             System.out.println((option.ordinal() + 1) + "." + option.getDescription());
        }
        int  choice = input.nextInt();

        MenuOptions selectedOption = MenuOptions.values()[choice - 1];
        System.out.println("επελεξες" + selectedOption.getDescription());
        
        
        // ΠΡΟΘΥΠΟΥΡΓΟΣ-ΥΠΟΥΡΓΕΙΟ ΟΙΚΟΝΟΜΙΚΩΝ 
        
        if (choice == 1  ) { 
        System.out.println("ΔΙΑΛΕΞΕ ΜΙΑ ΑΠΟ ΤΙΣ ΠΑΡΑΚΑΤΩ ΕΠΙΛΟΓΕΣ ")

         for (MenuOptionsProthipourgos option : MenuOptionsProthipourgos.values()) {
              System.ou.println((option.ordinal() + 1) + "." + option.getDescriptionProthipourgos());
         }
         int choiceProthipourgou = input.nextInt();

         MenuOptionsProthipourgos selectedChoice = MenuOptionsProthipourgos.values()[choiceProthipourgou-1];
         System.outprin.ln("επελεξες" + "." + selectedChoice.getDescriptionProthipourgos());
         }
        // ΔΙΑΧΕΙΡΙΣΗ ΜΕΝΟΥ ΕΠΙΛΟΓΩΝ ΓΙΑ ΥΠΟΥΡΓΕΙΟ Παιδειας 
        
        if (choice == 2) {
             System.out.println("διαλεξε μια απο  τις παρακατω επιλογες");

            for (MenouOptionsforYpPaideias option : MenouOptionsforYpPaideias.values()) {
                 System.out.println((option.ordinal() + 1) + "." + option.getDescriptionPaideia());
            }
            int choice2 = input.nextInt();

            MenouOptionsforYpPaideias selectedOpt = MenouOptionsforYpPaideias.values()[choice2-1];
            System.out.println("επελεξες" + "." + selectedOpt.getDescriptionPaideia());
        }

        // ΔΙΑΧΕΙΡΙΣΗ ΜΕΝΟΥ ΕΠΙΛΟΓΩΝ ΓΙΑ ΥΠΟΥΡΓΕΙΟ ΥΓΕΙΑΣ 
        if (choice == 3) {
             System.out.println("διαλεξε μια απο  τις παρακατω επιλογες");

            for (MenouOPtionsforYpYgeias option : MenouOPtionsforYpYgeias.values()) {
                 System.out.println((option.ordinal() + 1) + "." + option.getDescriptionYgeias());
            }
            int choice3 = input.nextInt();

            MenouOPtionsforYpYgeias selectedOptygeias  = MenouOPtionsforYpYgeias.values()[choice3-1];
            System.out.println("επελεξες" + "." + selectedOptygeias.getDescriptionYgeias()); }
            
     // Αρχικό ποσό στο ταμείο
        
        System.out.print("Δώσε το αρχικό ποσό του κρατικού ταμείου από το προηγούμενο έτος: ");
        int arxikoPoso = input.nextInt();
        KratikoTameio tameio = new KratikoTameio(arxikoPoso);

        // Εισαγωγή εσόδων
        System.out.print("Δώσε προβλεπόμενα έσοδα από φόρους: ");
        int foroi = input.nextInt();
        System.out.print("Δώσε προβλεπόμενα έσοδα από δάνεια: ");
        int daneia = input.nextInt();
        System.out.print("Δώσε πρόβλεψη για λοιπά έσοδα: ");
        int loipaEsoda = input.nextInt();
        Esoda esoda = new Esoda(foroi, daneia, loipaEsoda, tameio);

        // Εισαγωγή εξόδων
        System.out.print("Δώσε προβλεπόμενα έξοδα για μισθούς: ");
        int misthoi = input.nextInt();
        System.out.print("Δώσε προβλεπόμενα έξοδα για συντάξεις: ");
        int syntakseis = input.nextInt();
        System.out.print("Δώσε πρόβλεψη για λοιπά έξοδα: ");
        int loipaExoda = input.nextInt();
        Exoda exoda = new Exoda(misthoi, syntakseis, loipaExoda);

        // Υπολογισμός διαφοράς με χρήση μεθόδων get άλλων κλάσεων
        int diafora = esoda.getAthroismaEsodon() - exoda.getAthroismaExodon();

        // Προσθήκη στο κρατικό ταμείο για να γίνει η πράξη στη κλάση KratikoTameio
        tameio.prosthikiStoTameio(diafora);

        // Εμφάνιση αποτελεσμάτων
        System.out.println("Άθροισμα προβλεπόμενων εσόδων" + esoda.getAthroismaEsodon());
        System.out.println("Άθροισμα προβλεπόμενων εξόδων: " + exoda.getAthroismaExodon());
        System.out.println("Διαφορά προβλεπόμενων εσόδων-εξόδων: " + diafora);
        System.out.println("Νέο ποσό στο κρατικό ταμείο: " + tameio.getTameio());

        input.close();
    }
}
