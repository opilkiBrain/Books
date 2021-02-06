package GUI;

import Objects.Account;
import Objects.Customer;
import Objects.Database;
import Objects.Employee;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NewAccount extends JPanel {

    private Database db;

    public NewAccount(Database db){
        this.db = db;

        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper,BoxLayout.Y_AXIS));

        JPanel input = new JPanel();
        input.setLayout(new GridLayout(8,1,5,5));

        input.add(new JLabel("Username"));
        JTextField username = new JTextField();
        username.setPreferredSize(new Dimension(100,20));
        input.add(username);

        input.add(new JLabel("Fist name"));
        JTextField firstName = new JTextField();
        username.setPreferredSize(new Dimension(100,20));
        input.add(firstName);

        input.add(new JLabel("Last name"));
        JTextField lastName = new JTextField();
        username.setPreferredSize(new Dimension(100,20));
        input.add(lastName);

        input.add(new JLabel("Passowrd"));
        JTextField password = new JTextField();
        username.setPreferredSize(new Dimension(100,20));
        input.add(password);

        input.add(new JLabel("Age"));
        JTextField age = new JTextField();
        username.setPreferredSize(new Dimension(100,20));
        input.add(age);

        JLabel typeL = new JLabel("Type of account");
        JComboBox typeBox = new JComboBox();
        typeBox.addItem("customer");
        typeBox.addItem("employee");
        input.add(typeL);
        input.add(typeBox);

        JPanel genresOption = new JPanel();
        genresOption.setLayout(new GridLayout(2,2));
        JCheckBox philosophy = new JCheckBox("Philosophy");
        JCheckBox classics = new JCheckBox("Classics");
        JCheckBox fantasy = new JCheckBox("Fantasy");
        JCheckBox engineering = new JCheckBox("Engineering");
        genresOption.add(philosophy);
        genresOption.add(classics);
        genresOption.add(fantasy);
        genresOption.add(engineering);
        input.add(new JLabel("Check genres"));
        input.add(genresOption);


        JButton newAcc = new JButton("Create Account");
        input.add(newAcc);

        newAcc.addActionListener(e -> {
            String user = username.getText();
            String pass = password.getText();
            String accType = (String) typeBox.getSelectedItem();
            Account account = new Account(user,pass,accType,db);
            String first = firstName.getText();
            String last = lastName.getText();
            int userAge = Integer.parseInt(age.getText());

            ArrayList<String> genres =  new ArrayList<>();
            Component[] components = genresOption.getComponents();
            for (Component cmp :
                    components) {
                if(cmp instanceof JCheckBox){
                    JCheckBox box = (JCheckBox) cmp;
                    if(box.isSelected()){
                        genres.add(box.getText());
                    }
                }
            }
            if (accType.equals("customer")){
                Customer customer = new Customer(user,first,last,userAge,genres,db);
            }
            else{
                Employee employee = new Employee(user,first,last,db);
            }
        });

        wrapper.add(input);
        add(wrapper);

    }
}
