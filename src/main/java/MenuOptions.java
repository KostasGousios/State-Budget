
public enum MenuOptions {
     PROTHIPOURGOS_ARXH("Δημιουργία πρώτου υποθετικού προϋπολογισμού"),
     YPOYRGEIO_PAIDEIAS("Ζητάει το υπουργείο παιδείας χρήματα"),
     YPOYRGEIO_YGEIAS("Ζητάει το υπουργείο υγείας χρήματα"),
     PROTHIPOYRGOS_MESH("Πρωθυπουργός εισάγει τι ποσά  πραγματοποιήθηκαν"),
     PROTHIPOURGOS_TELOS("Πρωθυπουργός θέλει παραδώσει τελικό προϋπολογισμό");

     private String description;

     MenuOptions(String description) {
        this.description = description;
     }
     public String getDescription() {
        return description;
     }
}
