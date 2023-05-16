package com.optare.swapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpeciesManager {

    @Autowired
    private PlanetsManager planetsManager;

    public SpeciesWithPlanet[] getPlanetsAndTranform(SpeciesResponse speciesResponse) {
        List<SpeciesWithPlanet> speciesWithPlanet = new ArrayList<>();
         for(Species specie : speciesResponse.getResults()){
             Planet planet = planetsManager.getPlanet(specie.getHomeworld());
             if (planet!=null){
                 SpeciesWithPlanet specieWithPlanet = mergeSpecieAndPlanet(specie, planet);
                 speciesWithPlanet.add(specieWithPlanet);
             }
         }
         return speciesWithPlanet.toArray(new SpeciesWithPlanet[0]);
    }

    private SpeciesWithPlanet mergeSpecieAndPlanet(Species specie, Planet planet) {
        SpeciesWithPlanet speciesWithPlanet = new SpeciesWithPlanet();
        speciesWithPlanet.setPlanet(planet.getName());
        speciesWithPlanet.setClassification(specie.getClassification());
        speciesWithPlanet.setDesignation(specie.getDesignation());
        speciesWithPlanet.setName(specie.getName());
        return speciesWithPlanet;
    }

}
