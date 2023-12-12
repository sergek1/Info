package com.Info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/main")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/")
    public String mainPageTwo() {
        return "index";
    }

    @GetMapping("/all_tables")
    public String allTables() {
        return "all_tables";
    }

    @GetMapping("/procedures")
    public String allProcedures() {
        return "procedures";
    }

}
