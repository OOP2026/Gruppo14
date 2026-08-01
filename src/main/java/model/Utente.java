package Progetto;

public class Utente {
	String nome;
	String cognome;
	String email;
	String login;
	String password;
		public Utente(String nome,String cognome,String email,String password) {
			this.nome=nome;
			this.cognome=cognome;
			this.email=email;
			this.password=password;
		// TODO Auto-generated constructor stub
	}
		String getNome() {
			return nome;
		}
		String getCognome() {
			return cognome;
		}
		String getEmail() {
			return email;
		}
		String getPassword() {
			return password;
		}
		void setNome(String nome) {
			this.nome=nome;
		}
		void setCognome(String cognome) {
			this.cognome=cognome;
		}
		void setEmail(String email) {
			this.email=email;
		}
		boolean login(String email,String login,String password) {
			if(this.email==email && this.login==login && this.password==password) {
				return true;
			}
			else {
				return false;
			}
		}
}
