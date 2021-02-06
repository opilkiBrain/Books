package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Objects.Database;


public class TheFrame extends JFrame{

    private Database db;
    private JPanel loginPanel;

    public TheFrame(Database db) {
        this.db = db;

    }
    public void displayFrame(){
        setTitle("Book Shop");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1000, 1000));

        JPanel conentPane = new JPanel();
        conentPane.setLayout(new CardLayout());
        loginPanel = new LoginPage(conentPane,db);
        conentPane.add(loginPanel, "Login");

        frame.setContentPane(conentPane);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

}
