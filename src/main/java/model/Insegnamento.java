package model;

public class Insegnamento {
    private String nomeInsegnamento;
    private int numeroCFU;
    private int annoCorso;
    private String docenteTitolare;

    public Insegnamento(String nomeInsegnamento, int numeroCFU, int annoCorso, String docenteTitolare) {
        this.nomeInsegnamento = nomeInsegnamento;
        this.numeroCFU = numeroCFU;
        this.annoCorso = annoCorso;
        this.docenteTitolare = docenteTitolare;
    }

    public boolean isAttivo() {
        return true;
    }

    // Getter e Setter
    public String getNomeInsegnamento() { return nomeInsegnamento; }
    public void setNomeInsegnamento(String nomeInsegnamento) { this.nomeInsegnamento = nomeInsegnamento; }
    public int getNumeroCFU() { return numeroCFU; }
    public void setNumeroCFU(int numeroCFU) { this.numeroCFU = numeroCFU; }
    public int getAnnoCorso() { return annoCorso; }
    public void setAnnoCorso(int annoCorso) { this.annoCorso = annoCorso; }
    public String getDocenteTitolare() { return docenteTitolare; }
    public void setDocenteTitolare(String docenteTitolare) { this.docenteTitolare = docenteTitolare; }
}