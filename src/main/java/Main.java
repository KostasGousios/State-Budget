import java.util.Scanner;
public class Main {
    public static boolean isYpourgeiaPrepared = false;
    
    
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
         System.out.println("ΔΙΑΛΕΞΕ ΜΙΑ ΑΠΟ ΤΙΣ ΠΑΡΑΚΑΤΩ ΕΠΙΛΟΓΕΣ ");

         for (MenuOptionsProthipourgos option : MenuOptionsProthipourgos.values()) {
              System.out.println((option.ordinal() + 1) + "." + option.getDescriptionProthipourgos());
         }
         int choiceProthipourgou = input.nextInt();

         MenuOptionsProthipourgos selectedChoice = MenuOptionsProthipourgos.values()[choiceProthipourgou-1];
         System.out.println("επελεξες" + "." + selectedChoice.getDescriptionProthipourgos());
        
         // διαχειριση επιλογων προθυπουργου 
         if (choiceProthipourgou == 1 ) {
            EisagwgiPoswn obj1 = new EisagwgiPoswn();
            obj1.provlepomena();
     }  else if (choiceProthipourgou == 2) {
           // εξαιρεση - δεν μπορει ο προθυπουργοσ να πατησει 2 αν τα υπουργεια δεν πατησουν 1
          if (isYpourgeiaPrepared == false) {
              throw new IllegalStateException("Δεν μπορείς να επιλέξεις 2 πριν γίνει η επιλογή 1 στα Υπουργεία!");
          } 
          YpourgeioPaideias.objpaideias.katanomiProypApoProthypoyrgo(); // προθυπουργοσ βλεπει τι ζητησε το καθε υπουργειο
          YpourgeioYgeias.objygeias.katanomiProypApoProthypoyrgo();  // και δινει τα ποσα που θελει 
          
     } 
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
         
          YpourgeioPaideias.objpaideias.paideia(choice2);
        }
        
        
        // ΔΙΑΧΕΙΡΙΣΗ ΜΕΝΟΥ ΕΠΙΛΟΓΩΝ ΓΙΑ ΥΠΟΥΡΓΕΙΟ ΥΓΕΙΑΣ 
        if (choice == 3) {
             System.out.println("διαλεξε μια απο  τις παρακατω επιλογες");

            for (MenouOPtionsforYpYgeias option : MenouOPtionsforYpYgeias.values()) {
                 System.out.println((option.ordinal() + 1) + "." + option.getDescriptionYgeias());
            }
            int choice3 = input.nextInt();

            MenouOPtionsforYpYgeias selectedOptygeias  = MenouOPtionsforYpYgeias.values()[choice3-1];
            System.out.println("επελεξες" + "." + selectedOptygeias.getDescriptionYgeias()); 
            YpourgeioYgeias.objygeias.ygeia(choice3); //καλω την static μεθοδο που διαχειριζεται τισ επιλογες του Υπουργειου υγειας 
          }
     }
}
       
       
       
       
       
            

       
