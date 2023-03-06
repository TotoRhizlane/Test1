package org.louakfaoui.controller;

import org.louakfaoui.service.StarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StarshipController {
    @Autowired
    private StarshipService starshipService;

    @GetMapping("/starships")
    public void saveAllStarships() {
        starshipService.saveAllStarship();
    }
}
