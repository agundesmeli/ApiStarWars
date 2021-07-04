package br.com.meli.apistarwars.apistarwars.repository;

import br.com.meli.apistarwars.apistarwars.entity.StarWars;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StarWarsRepository {

    private static final File FILE = new File("starwars.json");
    @Autowired
    private ObjectMapper mapper;

    public List<StarWars> getList(){
        List<StarWars> starwars = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<StarWars>> typeReference = new TypeReference<List<StarWars>>() {};
            starwars = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return starwars;
    }
    

}
