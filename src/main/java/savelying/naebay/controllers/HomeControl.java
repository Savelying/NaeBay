package savelying.naebay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControl {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
