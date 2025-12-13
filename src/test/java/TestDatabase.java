import java.sql.Connection;

public class TestDatabase {
        public static void main(String[] args) {
        try {
            //Δημιουργία της βάσης
            Connection conn = Database.getConnection();
            System.out.println("Βάση δημιουργήθηκε: statebudget.db");
            conn.close();
            
        } catch (Exception e) {
            System.out.println("Σφάλμα: " + e.getMessage());
        }
    }
}
