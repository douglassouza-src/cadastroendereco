package com.example.projetospringmvc_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CepService cepService;

    @GetMapping("/")
    public String index(Model model) {
        List<String> items = new ArrayList<>();
        items.add("Servidor rodando na porta 8080");

        model.addAttribute("items", items);
        return "index"; 
    }

    @GetMapping("/cep")
    @ResponseBody
    public AddressResponse getAddressByCep(@RequestParam String cep) {
        return cepService.getAddressByCep(cep);
    }
}
