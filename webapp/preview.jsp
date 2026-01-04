<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="el">

    <head>
        <meta charset="UTF-8">
        <title>Προβολή Υποβληθέντων Δεδομένων</title>

        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <link rel="stylesheet" href="css/preview_style.css">
    </head>

    <body>

        <!-- Header Section -->
        <header class="site-header">
            <div class="logo-area">
                <img src="images/gov-budget-high-resolution-logo-transparent.png" alt="gov-Budget-logo"
                    class="logo-image" />
            </div>
            <p class="tool-description">
                Πλατφόρμα διαχείρισης προυπολογισμού - Προβολή Δεδομένων
            </p>
        </header>

        <main class="main-content">
            <!-- Preview Frame Container -->
            <div class="preview-frame-container">
                <div class="preview-frame">
                    <div class="preview-container">
                        <h1 class="preview-title">Προβολή Υποβληθέντων Δεδομένων</h1>

                        <!-- Content will be loaded here by JavaScript -->
                        <div id="content">
                            <div class="no-data">
                                Δεν βρέθηκαν δεδομένα. Υποβάλετε πρώτα μια φόρμα.
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <footer class="site-footer">
            <p>© 2025 Gov-Budget. Αποκλειστική χρήση της κυβέρνησης.</p>
        </footer>

        <script>
            // Ορισμός πεδίων για κάθε φόρμα
            var prothipourgosFields = [
                { section: 'ΕΣΟΔΑ' },
                { key: 'foroi', label: 'Φόροι (€)' },
                { key: 'daneia', label: 'Δάνεια (€)' },
                { key: 'loipaEsoda', label: 'Λοιπά Έσοδα (€)' },
                { key: 'synolikaEsoda', label: 'Συνολικά Έσοδα (€)' },

                { section: 'ΕΞΟΔΑ' },
                { key: 'misthoi', label: 'Μισθοί (€)' },
                { key: 'syntaxeis', label: 'Συντάξεις (€)' },
                { key: 'loipaExoda', label: 'Λοιπά Έξοδα (€)' },
                { key: 'exodaYpourgeia', label: 'Έξοδα για Υπουργεία (€)' },
                { key: 'synolikaExoda', label: 'Συνολικά Έξοδα (€)' },

                { section: 'ΚΡΑΤΙΚΟ ΤΑΜΕΙΟ' },
                { key: 'tameio', label: 'Ταμείο (Αριθμός)' },
                { key: 'archikoPoso', label: 'Αρχικό Ποσό (€)' },
                { key: 'poso', label: 'Τρέχον Ποσό (€)' }
            ];

            // Νέα πεδία για Παιδεία
            var paideiaFields = [
                { section: 'ΠΑΙΔΕΙΑ - ΣΤΟΙΧΕΙΑ' },
                { key: 'zitoumenoPoso', label: 'Ποσό που Ζητάτε (€)' },
                { key: 'diatesimoPoso', label: 'Διαθέσιμο Ποσό (€)' }
            ];

            // Νέα πεδία για Υγεία
            var ygeiaFields = [
                { section: 'ΥΓΕΙΑ - ΣΤΟΙΧΕΙΑ' },
                { key: 'zitoumenoPoso', label: 'Ποσό που Ζητάτε (€)' },
                { key: 'diatesimoPoso', label: 'Διαθέσιμο Ποσό (€)' }
            ];

            // Βοηθητικές συναρτήσεις
            function getFormName(formKey) {
                if (formKey === 'prothipourgos') return 'Φόρμα Πρωθυπουργού';
                if (formKey === 'paideia') return 'Φόρμα Υπουργείου Παιδείας';
                if (formKey === 'ygeia') return 'Φόρμα Υπουργείου Υγείας';
                return 'Άγνωστη Φόρμα';
            }

            function getAllFormData() {
                var combinedData = {};

                // Έλεγχος sessionStorage (τελευταία υποβεβλημένη φόρμα)
                var lastSubmitted = sessionStorage.getItem('submitted_form_data');
                if (lastSubmitted) {
                    try {
                        var lastData = JSON.parse(lastSubmitted);
                        // Προσδιορισμός από ποια φόρμα προέρχονται τα δεδομένα
                        var formName = determineFormType(lastData);
                        combinedData[formName] = lastData;
                        combinedData.lastForm = formName;
                    } catch (e) {
                        console.log('Σφάλμα ανάγνωσης sessionStorage');
                    }
                }

                // Αναζήτηση στο localStorage για όλες τις φόρμες
                var formKeys = ['prothipourgos', 'paideia', 'ygeia'];
                for (var i = 0; i < formKeys.length; i++) {
                    var key = formKeys[i];
                    var storedData = localStorage.getItem(key + '_form_data');
                    if (storedData) {
                        try {
                            combinedData[key] = JSON.parse(storedData);
                        } catch (e) {
                            console.log('Σφάλμα ανάγνωσης ' + key + ' από localStorage');
                        }
                    }
                }

                return combinedData;
            }

            function determineFormType(data) {
                if (data.foroi !== undefined || data.daneia !== undefined) {
                    return 'prothipourgos';
                } else if (data.logariasmoiKatatomi !== undefined) {
                    // Αν υπάρχει το παλιό πεδίο, είναι Παιδεία
                    return 'paideia';
                } else if (data.aitisiApologismos !== undefined) {
                    // Αν υπάρχει το παλιό πεδίο, είναι Υγεία
                    return 'ygeia';
                } else if (data.zitoumenoPoso !== undefined && data.diatesimoPoso !== undefined) {
                    if (localStorage.getItem('paideia_form_data')) {
                        var paideiaData = JSON.parse(localStorage.getItem('paideia_form_data') || '{}');
                        if (paideiaData.zitoumenoPoso === data.zitoumenoPoso &&
                            paideiaData.diatesimoPoso === data.diatesimoPoso) {
                            return 'paideia';
                        }
                    }
                    if (localStorage.getItem('ygeia_form_data')) {
                        var ygeiaData = JSON.parse(localStorage.getItem('ygeia_form_data') || '{}');
                        if (ygeiaData.zitoumenoPoso === data.zitoumenoPoso &&
                            ygeiaData.diatesimoPoso === data.diatesimoPoso) {
                            return 'ygeia';
                        }
                    }
                    // Προεπιλογή: Παιδεία
                    return 'paideia';
                }
                return 'unknown';
            }

            function createFormHTML(formKey, formData, fields, isLastForm) {
                var formName = getFormName(formKey);
                var lastFormText = isLastForm ? '(Τελευταία υποβεβλημένη φόρμα)' : '';

                var html = '<div class="form-info">' +
                    '<p class="form-name">Δεδομένα από: ' + formName + '</p>' +
                    '<p>' + lastFormText + '</p>' +
                    '</div>' +
                    '<table class="data-table">' +
                    '<tr>' +
                    '<th>Στοιχείο</th>' +
                    '<th>Τιμή</th>' +
                    '</tr>';

                var currentSection = '';
                for (var i = 0; i < fields.length; i++) {
                    var field = fields[i];
                    if (field.section) {
                        currentSection = field.section;
                        html += '<tr style="background-color: #e8f4f8;">' +
                            '<td colspan="2" style="font-weight: bold;">' +
                            currentSection +
                            '</td>' +
                            '</tr>';
                    } else {
                        var value = formData[field.key];
                        if (value === undefined || value === null || value === '') {
                            value = '—';
                        }
                        var isNumber = field.key.indexOf('Poso') !== -1 ||
                            field.key.indexOf('Esoda') !== -1 ||
                            field.key.indexOf('Exoda') !== -1 ||
                            field.key === 'tameio' ||
                            field.key === 'archikoPoso' ||
                            field.key === 'poso' ||
                            field.key === 'foroi' ||
                            field.key === 'daneia' ||
                            field.key === 'loipaEsoda' ||
                            field.key === 'synolikaEsoda' ||
                            field.key === 'misthoi' ||
                            field.key === 'syntaxeis' ||
                            field.key === 'loipaExoda' ||
                            field.key === 'exodaYpourgeia' ||
                            field.key === 'synolikaExoda';

                        var valueClass = isNumber && value !== '—' ? 'value-cell' : '';

                        html += '<tr>' +
                            '<td>' + field.label + '</td>' +
                            '<td class="' + valueClass + '">' + value + '</td>' +
                            '</tr>';
                    }
                }

                html += '</table>';
                return html;
            }

            // Κύριο σώμα εκτέλεσης
            document.addEventListener('DOMContentLoaded', function () {
                var allData = getAllFormData();
                var container = document.getElementById('content');

                // Έλεγχος αν υπάρχουν δεδομένα από οποιαδήποτε φόρμα
                var hasProthipourgosData = allData.prothipourgos && Object.keys(allData.prothipourgos).length > 0;
                var hasPaideiaData = allData.paideia && Object.keys(allData.paideia).length > 0;
                var hasYgeiaData = allData.ygeia && Object.keys(allData.ygeia).length > 0;

                if (hasProthipourgosData || hasPaideiaData || hasYgeiaData) {
                    var leftPanelHTML = '<div class="data-container">' +
                        '<div class="left-panel">' +
                        '<h2>Στοιχεία από Φόρμες</h2>';

                    // Προσθήκη δεδομένων από κάθε φόρμα
                    if (hasProthipourgosData) {
                        var isLastForm = allData.lastForm === 'prothipourgos';
                        leftPanelHTML += createFormHTML('prothipourgos', allData.prothipourgos, prothipourgosFields, isLastForm);
                    }

                    if (hasPaideiaData) {
                        var isLastForm = allData.lastForm === 'paideia';
                        leftPanelHTML += createFormHTML('paideia', allData.paideia, paideiaFields, isLastForm);
                    }

                    if (hasYgeiaData) {
                        var isLastForm = allData.lastForm === 'ygeia';
                        leftPanelHTML += createFormHTML('ygeia', allData.ygeia, ygeiaFields, isLastForm);
                    }

                    leftPanelHTML += '</div>' +
                        '<div class="right-panel">' +
                        '<h2>Διαγραμματική Απεικόνιση</h2>' +
                        '<div class="chart-container">' +
                        '<canvas id="budgetChart"></canvas>' +
                        '</div>' +
                        '</div>' +
                        '</div>' +
                        '<div class="navigation-buttons">' +
                        '<a href="ProthipourgosForm.jsp" class="nav-btn">Φόρμα Πρωθυπουργού</a>' +
                        '<a href="PaideiaForm.jsp" class="nav-btn">Φόρμα Παιδείας</a>' +
                        '<a href="YgeiaForm.jsp" class="nav-btn">Φόρμα Υγείας</a>' +
                        '<a href="HomePage.jsp" class="nav-btn">Αρχική Σελίδα</a>' +
                        '</div>';

                    container.innerHTML = leftPanelHTML;

                    // Προετοιμασία δεδομένων για το γράφημα
                    var esoda = hasProthipourgosData ? parseFloat(allData.prothipourgos.synolikaEsoda) || 0 : 0;
                    var exoda = hasProthipourgosData ? parseFloat(allData.prothipourgos.synolikaExoda) || 0 : 0;
                    var tameio = hasProthipourgosData ? parseFloat(allData.prothipourgos.poso) || 0 : 0;
                    var paideiaZitoumeno = hasPaideiaData ? parseFloat(allData.paideia.zitoumenoPoso) || 0 : 0;
                    var paideiaDiatesimo = hasPaideiaData ? parseFloat(allData.paideia.diatesimoPoso) || 0 : 0;
                    var ygeiaZitoumeno = hasYgeiaData ? parseFloat(allData.ygeia.zitoumenoPoso) || 0 : 0;
                    var ygeiaDiatesimo = hasYgeiaData ? parseFloat(allData.ygeia.diatesimoPoso) || 0 : 0;

                    // Υπολογισμός συνολικών αιτήσεων και διαθέσιμων ποσών
                    var totalZitoumeno = paideiaZitoumeno + ygeiaZitoumeno;
                    var totalDiatesimo = paideiaDiatesimo + ygeiaDiatesimo;

                    // Καθορισμός τιμών για το γράφημα
                    var chartLabels = [];
                    var chartData = [];
                    var backgroundColors = [];

                    // Προσθήκη δεδομένων ανάλογα με τις διαθέσιμες φόρμες
                    if (hasProthipourgosData) {
                        chartLabels.push('Συνολικά Έσοδα', 'Συνολικά Έξοδα', 'Τρέχον Ταμείο');
                        chartData.push(esoda, exoda, tameio);
                        backgroundColors.push('rgba(102, 126, 234, 0.7)', 'rgba(118, 75, 162, 0.7)', 'rgba(54, 162, 235, 0.7)');
                    }

                    // Προσθήκη δεδομένων για Παιδεία (αν υπάρχουν)
                    if (hasPaideiaData) {
                        chartLabels.push('Παιδεία: Ζητούμενο', 'Παιδεία: Διαθέσιμο');
                        chartData.push(paideiaZitoumeno, paideiaDiatesimo);
                        backgroundColors.push('rgba(255, 206, 86, 0.7)', 'rgba(153, 102, 255, 0.7)');
                    }

                    // Προσθήκη δεδομένων για Υγεία (αν υπάρχουν)
                    if (hasYgeiaData) {
                        chartLabels.push('Υγεία: Ζητούμενο', 'Υγεία: Διαθέσιμο');
                        chartData.push(ygeiaZitoumeno, ygeiaDiatesimo);
                        backgroundColors.push('rgba(255, 159, 64, 0.7)', 'rgba(201, 203, 207, 0.7)');
                    }

                    // Προσθήκη συνολικών στοιχείων αν υπάρχουν τουλάχιστον 2 φορμες
                    if ((hasPaideiaData && hasYgeiaData) || (hasProthipourgosData && (hasPaideiaData || hasYgeiaData))) {
                        chartLabels.push('Σύνολο Αιτήσεων', 'Σύνολο Διαθέσιμων');
                        chartData.push(totalZitoumeno, totalDiatesimo);
                        backgroundColors.push('rgba(46, 204, 113, 0.7)', 'rgba(52, 152, 219, 0.7)');
                    }

                    // Δημιουργία γραφήματος
                    var ctx = document.getElementById('budgetChart').getContext('2d');
                    new Chart(ctx, {
                        type: 'bar',
                        data: {
                            labels: chartLabels,
                            datasets: [{
                                label: 'Ποσά (€)',
                                data: chartData,
                                backgroundColor: backgroundColors,
                                borderColor: backgroundColors.map(function (color) {
                                    return color.replace('0.7', '1');
                                }),
                                borderWidth: 2
                            }]
                        },
                        options: {
                            responsive: true,
                            maintainAspectRatio: false,
                            plugins: {
                                legend: {
                                    display: true,
                                    position: 'top',
                                    labels: {
                                        font: {
                                            size: 14
                                        }
                                    }
                                },
                                title: {
                                    display: true,
                                    text: 'Σύνοψη Οικονομικών Δεδομένων',
                                    font: {
                                        size: 16,
                                        weight: 'bold'
                                    },
                                    color: '#2c3e50'
                                },
                                tooltip: {
                                    backgroundColor: 'rgba(255, 255, 255, 0.9)',
                                    titleColor: '#2c3e50',
                                    bodyColor: '#2c3e50',
                                    borderColor: '#667eea',
                                    borderWidth: 1,
                                    callbacks: {
                                        label: function (context) {
                                            return context.label + ': €' + context.parsed.y.toLocaleString('el-GR');
                                        }
                                    }
                                }
                            },
                            scales: {
                                y: {
                                    beginAtZero: true,
                                    grid: {
                                        color: 'rgba(0, 0, 0, 0.05)'
                                    },
                                    ticks: {
                                        callback: function (value) {
                                            return '€' + value.toLocaleString('el-GR');
                                        },
                                        font: {
                                            size: 12
                                        }
                                    },
                                    title: {
                                        display: true,
                                        text: 'Ποσό (€)',
                                        font: {
                                            size: 14,
                                            weight: 'bold'
                                        }
                                    }
                                },
                                x: {
                                    grid: {
                                        color: 'rgba(0, 0, 0, 0.05)'
                                    },
                                    ticks: {
                                        font: {
                                            size: 11
                                        },
                                        maxRotation: 45,
                                        minRotation: 45
                                    }
                                }
                            }
                        }
                    });

                } else {
                    // Αν δεν υπάρχουν δεδομένα
                    container.innerHTML = '<div class="no-data">' +
                        'Δεν βρέθηκαν δεδομένα. Υποβάλετε πρώτα μια φόρμα.' +
                        '</div>' +
                        '<div class="navigation-buttons">' +
                        '<a href="ProthipourgosForm.jsp" class="nav-btn">Φόρμα Πρωθυπουργού</a>' +
                        '<a href="PaideiaForm.jsp" class="nav-btn">Φόρμα Παιδείας</a>' +
                        '<a href="YgeiaForm.jsp" class="nav-btn">Φόρμα Υγείας</a>' +
                        '<a href="HomePage.jsp" class="nav-btn">Αρχική Σελίδα</a>' +
                        '</div>';
                }
            });
        </script>

    </body>

    </html>