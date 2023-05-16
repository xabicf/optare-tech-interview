package com.optare.swapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SpeciesController {

    @Autowired
    private SpeciesManager speciesManager;

    @ResponseBody
    @GetMapping("/api/species/")
    public SpeciesWithPlanet[] getSpecies() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SpeciesResponse> response = restTemplate.getForEntity("https://swapi.dev/api/species/", SpeciesResponse.class);
        SpeciesWithPlanet[] speciesResponse = speciesManager.getPlanetsAndTranform(response.getBody());
        return speciesResponse;
    }
}