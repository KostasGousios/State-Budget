<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="el">

<head>
    <title>Υπουργείο Υγείας - GOV-Budget</title>
    <link rel="stylesheet" href="css/form_style.css" />
</head>

<body class="ygeia">
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
                <h1>Φόρμα Υπουργείου Υγείας</h1>
                <p>Συμπληρώστε τα παρακάτω πεδία για την αίτηση και διανομή κονδυλίων στον τομέα Υγείας</p>
            </div>

            <div class="info-box">
                <p><strong>Πληροφορίες:</strong> Συμπληρώστε τα παρακάτω πεδία για την αίτηση και διανομή
                    κονδυλίων στον τομέα Υγείας</p>
            </div>

            <form id="ygeiaForm" method="POST">
                <div class="form-section">
                    <h3>1. Αίτηση Κονδυλίων - Αρχή Χρονιάς</h3>
                    <div class="form-group">
                        <label for="zitoumenoPoso">Ποσό που Ζητάτε (€):</label>
                        <input type="number" id="zitoumenoPoso" name="zitoumenoPoso" required min="0" step="1000"
                            placeholder="Εισάγετε το ποσό που ζητάτε για το Υπουργείο Υγείας" class="form-control">
                    </div>
                </div>

                <div class="form-section">
                    <h3>2. Διαχείριση Διαθέσιμων Κονδυλίων</h3>
                    <div class="form-group">
                        <label for="diatesimoPoso">Διαθέσιμο Ποσό (€):</label>
                        <input type="number" id="diatesimoPoso" name="diatesimoPoso" required min="0" step="1000"
                            placeholder="Το ποσό που έχετε στη διάθεσή σας για το Υπουργείο Υγείας" class="form-control">
                    </div>
                </div>

                <button type="submit" class="submit-btn">ΑΠΟΘΗΚΕΥΣΗ ΔΕΔΟΜΕΝΩΝ</button>
            </form>
        </div>
    </main>

    <footer class="site-footer">
        <p>© 2025 Gov-Budget. Αποκλειστική χρήση της κυβέρνησης.</p>
    </footer>

    <script>
        document.addEventListener('DOMContentLoaded', function() {
            const form = document.getElementById('ygeiaForm');
            
            if (form) {
                form.addEventListener('submit', function(event) {
                    // Αποτροπή της κανονικής υποβολής της φόρμας
                    event.preventDefault();
                    
                    // Έλεγχος εγκυρότητας της φόρμας
                    if (!form.checkValidity()) {
                        form.reportValidity();
                        return false;
                    }
                    
                    // 1. Αποθήκευση τοπικά στον υπολογιστή
                    const formData = {};
                    const inputs = form.querySelectorAll('input, textarea');
                    
                    inputs.forEach(input => {
                        if (input.name) {
                            formData[input.name] = input.value;
                        }
                    });
                    
                    localStorage.setItem('ygeia_form_data', JSON.stringify(formData));
                    
                    // 2. Αποθήκευση στο session για preview.jsp
                    sessionStorage.setItem('submitted_form_data', JSON.stringify(formData));
                    
                    // Εμφάνιση του pop-up
                    const popup = document.getElementById('savePopup');
                    if (popup) {
                        popup.style.display = 'flex';
                    }
                    
                    // Αναμονή 2 δευτερόλεπτα και μετά μετάβαση στην αρχική σελίδα
                    setTimeout(function() {
                        window.location.href = 'HomePage.jsp';
                    }, 2000);
                    
                    return false;
                });
            }
        });
    </script>
</body>

</html>