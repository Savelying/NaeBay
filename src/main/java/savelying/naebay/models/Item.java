package savelying.naebay.models;

public class Item {
    private long id;
    private String title, description, city, author;
    private int price;

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

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
