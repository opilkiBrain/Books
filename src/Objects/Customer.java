package Objects;

import java.util.ArrayList;

public class Customer {

    private String username;
    private String firstName;
    private String surname;
    private int age;
    private ArrayList<String> favGenres;
    private Database db;

    public Customer(String username, String firstName, String surname, int age, ArrayList<String> favGenres,Database db) {
        this.username = username;
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
        this.favGenres = favGenres;
        this.db = db;
        this.addCustomer();
    }

    public Customer(String username, String firstName, String surname, int age, ArrayList<String> favGenres) {
        this.username = username;
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
        this.favGenres = favGenres;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    private boolean addCustomer(){
        String query = "INSERT INTO customer(username, firstname, surname,age, favgenres)"+
                "VALUES"+
                "('" + this.username+"','" + this.firstName+"','" + this.surname + "',"
                + this.age +",'"+this.favGenres+"');";
        return db.execute(query);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", favGenres=" + favGenres +
                '}';
    }

    public int getAge() {
        return age;
    }

    public ArrayList<String> getFavGenres() {
        return favGenres;
    }
}
