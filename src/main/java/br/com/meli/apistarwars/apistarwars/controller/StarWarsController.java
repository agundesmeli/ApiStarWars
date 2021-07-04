package br.com.meli.apistarwars.apistarwars.controller;

import br.com.meli.apistarwars.apistarwars.entity.StarWars;
import br.com.meli.apistarwars.apistarwars.repository.StarWarsRepository;
import br.com.meli.apistarwars.apistarwars.service.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {

    @Autowired
    private StarWarsService starWarsService;

    @RequestMapping("/{palavra}")
    public List<String> obterNome(@PathVariable String palavra) {
        return starWarsService.procurarNome(palavra);
    }


}
