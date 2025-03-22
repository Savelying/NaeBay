package savelying.naebay.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "Area should not be empty")
    private String title, city, author;
    @NotEmpty(message = "Area should not be empty")
    @Column(columnDefinition = "text")
    private String description;
    @NotNull(message = "Enter the digital number")
    private int price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "item")
    private final List<Image> images = new ArrayList<>();
    private LocalDate date;

    @PrePersist
    private void init() {
        date = LocalDate.now();
    }

    public void addImageToItem(Image image) {
            image.setItem(this);
            images.add(image);
    }

    public Item(long id, String title, String description, String city, String author, int price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.city = city;
        this.author = author;
        this.price = price;
    }

    public Item(String title, String description, String city, String author, int price) {
        this.title = title;
        this.description = description;
        this.city = city;
        this.author = author;
        this.price = price;
    }

    public Item() {
    }

    public long getId() {
        return id;
    }

//    public void setId(long id) {
//        this.id = id;
//    }

    public String getTitle() {
        return title;
    }

//    public void setTitle(String title) {
//        this.title = title;
//    }

    public String getDescription() {
        return description;
    }

//    public void setDescription(String description) {
//        this.description = description;
//    }

    public String getCity() {
        return city;
    }

//    public void setCity(String city) {
//        this.city = city;
//    }

    public String getAuthor() {
        return author;
    }

//    public void setAuthor(String author) {
//        this.author = author;
//    }

    public int getPrice() {
        return price;
    }

//    public void setPrice(int price) {
//        this.price = price;
//    }

    public List<Image> getImages() {
        return images;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
