package entity;

public class Book {
    //Attributes
    private int id;
    private String tittle;
    private int year_of_publication;
    private double price;
    private int id_author;

    //Constructors
    public Book() {
    }

    public Book(int id, String tittle, int year_of_publication, double price, int id_author) {
        this.id = id;
        this.tittle = tittle;
        this.year_of_publication = year_of_publication;
        this.price = price;
        this.id_author = id_author;
    }

    public Book(String tittle, int year_of_publication, double price, int id_author) {
        this.tittle = tittle;
        this.year_of_publication = year_of_publication;
        this.price = price;
        this.id_author = id_author;
    }

    //Methods
    //Setters and Getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public int getyear_of_publication() {
        return year_of_publication;
    }

    public void setyear_of_publication(int year_of_publication) {
        this.year_of_publication = year_of_publication;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId_author() {
        return id_author;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
    }

    //To String
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", year_of_publication=" + year_of_publication +
                ", price=" + price +
                '}';
    }
}
