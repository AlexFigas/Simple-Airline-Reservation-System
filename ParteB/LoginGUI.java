package tps.tp4.ParteB;

import org.apache.log4j.Logger;
import tps.tp4.ParteA.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author Alexandre Figueiredo A48577 21D-A
 * @version 1.00
 */
public class LoginGUI extends JFrame {
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(LoginGUI.class.getName());

    private JPanel mainPanel;
    private JButton loginButton;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private JButton registerButton;
    private JCheckBox mostrarPasswordCheckBox;
    private JLabel loginImage;

    /**
     * Construtor
     */
    public LoginGUI() {
        this.setTitle("Iniciar Sessão");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(720, 300);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((dim.width - this.getWidth()) / 2, (dim.height - this.getHeight()) / 2);

        // Remover backgrounds
        loginButton.setBorderPainted(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setFocusPainted(false);
        loginButton.setOpaque(false);
        registerButton.setBorderPainted(false);
        registerButton.setContentAreaFilled(false);
        registerButton.setFocusPainted(false);
        registerButton.setOpaque(false);

        // Icones
        Image icon = Toolkit.getDefaultToolkit().getImage("src/imagens/appIcon.png");
        this.setIconImage(icon);
        loginButton.setIcon(new ImageIcon("src/imagens/loginButton.png"));
        registerButton.setIcon(new ImageIcon("src/imagens/registerButton.png"));
        loginImage.setIcon(new ImageIcon("src/imagens/loginImage.png"));

        loginButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameText.getText();
                char[] chars = passwordText.getPassword();
                String password = String.valueOf(chars);
                usernameText.setText("");
                passwordText.setText("");
                if (Login.equals(username, password)) {
                    JOptionPane.showMessageDialog(null, "Sucesso!");
                    dispose();
                    new MenuGUI();
                    log.info("Login bem sucedido!");
                } else {
                    JOptionPane.showMessageDialog(null, "Insucesso!");
                    log.info("Login negado!");
                }
            }
        });
        registerButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameText.getText();
                char[] chars = passwordText.getPassword();
                String password = String.valueOf(chars);
                int input = JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende criar " +
                        "um novo registo?", "Registar", JOptionPane.YES_NO_OPTION);
                if (input == 0) {
                    new Login(username, password);
                    JOptionPane.showMessageDialog(null, "Criado!");
                    log.info("Registo criado!");
                    usernameText.setText("");
                    passwordText.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Cancelado!");
                }
            }
        });
        mostrarPasswordCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mostrarPasswordCheckBox.isSelected()) {
                    log.info("Mostar password ligado");
                    passwordText.setEchoChar((char) 0);
                } else {
                    log.info("Mostar password desligado");
                    passwordText.setEchoChar('*');
                }
            }
        });
    }

    /**
     * Método main
     */
    public static void main(String[] args) {
        new Login("Alexandre", "Fazenda");

        Passageiro p1 = new Membro(14, 76, "Gabriela Pereira Lima");
        Passageiro p2 = new Membro(38, 72, "Leila Gomes Barros");
        Passageiro p3 = new Membro(2, 20, "Agatha Lima Azevedo");
        Passageiro p4 = new NaoMembro(46, "Leonardo Almeida Fernandes");
        Passageiro p5 = new NaoMembro(19, "Nicole Santos Sousa");

        Voo v1 = new Voo("Amsterdam", "Malaga", 1900, "19:05", 189);
        Voo v2 = new Voo("Amsterdam", "Miami", 7466, "09:15", 660);
        Voo v3 = new Voo("Taipei", "San Francisco", 10414, "19:40", 297);

        p1.comprar(v1);
        p4.comprar(v1);
        p2.comprar(v2);
        p3.comprar(v2);
        p5.comprar(v2);
        p1.comprar(v3);

        new LoginGUI();
    }
}
