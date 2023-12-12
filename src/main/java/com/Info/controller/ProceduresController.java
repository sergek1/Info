package com.Info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/procedure")
public class ProceduresController {

    @GetMapping()
    public String save_Data() throws IOException {
        return "procedures";
    }
}
