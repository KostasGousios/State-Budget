public enum MenuOptions {
     PROTHIPOURGOS("ΑΝ ΕΙΣΤΕ ΠΡΟΘΥΠΟΥΡΓΟΣ/ΥΠΟΥΡΓΕΙΟ ΟΙΚΟΝΟΜΙΚΩΝ ΠΑΤΗΣΤΕ 1"),
     YPOYRGEIO_PAIDEIAS("ΑΝ ΕΙΣΤΕ ΥΠΟΥΡΓΕΙΟ ΠΑΕΙΔΕΙΑΣ ΠΑΤΗΣΤΕ 2"),
     YPOYRGEIO_YGEIAS("ΑΝ ΕΙΣΤΕ ΤΟ ΥΠΟΥΡΓΕΙΟ ΥΓΕΙΑΣ ΠΑΤΗΣΤΕ 3");
     
     private String description;

     MenuOptions(String description) {
        this.description = description;
     }
     public String getDescription() {
        return description;
     }
}
