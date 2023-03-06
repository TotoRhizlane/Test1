package org.louakfaoui.controller;

import org.louakfaoui.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping("/films")
    public void saveAllFilms() {
        filmService.saveAllFilm();
    }
}
