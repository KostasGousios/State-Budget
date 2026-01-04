<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="el">

<head>
    <title>GOV-Budget - Αρχική Σελίδα</title>
    <link rel="stylesheet" href="css/style.css" />
</head>

<body>
    <header class="site-header">
        <div class="logo-area">
            <img src="images/gov-budget-high-resolution-logo-transparent.png" alt="gov-Budget-logo" class="logo-image" />
        </div>
        <p class="tool-description">
            Πλατφόρμα διαχείρισης προυπολογισμού
        </p>
    </header>

    <main class="main-content">
        <div class="info-frame-container">
            <div class="info-frame">
                <section class="about-platform">
                    <h2>Λίγα λόγια για την πλατφόρμα μας</h2>
                    <p>Στην πλατφόρμα αυτή προσομοιώνεται η διαδικασία δημιουργίας του κρατικού προϋπολογισμού. Ο Πρωθυπουργός
                        καταρτίζει έναν αρχικό, υποθετικό προϋπολογισμό, ενώ τα υπουργεία δηλώνουν τα ποσά που χρειάζονται. Στη
                        συνέχεια, ο Πρωθυπουργός κατανέμει τα διαθέσιμα κονδύλια στα υπουργεία, τα οποία αναλαμβάνουν τη διαχείρισή
                        τους.</p>
                    <p>Κατά τη διάρκεια του έτους καταχωρούνται σταδιακά τα πραγματικά ποσά που δαπανώνται, διαμορφώνοντας έτσι τον
                        πραγματικό κρατικό προϋπολογισμού. Στο τέλος της χρονιάς προκύπτει αν ο προϋπολογισμός ήταν ισοσκελισμένος,
                        ελλειμματικός ή πλεονασματικός.</p>
                </section>
            </div>
        </div>
        
        <!-- Προεπισκόπηση Μενού Ρόλων -->
        <section class="menu-preview-section">
            <h2 class="preview-title">Προεπισκόπηση Δυνατοτήτων Ανά Ρόλο</h2>
            
            <div class="role-preview-selector">
                <strong>Επιλέξτε Ρόλο για Προεπισκόπηση:</strong><br><br>
                <a href="?preview=prothipourgos" 
                    class="preview-role-btn <%= "prothipourgos".equals(request.getParameter("preview")) ? "active" : "" %>">
                    Πρωθυπουργός
                </a>
                <a href="?preview=paideia" 
                    class="preview-role-btn <%= "paideia".equals(request.getParameter("preview")) ? "active" : "" %>">
                    Υπουργός Παιδείας
                </a>
                <a href="?preview=ygeia" 
                    class="preview-role-btn <%= "ygeia".equals(request.getParameter("preview")) ? "active" : "" %>">
                    Υπουργός Υγείας
                </a>
            </div>
            
            <%
                // Λήψη παραμέτρου προεπισκόπησης από το URL
                String previewRole = request.getParameter("preview");
                if (previewRole == null || previewRole.trim().isEmpty()) {
                    previewRole = "prothipourgos"; // Προεπιλεγμένος ρόλος
                }
                
                String[] previewMenuItems = null;
                String previewRoleTitle = "";
                String previewRoleClass = "";
                String previewRoleForm = "";
                
                // Ορισμός των επιλογών μενού για κάθε ρόλο
                if ("prothipourgos".equals(previewRole)) {
                    previewRoleTitle = "Πρωθυπουργός";
                    previewRoleClass = "prothipourgos-preview";
                    previewRoleForm = "ProthipourgosForm.jsp";
                    previewMenuItems = new String[] {
                        "Υποθετικός προϋπολογισμός",
                        "Δείτε τα ποσά που ζήτησαν τα υπουργεία, και μοιράστε το budget σας σε αυτά",
                        "Εισάγετε τα έξοδα/έσοδα που έχουν γίνει μέχρι στιγμής και ενημερωθείτε αμα ακολουθείται ο αρχικός προϋπολογισμός",
                        "Τελικός προϋπολογισμός, και διαφορές με τον αρχικό",
                        "Ειδικό σενάριο:Πανδημία"
                    };
                } else if ("paideia".equals(previewRole)) {
                    previewRoleTitle = "Υπουργός Παιδείας";
                    previewRoleClass = "paideia-preview";
                    previewRoleForm = "PaideiaForm.jsp";
                    previewMenuItems = new String[] {
                        "Δηλώστε το χρηματικό ποσό που ζητάτε",
                        "Δείτε το ποσό που πήρατε και μοιράστε το σε λογαριασμούς"
                    };
                } else if ("ygeia".equals(previewRole)) {
                    previewRoleTitle = "Υπουργός Υγείας";
                    previewRoleClass = "ygeia-preview";
                    previewRoleForm = "YgeiaForm.jsp";
                    previewMenuItems = new String[] {
                        "Δηλώστε το χρηματικό ποσό που ζητάτε",
                        "Μοιράστε το ποσό που πήρατε σε επιμέρους λογαριασμούς"
                    };
                } else {
                    previewRoleTitle = "Άγνωστος Ρόλος";
                    previewMenuItems = new String[] {"Δεν βρέθηκαν επιλογές για αυτόν τον ρόλο"};
                }
            %>
            
            <div class="menu-preview">
                <h3 class="preview-role-title">Προεπισκόπηση Μενού για: <strong><%= previewRoleTitle %></strong></h3>
                
                <% if (previewMenuItems != null && previewMenuItems.length > 0) { %>
                    <ul class="preview-menu-list <%= previewRoleClass %>">
                        <% for (String item : previewMenuItems) { %>
                            <li><%= item %></li>
                        <% } %>
                    </ul>
                <% } else { %>
                    <div class="no-preview">
                        <p>Δεν υπάρχουν διαθέσιμες επιλογές για προεπισκόπηση.</p>
                    </div>
                <% } %>
            </div>
            
            <div class="simple-btn-container">
                <% if (previewRoleForm != null && !previewRoleForm.isEmpty()) { %>
                    <a href="<%= previewRoleForm %>" class="role-btn">
                        Σύνδεση ως <%= previewRoleTitle %>
                    </a>
                <% } %>
                
                <a href="preview.jsp" class="role-btn">
                    Προεπισκόπηση Προϋπολογισμού
                </a>
            </div>
        </section>
    </main>

    <footer class="site-footer">
        <p>© 2025 Gov-Budget. Αποκλειστική χρήση της κυβέρνησης.</p>
    </footer>
</body>

</html>