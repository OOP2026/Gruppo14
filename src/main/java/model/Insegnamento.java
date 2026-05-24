package Progetto;

public class Insegnamento {
	String nomeInsegnamento;
	int numeroCFU;
	int annoCorso;
	String docenteTitolare;
	boolean attivo;
	public Insegnamento(String nomeInsegnamento,int numeroCFU,int annoCorso,String docenteTitolare,boolean attivo) {
		this.nomeInsegnamento=nomeInsegnamento;
		this.numeroCFU=numeroCFU;
		this.annoCorso=annoCorso;
		this.docenteTitolare=docenteTitolare;
		this.attivo=attivo;
	}
	boolean isAttivo() {
		return this.attivo;
	};
}
