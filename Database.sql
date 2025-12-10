PRAGMA foreign_keys = ON;

-- Υπουργεία
CREATE TABLE ypourgeia (
    ypoyrgeio_id INTEGER PRIMARY KEY AUTOINCREMENT,
    onoma TEXT NOT NULL
);

-- Λογαριασμοί υπουργείων
CREATE TABLE logariasmoi (
    logariasmos_id INTEGER PRIMARY KEY AUTOINCREMENT,
    onoma TEXT NOT NULL,
    trexon_poso REAL DEFAULT 0,
    ypourgeio_id INTEGER NOT NULL,
    FOREIGN KEY (ypoyrgeio_id) REFERENCES ypourgeia(ypoyrgeio_id)
);

-- Ποσοστό που δίνεται σε κάθε λογαριασμό
CREATE TABLE pososta_logariasmon (
    pososto_id INTEGER PRIMARY KEY AUTOINCREMENT,
    pososto REAL NOT NULL,
    logariasmos_id INTEGER NOT NULL,
    FOREIGN KEY (logariasmos_id) REFERENCES logariasmoi(logariasmos_id)
);

-- Τα προβλεπόμενα έσοδα και έξοδα για κάθε υπουργείο
CREATE TABLE provlepomena (
    provlepomena_id INTEGER PRIMARY KEY AUTOINCREMENT,
    misthoi REAL NOT NULL,
    syntakseis REAL NOT NULL,
    loipa REAL NOT NULL,
    exoda_ypourgeia REAL NOT NULL,
    foroi REAL NOT NULL,
    daneia REAL NOT NULL,
    loipa_esoda REAL NOT NULL,
    tameio_arxiko REAL NOT NULL,
    ypoyrgeio_id INTEGER,
    FOREIGN KEY (ypoyrgeio_id) REFERENCES ypourgeia(ypoyrgeio_id)
);

-- Τα πραγματικά έσοδα και έξοδα που συνέβησαν μέσα στη χρονιά
CREATE TABLE pragmatika_posa (
    kinisi_id INTEGER PRIMARY KEY AUTOINCREMENT,
    poso REAL NOT NULL,
    typos TEXT NOT NULL CHECK(typos IN ('ESODO','EXODO')),
    imerominia TEXT,
    ypoyrgeio_id INTEGER,
    logariasmos_id INTEGER,
    FOREIGN KEY (ypoyrgeio_id) REFERENCES ypourgeia(ypoyrgeio_id),
    FOREIGN KEY (logariasmos_id) REFERENCES logariasmoi(logariasmos_id)
);

-- Ελέγχει αν τα Υπουργεία έχουν ήδη δηλώσει τον προϋπολογισμό τους
CREATE TABLE isYpourgeiaPrepared (
    id INTEGER PRIMARY KEY,
    ypoyrgeia_prepared INTEGER DEFAULT 0
);

-- Αρχικοποίηση ως false (0)
INSERT INTO isYpourgeiaPrepared (id, ypoyrgeia_prepared) VALUES (1, 0);

-- Οι χρήστες της εφαρμογής
CREATE TABLE users (
    user_id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL,
    role TEXT NOT NULL CHECK(role IN ('PROTHYPOURGOS', 'PAIDEIA', 'YGEIA'))
);
