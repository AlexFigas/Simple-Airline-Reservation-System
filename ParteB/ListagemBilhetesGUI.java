package tps.tp4.ParteB;

import org.apache.log4j.Logger;
import tps.tp4.ParteA.Bilhete;
import tps.tp4.ParteA.Membro;
import tps.tp4.ParteA.Voo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListagemBilhetesGUI extends JFrame {
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(PassageirosGUI.ListagemPassageirosGUI.class.getName());

    private JTable bilhetesPassageiroTable;
    private JButton backButton;
    private JPanel mainPanel;

    /**
     * Construtor
     */
    public ListagemBilhetesGUI() {
        this.setTitle("Lista de Bilhetes comprados");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(650, 700);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((dim.width - this.getWidth()) / 2, (dim.height - this.getHeight()) / 2);

        // Remover backgrounds
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.setOpaque(false);

        // Icones
        Image icon = Toolkit.getDefaultToolkit().getImage("src/imagens/appIcon.png");
        this.setIconImage(icon);
        backButton.setIcon(new ImageIcon("src/imagens/backButtonSmall.png"));


        backButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        log.info("ListagemBilhetesGUI criado");
    }

    /**
     * Método Main
     */
    public static void main(String[] args) {
        Voo v1 = new Voo("Origem", "Destino", 16, "12:50", 800);
        Voo v2 = new Voo("d", "a", 16, "12:50", 800);
        Membro m1 = new Membro(15, 12, "Nome");
        Membro m2 = new Membro(12, 12, "Alex");
        new Bilhete(v1, m1, 15);
        new Bilhete(v1, m1, 12);
        new Bilhete(v1, m1, 25);
        new Bilhete(v1, m1, 35);
        new Bilhete(v2, m2, 12);
        new Bilhete(v1, m1, 45);
        new Bilhete(v1, m1, 88);
        new Bilhete(v1, m1, 77);
        new Bilhete(v1, m1, 4);
        new Bilhete(v1, m1, 2);
        new Bilhete(v1, m1, 3);
        new Bilhete(v1, m1, 4);
        new Bilhete(v1, m2, 8);
        new Bilhete(v1, m2, 12);
        new Bilhete(v1, m2, 126);
        new Bilhete(v1, m2, 124);
        new Bilhete(v1, m2, 212);
        new Bilhete(v1, m2, 214);
        new ListagemBilhetesGUI();
    }

    /**
     * Cria a tabela.
     */
    private void createUIComponents() {
        // Tabela de Voos
        this.bilhetesPassageiroTable = new JTable();

        bilhetesPassageiroTable.setModel(new PassageirosGUI.ListagemPassageirosGUI.ModeloNaoEditavel(
                new Object[][]{},
                new String[]{"Numero do Voo", "Nome do Passsageiro", "Lugar"}
        ));
        DefaultTableModel vTable = (DefaultTableModel) bilhetesPassageiroTable.getModel();

        // Preencher a tabela
        for (Bilhete i : Bilhete.getListaBilhetes()) {
            vTable.addRow(new Object[]{i.getVoo().getNumeroVoo(), i.getPassageiro().getNome(), i.getLugar()});
        }
        bilhetesPassageiroTable.setFont(new Font("Arial", Font.PLAIN, 12));
    }
}
