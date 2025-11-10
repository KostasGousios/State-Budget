import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
               Scanner input = new Scanner(System.in);

        // Αρχικό ποσό στο ταμείο
        System.out.print("Δώσε το αρχικό ποσό του κρατικού ταμείου: ");
        int arxikoPoso = input.nextInt();
        KratikoTameio tameio = new KratikoTameio(arxikoPoso);

        // Εισαγωγή εσόδων
        System.out.print("Δώσε έσοδα από φόρους: ");
        int foroi = input.nextInt();
        System.out.print("Δώσε έσοδα από δάνεια: ");
        int daneia = input.nextInt();
        System.out.print("Δώσε λοιπά έσοδα: ");
        int loipaEsoda = input.nextInt();
        Esoda esoda = new Esoda(foroi, daneia, loipaEsoda);

        // Εισαγωγή εξόδων
        System.out.print("Δώσε έξοδα για μισθούς: ");
        int misthoi = input.nextInt();
        System.out.print("Δώσε έξοδα για συντάξεις: ");
        int syntakseis = input.nextInt();
        System.out.print("Δώσε λοιπά έξοδα: ");
        int loipaExoda = input.nextInt();
        Exoda exoda = new Exoda(misthoi, syntakseis, loipaExoda);

        // Υπολογισμός διαφοράς
        int diafora = esoda.getAthroismaEsodon() - exoda.getAthroismaExodon();

        // Προσθήκη στο κρατικό ταμείο
        tameio.prosthikiStoTameio(diafora);

        // Εμφάνιση αποτελεσμάτων
        System.out.println("Άθροισμα εσόδων: " + esoda.getAthroismaEsodon());
        System.out.println("Άθροισμα εξόδων: " + exoda.getAthroismaExodon());
        System.out.println("Διαφορά εσόδων-εξόδων: " + diafora);
        System.out.println("Νέο ποσό στο κρατικό ταμείο: " + tameio.getTameio());

        input.close();
    }
    }
