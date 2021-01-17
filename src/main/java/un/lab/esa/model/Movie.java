package un.lab.esa.model;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(schema = "public", name="MOVIE")
public class Movie {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private double price;

    @Column(name="year")
    private  int year;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "MOVIE_DIRECTOR",
            joinColumns = {@JoinColumn(name = "ID_MOVIE")},
            inverseJoinColumns = {@JoinColumn(name = "ID_DIRECTOR")})
    Collection<Director> directors;

    public Movie() {
    }

    public Movie(int id, String title, double price, int year){
        this.id = id;
        this.title = title;
        this.price = price;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public Collection<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Collection<Director> directors) {
        this.directors = directors;
    }

}
