package savelying.naebay.models.enums;


import org.springframework.security.core.GrantedAuthority;

public enum Rule implements GrantedAuthority {
    ROLE_USER, ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
