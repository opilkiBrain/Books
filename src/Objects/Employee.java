package Objects;

public class Employee {

    private String username;
    private String firstName;
    private String lastName;
    private Database db;

    public Employee(String username, String firstName, String lastName, Database db) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.db = db;
        this.addEmployee();
    }

    private boolean addEmployee(){
        String query = "INSERT INTO employee(username, firstname, lastname)"+
                "VALUES"+
                "('" + this.username+"','" + this.firstName+"','" + this.lastName+ "');";
        return db.execute(query);
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}