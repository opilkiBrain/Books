package Objects;

public class Book {

    private String name;
    private String author;
    private String genre;
    private Database db;
    private String ageRating;

    public Book(String name, String author, String genre,String ageRating){
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.ageRating = ageRating;
    }

    public Book(String name, String author, String genre,String ageRating, Database db){
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.ageRating = ageRating;
        this.db = db;
        this.addBook();
    }

    private boolean addBook(){
        String query = "INSERT INTO books(bookname, author, genre)"+
                "VALUES"+
                "('" + this.name+"','" + this.author+"','" + this.genre + "');";
        return db.execute(query);
    }

//    public boolean bookToDB(){
//        return db.execute(addBook());
//    }

    public String showContent(){
        return "SELECT id, bookname, author, genre from books";
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", ageRating='" + ageRating + '\'' +
                '}';
    }

    public String getAgeRating() {
        return ageRating;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }
}
