package ru.catinasw.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String hello(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname,
            Model model
    ) {
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(
            @RequestParam("a") int a,
            @RequestParam("b") int b,
            @RequestParam("action") String action,
            Model model
    ) {
        double result;
        switch (action) {
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = (double)a / b;
                break;
            default:
                throw new IllegalArgumentException("Invalid action");
        }

        model.addAttribute("calcResult", result);
        return "first/calculator";
    }
}
