package GUI;

import Objects.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;

public class CustomerPage extends JPanel {


    private Database db;

    public CustomerPage(Database db){
        this.db = db;

        JPanel wrapperPanel = new JPanel();
        wrapperPanel.setLayout(new BoxLayout(wrapperPanel,BoxLayout.PAGE_AXIS));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        add(wrapperPanel, BorderLayout.CENTER);


        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());
        JPanel buttonWrapper = new JPanel(new GridLayout(1,3,4,4));

        JButton booksButton = new JButton("Books");
        buttonWrapper.add(booksButton);
        JButton depsButton = new JButton("Departments");
        buttonWrapper.add(depsButton);
        JButton profileButton = new JButton("Profile");
        buttonWrapper.add(profileButton);
        wrapperPanel.add(buttonWrapper, BorderLayout.CENTER);

        DefaultTableModel model = new DefaultTableModel();

        JTable booksTable = new JTable(model);
        JTableHeader header = booksTable.getTableHeader();
        header.setForeground(Color.white);
        JScrollPane scrollPane = new JScrollPane(booksTable);
        displayPanel.add(scrollPane);
        displayPanel.add(header,BorderLayout.NORTH);
        displayPanel.add(booksTable,BorderLayout.CENTER);

        booksButton.addActionListener(e -> {
            model.setRowCount(0);
            model.setColumnCount(0);
            model.addColumn("Book Title");
            model.addColumn("Author");
            model.addColumn("Genre");
            model.addColumn("Age Rating");

            int count = 0;
            ArrayList<Book> books = db.showBooks();
            for (Book book :
                    books) {
                model.insertRow(count, new Object[]{
                        book.getName(),
                        book.getAuthor(),
                        book.getGenre(),
                        book.getAgeRating()
                });
                count++;
            }
        });
        depsButton.addActionListener(e -> {
            model.setRowCount(0);
            model.setColumnCount(0);
            model.addColumn("Name");
            model.addColumn("Manager");
            model.addColumn("Number of Books");

            int count = 0;
            ArrayList<Department> departments = db.showDepartments();
            for (Department department :
                    departments) {
                model.insertRow(count, new Object[]{
                        department.getName(),
                        department.getEmployee(),
                        department.getNumberOfBooks()
                });
                count++;
            }
        });

        wrapperPanel.add(displayPanel,BorderLayout.EAST);
    }
    @Override
    public Dimension getPreferredSize(){
        return(new Dimension(500,1000));
    }


}
