package com.optare.swapi.planets.manager;

import com.optare.swapi.planets.entities.Planet;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PlanetsManager {

    public Planet getPlanet(String url) {
        if (url==null || url.isEmpty()){
            return null;
        }
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Planet> response = restTemplate.getForEntity(url, Planet.class);
        return response.getBody();
    }
}