package Objects;

public class Department {

    private String name;
    private String employee;
    private int numberOfBooks;
    private Database db;

    public Department(String name, String employee, int numberOfBooks) {
        this.name = name;
        this.employee = employee;
        this.numberOfBooks = numberOfBooks;
    }

    public Department(String name, String employee, int numberOfBooks, Database db) {
        this.name = name;
        this.employee = employee;
        this.numberOfBooks = numberOfBooks;
        this.db = db;
        this.addToDB();
    }

    private String addDepartment(){
        return "INSERT INTO departments(name, employee, booksnum)"+
                "VALUES"+
                "('" + this.name+"','" + this.employee+"'," + this.numberOfBooks + ");";
    }

    private boolean addToDB(){
        return db.execute(addDepartment());
    }

    public String showContent(){
        return "SELECT name, employee, booksnum from departments";
    }

    public String getName() {
        return name;
    }

    public String getEmployee() {
        return employee;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", employee='" + employee + '\'' +
                ", numberOfBooks=" + numberOfBooks +
                '}';
    }
}
