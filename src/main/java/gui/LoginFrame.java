package GUI;

import controller.Controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
public class LoginFrame extends JFrame {
	private JLabel labelEmail;
    private JTextField txtEmail;
    private JLabel labelPassword;
    private JPasswordField txtPassword;
    private JLabel labelLogin;
    private JTextField txtLogin;
    private JButton btnLogin;
    private JPanel mainPanel;

    private Controller controller; // Riferimento al controller
/**
 * Costruttore della classe LoginFrame usato per visualizzare la finestra di autenticazione al sistema degli orari e lezioni
 * @param controller
 */
    public LoginFrame(Controller controller) {
        this.controller = controller;
        mainPanel=new JPanel(new GridBagLayout());
        setContentPane(mainPanel);
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(5,5,5,5);
        gbc.fill=GridBagConstraints.HORIZONTAL;
        btnLogin=new JButton("Login");
        labelEmail=new JLabel("Email:");
        txtEmail=new JTextField(50);
        labelPassword=new JLabel("Password:");
        txtPassword=new JPasswordField(50);
        labelLogin=new JLabel("Login(Username):");
        txtLogin=new JTextField(50);
        setTitle("Login Sistema Orari");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        /**
         *  Listener del pulsante Login
         */
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = new String(txtEmail.getText()).trim();
                String pass = new String(txtPassword.getPassword()).trim();
                String login=new String(txtLogin.getText()).trim();

                // Chiamata al Controller
                if (controller.Login(email, login,pass)) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Login effettuato con successo!");
                    
                    // Apri la dashboard principale e chiudi il login
                    // new DashboardFrame(controller).setVisible(true);
                    new DashBoardFrame(controller).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Credenziali errate!", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        /**
         * GBC Serve a posizionare, in una griglia, le componenti GUI necessarie del sistema
         */
        gbc.gridx=0;
        gbc.gridy=0;
        mainPanel.add(labelEmail,gbc);
        gbc.gridx=1;
        gbc.gridy=0;
        mainPanel.add(txtEmail,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        mainPanel.add(labelLogin,gbc);
        gbc.gridx=1;
        gbc.gridy=1;
        mainPanel.add(txtLogin,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        mainPanel.add(labelPassword,gbc);
        gbc.gridx=1;
        gbc.gridy=2;
        mainPanel.add(txtPassword,gbc);
        gbc.gridx=1;
        gbc.gridy=3;
        mainPanel.add(btnLogin,gbc);
        
    }
}
