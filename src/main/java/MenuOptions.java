
public enum MenuOptions {
     PROTHIPOURGOS_ARXH("δημιουργια πρωτου υποθετικου προυπολογισμου"),
     YPOYRGEIO_PAIDEIAS("ζηταει το υπουργειο παιδειας χρηματα"),
     YPOYRGEIO_YGEIAS("ζηταει το υπουργειο υγειας χρηματα"),
     PROTHIPOYRGOS_MESH("προθυπουργος εισαγει τι ποσα  πραγματοποιηθηκαν"),
     PROTHIPOURGOS_TELOS("προθυπουργος θελει να παραδωσει τελικο προυπολογισμο");

     private String description;

     MenuOptions(String description) {
        this.description = description;
     }
     public String getDescription() {
        return description;
     }
}
