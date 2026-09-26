package model;

public class Utente {
	String nome;
	String cognome;
	String email;
	String login;
	String password;
	/**
	 * Costruttore della classe Utente:
	 * @param nome
	 * @param cognome
	 * @param email
	 * @param login
	 * @param password
	 */
		public Utente(String nome,String cognome,String email,String login,String password) {
			this.nome=nome;
			this.cognome=cognome;
			this.email=email;
			this.login=login;
			this.password=password;
	}
		/**
		 * Restituisce il nome dell'utente
		 * @return nome
		 */
		public String getNome() {
			return nome;
		}
		/**
		 * Restituisce il cognome dell'utente
		 * @return cognome
		 */
		public String getCognome() {
			return cognome;
		}
		/**
		 * Restituisce l'email dell'utente
		 * @return email
		 */
		public String getEmail() {
			return email;
		}
		/**
		 * Restituisce la password dell'utente
		 * @return password
		 */
		public String getPassword() {
			return password;
		}
		/**
		 * Permette ad un utente generico di autenticarsi nel sistema, confrontando le credenziali immesse nel metodo con quelle che ha impostato inizialmente nel costruttore
		 * @param email
		 * @param login
		 * @param password
		 * @return true o false, per accettare o rifiutare l'autenticazione
		 */
		public boolean login(String email,String login,String password) {
			return this.email.equals(email) && this.login.equals(login) && this.password.equals(password); 
		}
		/**
		 * Ottiene il login(username) dell'utente
		 * @return login
		 */
		public String getLogin() {
			return login;
		}
		/**
		 * Imposta un nuovo username all'utente
		 * @param login
		 */
		public void setLogin(String login) {
			this.login = login;
		}
		
}


