<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="el">

<head>
    <title>Πρωθυπουργός - GOV-Budget</title>
    <link rel="stylesheet" href="css/form_style.css" />
    <link rel="stylesheet" href="css/style.css" />
</head>

<body class="prothipourgos">
    <!-- Pop-up για μήνυμα αποθήκευσης -->
    <div id="savePopup" class="popup-overlay">
        <div class="popup-content">
            <h3>Αποθήκευση Στοιχείων</h3>
            <p>Τα στοιχεία σας αποθηκεύτηκαν με επιτυχία!</p>
            <div class="popup-loader"></div>
        </div>
    </div>

    <header class="site-header">
        <div class="logo-area">
            <img src="images/gov-budget-high-resolution-logo-transparent.png" alt="gov-Budget-logo"
                class="logo-image" />
        </div>
        <p class="tool-description">
            Πλατφόρμα διαχείρισης προυπολογισμού
        </p>
    </header>

    <main class="main-content">
        <div class="about-platform">
            <div class="form-header">
                <a href="HomePage.jsp" class="back-link">← Επιστροφή στην Αρχική Σελίδα</a>
                <h1>Φόρμα Πρωθυπουργού</h1>
                <p>Συμπληρώστε τα παρακάτω πεδία για τη δημιουργία και διαχείριση του προϋπολογισμού</p>
            </div>

            <div class="info-box">
                <p><strong>Οδηγίες:</strong> Συμπληρώστε όλα τα πεδία για την πλήρη διαχείρισης του κρατικού
                    προϋπολογισμού</p>
            </div>

            <form id="prothipourgosForm" method="POST">
                <div class="form-section">
                    <h3>1. Έσοδα</h3>
                    <div class="form-group">
                        <label for="foroi">Φόροι (€):</label>
                        <input type="number" id="foroi" name="foroi" min="0" step="1000" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="daneia">Δάνεια (€):</label>
                        <input type="number" id="daneia" name="daneia" min="0" step="1000" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="loipaEsoda">Λοιπά Έσοδα (€):</label>
                        <input type="number" id="loipaEsoda" name="loipaEsoda" min="0" step="1000" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="synolikaEsoda">Συνολικά Έσοδα (€):</label>
                        <div class="calculation-group">
                            <input type="number" id="synolikaEsoda" name="synolikaEsoda" min="0" step="1000"
                                placeholder="Θα υπολογιστεί αυτόματα" class="form-control" readonly>
                            <button type="button" id="showEsodaBtn" class="calc-btn">Εμφάνιση Συνολικών Εσόδων</button>
                        </div>
                    </div>
                </div>

                <div class="form-section">
                    <h3>2. Έξοδα</h3>
                    <div class="form-group">
                        <label for="misthoi">Μισθοί (€):</label>
                        <input type="number" id="misthoi" name="misthoi" min="0" step="1000" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="syntaxeis">Συντάξεις (€):</label>
                        <input type="number" id="syntaxeis" name="syntaxeis" min="0" step="1000" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="loipaExoda">Λοιπά Έξοδα (€):</label>
                        <input type="number" id="loipaExoda" name="loipaExoda" min="0" step="1000" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="exodaYpourgeia">Έξοδα για Υπουργεία (€):</label>
                        <input type="number" id="exodaYpourgeia" name="exodaYpourgeia" min="0" step="1000" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="synolikaExoda">Συνολικά Έξοδα (€):</label>
                        <div class="calculation-group">
                            <input type="number" id="synolikaExoda" name="synolikaExoda" min="0" step="1000"
                                placeholder="Θα υπολογιστεί αυτόματα" class="form-control" readonly>
                            <button type="button" id="showExodaBtn" class="calc-btn">Εμφάνιση Συνολικών Εξόδων</button>
                        </div>
                    </div>
                </div>

                <div class="form-section">
                    <h3>3. Κρατικό Ταμείο</h3>
                    <div class="form-group">
                        <label for="tameio">Ταμείο (Αριθμός):</label>
                        <input type="number" id="tameio" name="tameio" min="1" step="1" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="archikoPoso">Αρχικό Ποσό (€):</label>
                        <input type="number" id="archikoPoso" name="archikoPoso" min="0" step="1000" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="poso">Τρέχον Ποσό (€):</label>
                        <input type="number" id="poso" name="poso" min="0" step="1000" placeholder="Τρέχον διαθέσιμο ποσό" class="form-control">
                    </div>
                </div>

                <button type="submit" class="submit-btn">Αποθήκευση</button>
            </form>
        </div>
    </main>

    <footer class="site-footer">
        <p>© 2025 Gov-Budget. Αποκλειστική χρήση της κυβέρνησης.</p>
    </footer>

    <script>
        // Συνάρτηση υπολογισμού Εσόδων (μόνο με κουμπί)
        function showTotalEsoda() {
            const foroi = parseFloat(document.getElementById('foroi').value) || 0;
            const daneia = parseFloat(document.getElementById('daneia').value) || 0;
            const loipaEsoda = parseFloat(document.getElementById('loipaEsoda').value) || 0;
            
            const totalEsoda = foroi + daneia + loipaEsoda;
            document.getElementById('synolikaEsoda').value = totalEsoda;
        }
        
        // Συνάρτηση υπολογισμού Εξόδων (μόνο με κουμπί)
        function showTotalExoda() {
            const misthoi = parseFloat(document.getElementById('misthoi').value) || 0;
            const syntaxeis = parseFloat(document.getElementById('syntaxeis').value) || 0;
            const loipaExoda = parseFloat(document.getElementById('loipaExoda').value) || 0;
            const exodaYpourgeia = parseFloat(document.getElementById('exodaYpourgeia').value) || 0;
            
            const totalExoda = misthoi + syntaxeis + loipaExoda + exodaYpourgeia;
            document.getElementById('synolikaExoda').value = totalExoda;
        }

        document.addEventListener('DOMContentLoaded', function() {
            // Μόνο με κουμπί υπολογισμός
            document.getElementById('showEsodaBtn').addEventListener('click', showTotalEsoda);
            document.getElementById('showExodaBtn').addEventListener('click', showTotalExoda);
            
            // Υποβολή φόρμας
            document.getElementById('prothipourgosForm').addEventListener('submit', function(event) {
                event.preventDefault();
                
                // 1. Αποθήκευση τοπικά στον υπολογιστή
                const formData = {};
                const form = document.getElementById('prothipourgosForm');
                const inputs = form.querySelectorAll('input');
                
                inputs.forEach(input => {
                    if (input.name) {
                        formData[input.name] = input.value;
                    }
                });
                
                localStorage.setItem('prothipourgos_form_data', JSON.stringify(formData));
                
                // 2. Αποθήκευση στο session για preview.jsp
                sessionStorage.setItem('submitted_form_data', JSON.stringify(formData));
                
                // 3. Εμφάνιση pop-up
                document.getElementById('savePopup').style.display = 'flex';
                
                // 4. Μετά από 2 δευτερόλεπτα πήγαινε στην αρχική
                setTimeout(function() {
                    window.location.href = 'HomePage.jsp';
                }, 2000);
            });
        });
    </script>
</body>

</html>