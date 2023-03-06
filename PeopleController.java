package org.louakfaoui.controller;

import org.louakfaoui.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleController {
    @Autowired
    private PeopleService peopleService;

    @GetMapping("/people")
    public void saveAllPeople()  {
        //peopleService.saveAllPeople();
    }
}
