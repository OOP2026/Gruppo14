package database_connection;
import java.sql.*;
import java.util.logging.Logger;
/**
 * Classe di connessione al database tramite la libreria java.sql. Usa 3 elementi fondamentali per la connessione:
 * 1. URL del database: fornire ad un'applicazione un indirizzo di rete per recuperare e raggiungere informazioni in un database
	 * 2. User del database: Identifica il nome utente del progettista del database;
	 * 3. Password del database: Password di accesso al database. Fondamentale per la sicurezza dei propri dati.
 */
public class ConnessioneDB {
	String url="jdbc:postgresql://localhost:5432/Progetto";
	String user="postgres";
	String password=System.getenv("DB_PASSWORD");
	private static final Logger LOGGER = Logger.getLogger(ConnessioneDB.class.getName());
	public static void main(String[]args) {//NOSONAR
		ConnessioneDB connessionePostgreSQL=new ConnessioneDB();
		connessionePostgreSQL.connect();
	}
	/**
	 * Metodo usato per connettersi al database.
	 */
private void connect() {
	try(Connection con=DriverManager.getConnection(url,user,password)){
		if(con!=null)
			LOGGER.info("Connessione riuscita al database!");
		else
			LOGGER.severe("Connessione fallita");
	}catch (SQLException e) {
        LOGGER.severe("Errore di connessione: " + e.getErrorCode());
        LOGGER.info("Stato di connessione: " + e.getSQLState());
    }	
	}
}
