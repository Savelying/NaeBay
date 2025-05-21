package savelying.naebay.dto;

import savelying.naebay.models.Image;
import savelying.naebay.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ItemDTO {
    private long id;
    private String title;
    private String description;
    private String city;
    private int price;
    private LocalDate date;

    private User user;

    private List<Image> images = new ArrayList<>();

    private void prePersist() {
        this.date = LocalDate.now();
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public void addImageToItem(Image image) {
//        image.setItem(this);
//        images.add(image);
//    }

    public List<Image> getImagesDTO() {
        return images;
    }

    public long getImagePreview() {
        return images.getFirst().getId();
    }
}
