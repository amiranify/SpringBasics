package ru.netology;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller

public class MainController {
    @GetMapping(value = "/greeting")//http://localhost:8080/greeting
    public String greeting(@RequestParam(required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss  zzz");
        String data = dateFormat.format(date);
        String time = timeFormat.format(date);
        model.addAttribute("data", data);
        model.addAttribute("time", time);
        return "greeting";
    }
}
