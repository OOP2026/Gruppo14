package GUI;

import controller.Controller;
import Progetto.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class OrarioFrame extends JFrame {

    private Controller controller;

    public OrarioFrame(Controller controller) {
        this.controller = controller;

        setTitle("Orario Lezioni");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Chiude solo questa finestra, non l'intera app
        setLayout(new BorderLayout());

        // Intestazioni della tabella
        String[] colonne = {"Materia", "Docente", "Giorno", "Ora Inizio", "Ora Fine", "Aula"};
        
        // Modello tabella non modificabile
        DefaultTableModel tableModel = new DefaultTableModel(colonne, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Recupera l'orario tramite il controller e popola le righe
        // (Adatta i getter in base alla tua classe Orario / Lezione)
        Utente u = controller.getUtenteLoggato();
        if (u instanceof Studente) {
            Orario orario = controller.getOrarioStudente((Studente) u);
            if (orario != null && orario.getLezioni() != null) {
                for (Lezione l : orario.getLezioni()) {
                    Object[] riga = {
                        l.getInsegnamento().getNomeIns()+" "+l.getInsegnamento().getCFU()+" CFU",l.getDocente().getNome()+" "+
                        l.getDocente().getCognome(),
                        l.getGiorno(),
                        l.getOraInizio(),
                        l.getOraFine(),
                        l.getAula().getNomeAula()
                    };
                    tableModel.addRow(riga);
                }
            }
        }

        JTable tabellaOrario = new JTable(tableModel);
        tabellaOrario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabellaOrario.getColumnModel().getColumn(0).setPreferredWidth(200);
        tabellaOrario.getColumnModel().getColumn(1).setPreferredWidth(150);
        tabellaOrario.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabellaOrario.getColumnModel().getColumn(3).setPreferredWidth(80);
        tabellaOrario.getColumnModel().getColumn(4).setPreferredWidth(80);
        tabellaOrario.getColumnModel().getColumn(5).setPreferredWidth(100);
        JScrollPane scrollPane = new JScrollPane(tabellaOrario);
        add(scrollPane, BorderLayout.CENTER);

        // Bottone per chiudere la schermata e tornare alla Dashboard
        JButton btnChiudi = new JButton("Torna alla Dashboard");
        btnChiudi.addActionListener(e -> dispose());
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btnChiudi);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
