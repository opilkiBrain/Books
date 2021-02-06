package Objects;

public class Account {

    private String username;
    private String password;
    private String userType;
    private Database db;

    public Account(String username, String password, String userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public Account(String username, String password, String userType, Database db) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.db = db;
        this.addAccount();
    }

    private boolean addAccount(){
        String query = "INSERT INTO account(username, password, type)"+
                "VALUES"+
                "('" + this.username+"','" + this.password+"','" + this.userType + "');";
        return db.execute(query);
    }

    public String showContent(){
        return "SELECT id, bookname, author, genre from books";
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
