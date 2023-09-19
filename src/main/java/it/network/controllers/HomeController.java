package it.network.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String renderIndex() {
        return "pages/home/index";
    }

    @GetMapping("/shop")
    public String renderShop() {
        return "pages/home/shop";
    }

}
