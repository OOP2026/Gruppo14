package model;

import java.util.ArrayList;
import java.util.List;

public class Elenco {
    String nomeInsegnamento;
    int cfu;
    int anno;
    String docente_Titolare;
    List<String> auleDisp;

    public Elenco(String nomeInsegnamento, int cfu, int anno, String docenteTitolare, List<String> aule) {
        this.nomeInsegnamento = nomeInsegnamento;
        this.cfu = cfu;
        this.anno = anno;
        this.docente_Titolare = docenteTitolare;

        if (aule != null) {
            this.auleDisp = new ArrayList<>(aule);
        } else {
            this.auleDisp = new ArrayList<>(); //evita che la lista sia null
        }
    }

}
