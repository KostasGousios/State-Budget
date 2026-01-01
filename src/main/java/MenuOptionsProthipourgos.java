public enum MenuOptionsProthipourgos {
        ARXH("Υποθετικός προϋπολογισμός"),
        ARXH2("Δείτε τα ποσά που ζήτησαν τα υπουργεία, και μοιράστε το budget σας σε αυτα"),
        MESH("Εισάγετε τα έξοδα/έσοδα που έχουν γίνει μέχρι στιγμής και ενημερωθείτε αμα ακολουθείται ο αρχικός προϋπολογισμός"),
        TELOS("Τελικός προϋπολογισμός, και διαφορές με τον αρχικό"),
        PANDHMIA("Ειδικό σενάριο: Πανδημία"),
        FYSIKIKATASTROFI("Ειδικό σενάριο: Διαχείριση φυσικής καταστροφής");
        
        private String description;

        MenuOptionsProthipourgos(String description) {
                this.description = description ;
        }
        public String getDescriptionProthipourgos() {
                return description;
        }
}


