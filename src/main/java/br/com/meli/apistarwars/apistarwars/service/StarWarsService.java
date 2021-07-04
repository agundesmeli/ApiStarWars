package br.com.meli.apistarwars.apistarwars.service;

import br.com.meli.apistarwars.apistarwars.entity.StarWars;
import br.com.meli.apistarwars.apistarwars.repository.StarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarWarsService {

    private final StarWarsRepository repository;

    public List<String> procurarNome(String palavra) {
        List<StarWars> starWarsList;
        List<String> starWarsRes = new ArrayList<>();
        starWarsList = repository.getList();
        for (StarWars s : starWarsList) {
            if (s.getName().contains(palavra)) {
                starWarsRes.add(s.getName());
            }
        }
        return starWarsRes;
    }

    public List<StarWars> listar(){
        return repository.getList();
    }

    @Autowired
    public StarWarsService(StarWarsRepository repository) {
        this.repository = repository;
    }
}
