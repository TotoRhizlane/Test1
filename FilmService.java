package org.louakfaoui.service;

import org.louakfaoui.model.Film;
import org.louakfaoui.model.People;

import org.louakfaoui.repository.FilmRepository;
import org.louakfaoui.repository.PeopleRepository;
import org.louakfaoui.response.FilmResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private FilmRepository filmRepository;
    /*@Autowired
    private PeopleRepository peopleRepository;*/
    @Value("${starwarsapi.baseurl}")
    private String baseUrl;

    public List<Film> getAllFilm() {
        String url = baseUrl + "/films/";

        do {
            ResponseEntity<FilmResponse> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    FilmResponse.class
            );

            return responseEntity.getBody().getResults();


        } while (url != null);

    }

    @Transactional
    public void saveAllFilm() {
        List<Film> film = getAllFilm();
        filmRepository.saveAll(film);
        /*People people = new People();
        people.setEyeColor("Blue");
        Film film1 = new Film();
        Film film2 = new Film();
        film1.setTitle("Test1");
        film2.setTitle("Test2");
        people.setFilms(List.of(film1,film2));
        peopleRepository.save(people);
        People byId = peopleRepository.getById(4L);
        List<Film> films = byId.getFilms();
        byId.toString();*/
    }


}
