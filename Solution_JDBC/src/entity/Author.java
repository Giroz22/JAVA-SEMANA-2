package entity;

public class Author {
    //Attributes
    private int id;
    private String name;
    private String nationality;

    //Constructors
    public Author() {
    }

    public Author(int id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }

    public Author(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    //Methods
    //Setters and Getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getnationality() {
        return nationality;
    }

    public void setnationality(String nationality) {
        this.nationality = nationality;
    }

    //To String
    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
