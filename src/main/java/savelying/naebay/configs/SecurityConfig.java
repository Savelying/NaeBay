package savelying.naebay.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import savelying.naebay.services.CUDService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Password Encoding
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configuring HttpSecurity
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/", "/items", "/item/{id}", "/images/**", "/user/login", "/user/registry").permitAll()
                        .requestMatchers("/user/hello", "/item/**").authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/user/login")
                        .defaultSuccessUrl("/user/hello")
                        .permitAll()
                        .failureUrl("/user/login?error"))
                .logout(logout -> logout.logoutUrl("/user/logout")
                        .logoutSuccessUrl("/")
                        .permitAll());
        return http.build();
    }

    // User Creation
    @Bean
    public UserDetailsService userDetailsService() {
        return new CUDService();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}

