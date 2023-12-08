package reseau;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Serveur implements ActionListener {

    private ServerSocket serverSocket;
    private Transaction transactions;
    private SynchList outputs;
    private int port_number = 0;
    private static ArrayList<String> online_users;
    private JFrame window;
    private JPanel cover;
    private JLabel labels_port;
    private JTextField port;
    private JButton run;

    public Serveur() {
        runPanel();
    }

    public void runPanel() {

        window = new JFrame("Server Config");
        cover = new JPanel();
        cover.setLayout(null); 
        port = new JTextField();
        port.setBounds(60, 60, 400, 40);
        port.addActionListener(this);
        port.setText("5000");
        labels_port = new JLabel("numero de port?");
        labels_port.setBounds(60, 30, 400, 40);
        run = new JButton("lancer");
        run.setBounds(200, 100, 100, 50);
        run.addActionListener(this);
        cover.add(run);
        cover.add(port);
        cover.add(labels_port);
        window.add(cover);
        window.setResizable(false);
        window.setSize(500, 250);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
    
    public void runServer() {
        try {
            System.out.println("ca marche pour : "+port_number);
            if (port_number > 0) {
                serverSocket = new ServerSocket(port_number);
                outputs = new SynchList();
                online_users = new ArrayList<String>();
                online_users.add("Everyone");
            }
            while (true) {
                transactions = new Transaction(outputs.size(), outputs,online_users ,serverSocket.accept());
                System.out.println("le serveur est a l'ecoute sur le port "+port_number +".....");
                transactions.start();
                System.out.println("un client a rejoins");
            }
        } catch (Exception i) {
            System.out.println("echec " + i);
        }
    }

    public static void main(String[] args) {

        new Serveur();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == run && port.getText().length() < 1) {
            JOptionPane.showMessageDialog(null, "Un numéro de port doit être saisi !");
        }
        if (e.getSource() == run && port.getText().length() > 0) {

            port_number = Integer.parseInt(port.getText());
            JOptionPane.showMessageDialog(null,
                    "Le serveur écoute maintenant en arrière-plan sur le port " + port_number);
            runServer();
            window.setState(Frame.ICONIFIED);
        }
    }
}
