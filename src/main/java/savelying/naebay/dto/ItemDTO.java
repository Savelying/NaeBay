package savelying.naebay.dto;

import jakarta.validation.constraints.NotNull;
import savelying.naebay.models.Image;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ItemDTO {
    private long id;
    @NotNull(message = "Title must be not empty")
    private String title;
    private String description;
    @NotNull(message = "City must be not empty")
    private String city;
    @NotNull(message = "Price must be not empty")
    private int price;
    private LocalDate date;

    private UserDTO user;

    private List<Image> imagesDTO = new ArrayList<>();

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

    public UserDTO getUser() {
        return user;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.user = userDTO;
    }

    public List<Image> getImagesDTO() {
        return imagesDTO;
    }

    public void setImagesDTO(List<Image> imagesDTO) {
        this.imagesDTO = imagesDTO;
    }

    public long getImagePreviewDTO() {
        return imagesDTO.getFirst().getId();
    }
}
