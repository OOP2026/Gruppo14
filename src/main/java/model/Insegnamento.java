package Progetto;
import java.util.ArrayList;
import java.util.List;
public class Insegnamento {
public String nome;
public int numeroCFU;
public AnnoCorso annoCorso;
public Docente docenteTitolare;
public List<Orario> orari; 
/**
 * Costruttore della classe Insegnamento:
 * @param nome
 * @param numeroCFU
 * @param annoCorso
 * @param docenteTitolare
 * @param orari
 */
public Insegnamento(String nome,int numeroCFU,AnnoCorso annoCorso,Docente docenteTitolare,List<Orario> orari) {
	this.nome=nome;
	this.numeroCFU=numeroCFU;
	this.annoCorso=annoCorso;
	this.docenteTitolare=docenteTitolare;
}
/**
 * Restituisce il nome dell'insegnamento
 * @return nome
 */
public String getNome() {
	return nome;
}
/**
 * Restituisce il numero di CFU di un determinato insegnamento
 * @return numeroCFU
 */
public int getNumeroCFU() {
	return numeroCFU;
}
/**
 * Restituisce l'anno di corso (I,II,III) di un insegnamento
 * @return annoCorso
 */
public AnnoCorso getAnnoCorso() {
	return annoCorso;
}
/**
 * Restituisce il docente dell'insegnamento
 * @return docenteTitolare
 */
public Docente getDocenteTitolare() {
	return docenteTitolare;
}
/**
 * Restituisce l'insieme di orari a cui un insegnamento può appartenere
 * @return orari
 */
public List<Orario> getOrari() {
	return this.orari;
}
}
