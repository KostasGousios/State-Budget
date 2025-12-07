public enum MenouOPtionsforYpYgeias {
     ARXH_XRONIAS("ΠΑΡΑΧΩΡΕΙΣΤΕ ΤΟ ΠΟΣΟ ΠΟΥ ΖΗΤΑΤΕ"),
     ARXH_2_XRONIAS("ΔΕΙΤΕ ΤΟ ΠΟΣΟ ΠΟΥ ΕΧΕΤΕ ΣΤΗΝ ΔΙΑΘΕΣΗ ΣΑΣ ΚΑΙ ΜΟΙΡΑΣΤΕ ΤΟ ΣΤΟΥΣ ΛΟΓΑΡΙΑΣΜΟΥΣ"),
     

     private String description;
    
     MenouOPtionsforYpYgeias(String description) {
         this.description = description;
     }

     public String getDescriptionYgeias() {
         return description;
    }
}
