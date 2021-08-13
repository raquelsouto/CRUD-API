package br.com.alura.forum.controller;

import br.com.alura.forum.service.SalarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SalarioController {

    @Autowired
    SalarioService salarioService;

    @PostMapping("/incrementaSalario")
    @ResponseBody
    public void aumentaSalario(@RequestParam Integer id) {
        salarioService.incrementaSalario(id);

    }
}
