package savelying.naebay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import savelying.naebay.models.Image;
import savelying.naebay.models.Item;
import savelying.naebay.models.Role;

import java.time.LocalDate;
import java.util.*;

public class UserDTO {
    private long id;
    @NotNull(message = "Name must be not empty")
    private String name;
    @NotNull(message = "Email must be not empty")
    @Email(message = "Please, enter valid email!")
    private String email;
    private String phone;
    private boolean active;
    private Image ava;
    @NotNull(message = "Password must be not empty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private LocalDate date;

    public UserDTO() {
    }

    private Set<Role> roles = new HashSet<>();

    private List<Item> items = new ArrayList<>();

    public boolean isAdmin() {
        return roles.contains(Role.ROLE_ADMIN);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Image getAva() {
        return ava;
    }

    public void setAva(Image ava) {
        this.ava = ava;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
