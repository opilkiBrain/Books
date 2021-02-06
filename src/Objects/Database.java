package Objects;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Database {

    private Connection con;
    Thread closeConThread;
    private String host = "";
    private String user = "";
    private String password = "";

    public Database(){

        closeConThread = new Thread(this::closeConnection);
        Runtime.getRuntime().addShutdownHook(closeConThread);

        try{
            con = DriverManager.getConnection(
                    host,
                    user,
                    password
            );
            System.out.println("connection established");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try{
            con.close();
            System.out.println("connection closed");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean executeBatch(String[] query){
        Statement statement;
        boolean success = true;
        try{
            con.setAutoCommit(false);
            statement = con.createStatement();
            for (String q :
                    query) {
                statement.execute(q);
            }
            con.commit();
            con.setAutoCommit(true);

        }
        catch (Exception e){
            e.printStackTrace();
            success = false;
        }
        return success;
    }
    public boolean execute(String query){
        return executeBatch(new String[]{query});
    }

    public ArrayList<Book> showBooks(){
        String query = "SELECT id, bookname, author, genre, ageRating from books";
        ArrayList<Book> books = new ArrayList<>();
        try{
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String name = resultSet.getString("bookname");
                String author = resultSet.getString("author");
                String genre = resultSet.getString("genre");
                String age = resultSet.getString("ageRating");
                books.add(new Book(name,author,genre, age));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return books;
    }

    public ArrayList<Department> showDepartments(){
        String query = "SELECT name, manager, booksnum from departments";
        ArrayList<Department> deps = new ArrayList<>();
        try{
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String author = resultSet.getString("manager");
                int booksum = resultSet.getInt("booksnum");
                deps.add(new Department(name,author,booksum));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return deps;
    }

    public ArrayList<Customer> showCustomers(){
        String query = "SELECT username, firstname, surname, age,favgenres from customer";
        ArrayList<Customer> customers = new ArrayList<>();
        try{
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String username = resultSet.getString("username");
                String firstname = resultSet.getString("firstname");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                String genres =  resultSet.getString("favgenres");
                ArrayList<String> favgenres = new ArrayList<>(Arrays.asList(genres.split(",")));
                customers.add(new Customer(username,firstname,surname,age,favgenres));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return customers;
    }

    public ArrayList<Account> getAccount() {
        String query = "SELECT username, password, type from account";
        ArrayList<Account> accounts = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String userType = resultSet.getString("type");
                accounts.add(new Account(username, password, userType));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }
}
