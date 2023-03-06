package org.louakfaoui.service;

import org.louakfaoui.model.Starship;
import org.louakfaoui.repository.StarshipRepository;
import org.louakfaoui.response.StarshipResponse;
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
public class StarshipService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StarshipRepository starshipRepository;
    @Value("${starwarsapi.baseurl}")
    private String baseUrl;

    public List<Starship> getAllStarship() {
        String url = baseUrl + "/starships/";

        do {
            ResponseEntity<StarshipResponse> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    StarshipResponse.class
            );

            return responseEntity.getBody().getResults();

        } while (url != null);

    }

    @Transactional
    public void saveAllStarship() {
        List<Starship> starship = getAllStarship();
        starshipRepository.saveAll(starship);
    }
}
