package GUI;

import Objects.Account;
import Objects.Database;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LoginPage extends JPanel {

    private JPanel contentPane;
    private Database db;

    public LoginPage(JPanel contentPane, Database db){
        this.contentPane = contentPane;
        this.db = db;

        JPanel logpanel = new JPanel();
        logpanel.setLayout(new GridLayout(4,1));
        add(logpanel);

        JPanel newWrapper = new JPanel();
        newWrapper.setLayout(new GridLayout(2,1));

        JButton loginButton = new JButton("log in");
        JLabel nameLabel = new JLabel("Username");
        JLabel passLabel = new JLabel("Password");
        JTextField nameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JLabel error = new JLabel("error");

        JButton newAccBut = new JButton("Create account");
        JLabel newAccLabel = new JLabel("Don't have an account?");
        newWrapper.add(newAccLabel);
        newWrapper.add(newAccBut);

        logpanel.add(nameLabel);
        logpanel.add(nameField);
        logpanel.add(passLabel);
        logpanel.add(passwordField);
        logpanel.add(loginButton);
        logpanel.add(newWrapper);
//        logpanel.add(newAccLabel);
//        logpanel.add(newAccBut);

        ArrayList<Account> accounts = db.getAccount();

        loginButton.addActionListener(e -> {
            boolean loginSucess = false;
            String username = nameField.getText();
            String password = new String(passwordField.getPassword());

            JPanel parent = (JPanel) getParent();
            CardLayout cardLayout = (CardLayout) parent.getLayout();
            parent.add(new CustomerPage(db),"Customer");
            parent.add(new EmployeePage(contentPane,db),"Employee");

            for (Account acc :
                    accounts) {
                if (username.equals(acc.getUsername()) && password.equals(acc.getPassword())){
                    if (acc.getUserType().equals("customer")){
                        cardLayout.show(parent,"Customer");
                        loginSucess = true;
                    }
                    else {
                        cardLayout.show(contentPane,"Employee");
                        loginSucess = true;
                    }
                }
            }
            if (!loginSucess){
                contentPane.add(error);
                nameField.setText("");
                passwordField.setText("");
            }
        });

        newAccBut.addActionListener(e -> {
            JPanel parent = (JPanel) getParent();
            CardLayout cardLayout = (CardLayout) parent.getLayout();
            parent.add(new NewAccount(db),"NewAccount");
            cardLayout.show(parent,"NewAccount");
        });
    }
    @Override
    public Dimension getPreferredSize(){
        return(new Dimension(1000,800));
    }
}
