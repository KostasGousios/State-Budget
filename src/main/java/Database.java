import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    // Δημιουργεί τo SQLite database file 
    private static final String URL = "jdbc:sqlite:statebudget.db";

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        createAllTables(conn);
        return conn;
    }
    private static void createAllTables(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("PRAGMA foreign_keys = ON");
            //Δημιουργούνται οι πίνακες
            stmt.execute("CREATE TABLE IF NOT EXISTS ypourgeia (ypourgeio_id INTEGER PRIMARY KEY AUTOINCREMENT, onoma TEXT NOT NULL)");
            stmt.execute("CREATE TABLE IF NOT EXISTS logariasmoi (logariasmos_id INTEGER PRIMARY KEY AUTOINCREMENT, onoma TEXT NOT NULL, trexon_poso REAL DEFAULT 0, ypourgeio_id INTEGER NOT NULL, FOREIGN KEY (ypourgeio_id) REFERENCES ypourgeia(ypourgeio_id))");
            stmt.execute("CREATE TABLE IF NOT EXISTS pososta_logariasmon (pososto_id INTEGER PRIMARY KEY AUTOINCREMENT, pososto REAL NOT NULL, logariasmos_id INTEGER NOT NULL, FOREIGN KEY (logariasmos_id) REFERENCES logariasmoi(logariasmos_id))");
            stmt.execute("CREATE TABLE IF NOT EXISTS provlepomena (provlepomena_id INTEGER PRIMARY KEY AUTOINCREMENT, misthoi REAL NOT NULL, syntakseis REAL NOT NULL, loipa REAL NOT NULL, exoda_ypourgeia REAL NOT NULL, foroi REAL NOT NULL, daneia REAL NOT NULL, loipa_esoda REAL NOT NULL, tameio_arxiko REAL NOT NULL, ypourgeio_id INTEGER, FOREIGN KEY (ypourgeio_id) REFERENCES ypourgeia(ypourgeio_id))");
            stmt.execute("CREATE TABLE IF NOT EXISTS pragmatika_posa (kinisi_id INTEGER PRIMARY KEY AUTOINCREMENT, poso REAL NOT NULL, typos TEXT NOT NULL CHECK(typos IN ('ESODO','EXODO')), imerominia TEXT, ypourgeio_id INTEGER, logariasmos_id INTEGER, FOREIGN KEY (ypourgeio_id) REFERENCES ypourgeia(ypourgeio_id), FOREIGN KEY (logariasmos_id) REFERENCES logariasmoi(logariasmos_id))");
            stmt.execute("CREATE TABLE IF NOT EXISTS isYpourgeiaPrepared (ypourgeio_id INTEGER PRIMARY KEY, ypourgeia_prepared INTEGER DEFAULT 0)");
            stmt.execute("CREATE TABLE IF NOT EXISTS users (user_id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT UNIQUE NOT NULL, password TEXT NOT NULL, role TEXT NOT NULL CHECK(role IN ('PROTHYPOURGOS', 'PAIDEIA', 'YGEIA')))");
            //Αρχικόποιηση
            stmt.execute("INSERT OR IGNORE INTO isYpourgeiaPrepared (ypourgeio_id, ypourgeia_prepared) VALUES (1, 0)");
            stmt.execute("INSERT OR IGNORE INTO ypourgeia (onoma) VALUES ('ΥΠΟΥΡΓΕΙΟ ΠΑΙΔΕΙΑΣ'), ('ΥΠΟΥΡΓΕΙΟ ΥΓΕΙΑΣ')");
        }
    }
}
