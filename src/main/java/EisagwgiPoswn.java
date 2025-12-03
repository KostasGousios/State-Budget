import java.util.Scanner;

public class EisagwgiPoswn {
    Scanner input = new Scanner(System.in);
    Esoda esoda;
    Exoda exoda;
    KratikoTameio tameio;
    int synolikaPragmatikaExoda = 0;
    int synolikaPragmatikaEsoda = 0;
    public void provlepomena() { //καταγράφει τα προβλεπόμενα ποσά εσόδων/εξόδων στην αρχή του έτους
    // Αρχικό ποσό στο ταμείο
        System.out.print("Δώσε το αρχικό ποσό του κρατικού ταμείου από το προηγούμενο έτος: ");
        int arxikoPoso = input.nextInt();
        tameio = new KratikoTameio(arxikoPoso);

        // Εισαγωγή εσόδων
        System.out.print("Δώσε προβλεπόμενα έσοδα από φόρους: ");
        int foroi = input.nextInt();
        System.out.print("Δώσε προβλεπόμενα έσοδα από δάνεια: ");
        int daneia = input.nextInt();
        System.out.print("Δώσε πρόβλεψη για λοιπά έσοδα: ");
        int loipaEsoda = input.nextInt();
        esoda = new Esoda(foroi, daneia, loipaEsoda, tameio);

        // Εισαγωγή εξόδων
        System.out.print("Δώσε προβλεπόμενα έξοδα για μισθούς: ");
        int misthoi = input.nextInt();
        System.out.print("exodagiaypourgeia συντάξεις: ");
        int syntakseis = input.nextInt();
        System.out.print("Δώσε πρόβλεψη για λοιπά έξοδα: ");
        int loipaExoda = input.nextInt();
        System.out.println("Δώσε προβλεπόμενα έξοδα για υπουργεία: ");
        int exodagiaypourgeia = input.nextInt();
        exoda = new Exoda(misthoi, syntakseis, loipaExoda, exodagiaypourgeia);

        // Υπολογισμός διαφοράς με χρήση μεθόδων get άλλων κλάσεων
        int diaforaprovl = esoda.getAthroismaEsodon() - exoda.getAthroismaExodon();

        // Προσθήκη στο κρατικό ταμείο για να γίνει η πράξη στη κλάση KratikoTameio
        tameio.prosthikiStoTameio(diaforaprovl);

        // Εμφάνιση αποτελεσμάτων
        System.out.println("Άθροισμα προβλεπόμενων εσόδων" + esoda.getAthroismaEsodon());
        System.out.println("Άθροισμα προβλεπόμενων εξόδων: " + exoda.getAthroismaExodon());
        System.out.println("Διαφορά προβλεπόμενων εσόδων-εξόδων: " + diaforaprovl);
        System.out.println("Νέο ποσό στο κρατικό ταμείο: " + tameio.getTameio());
    }
    public void pragmatika() { //καταγράφει πραγματικά ποσά εσόδων/εξόδων που έγιναν μέσα στο χρόνο 
        // ---------------//

        // ελεγχος μηπως δεν εχουν δηλωθει πρωτα τα προβλεπομενα
        if (esoda == null || exoda == null) {
            System.out.println("ΠΡΩΤΑ πρέπει να εισάγεις τα προβλεπόμενα ποσά!");
            return;
        }

        //Θες να βαλεις πραγματικο εξοδο που εγινε 
        System.out.print("Δώσε πραγματικό έξοδο που συνέβη μέσα στη χρονιά: ");
        int pragmatikoExodo = input.nextInt();
        synolikaPragmatikaExoda += pragmatikoExodo;

        // ελεγχος να μην ξεπερναει το 90% των προβλεπομενων εξοδων
        double orio90 = exoda.getAthroismaExodon() * 0.90;

        if (synolikaPragmatikaExoda >= orio90) {
            System.out.println("WARNING: Τα πραγματικά έξοδα έχουν φτάσει το 90% των προβλεπόμενων!");
            System.out.println("Προβλεπόμενα έξοδα: " + exoda.getAthroismaExodon());
            System.out.println("Πραγματικά έξοδα: " + synolikaPragmatikaExoda);
        }

        //θες να βαλεις εσοδο που εγινε 
        System.out.print("Δώσε πραγματικό έσοδο που συνέβη μέσα στη χρονιά: ");
        int pragmatikoEsodo = input.nextInt();
        synolikaPragmatikaEsoda += pragmatikoEsodo;

        //ελεγχος να μην ξεπερναει το 90% των προβλεπομενων εσοδων
        double orioEsodon90 = esoda.getAthroismaEsodon() * 0.90;
        if (synolikaPragmatikaEsoda >= orioEsodon90) {
            System.out.println("WARNING: Τα πραγματικά έσοδα έχουν φτάσει το 90% των προβλεπόμενων!");
            System.out.println("Προβλεπόμενα έσοδα: " + esoda.getAthroismaEsodon());
            System.out.println("Πραγματικά έσοδα: " + synolikaPragmatikaEsoda);
        }
    }
    public void telika() {

    }
}
