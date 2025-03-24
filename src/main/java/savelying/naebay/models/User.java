package savelying.naebay.models;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import savelying.naebay.models.enums.Rule;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String phone;
    private boolean active;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ava")
    private Image avatar;
    @Column(length = 1000)
    private String password;
    private LocalDate date;
    @ElementCollection(targetClass = Rule.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "role", joinColumns = @JoinColumn(name = "id"))
    @Enumerated(EnumType.STRING)
    private Set<Rule> rules = new HashSet<>();

    @PrePersist
    private void prePersist() {
        date = LocalDate.now();
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Rule> getRules() {
        return rules;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Security
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return rules;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
