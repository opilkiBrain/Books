package GUI;

import Objects.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EmployeePage extends JPanel {

    private JPanel topPanel;
    private Database db;

    public EmployeePage (JPanel topPanel,Database db){
        this.topPanel = topPanel;
        this.db = db;

        JTextArea textArea = new JTextArea();
        ArrayList<Customer> customers = db.showCustomers();
        for (Customer customer :
                customers) {
            textArea.append(customer.getFirstName()+"\n");
        }
        add(textArea);
    }
    @Override
    public Dimension getPreferredSize(){
        return(new Dimension(500,1000));
    }


}
