package org.louakfaoui.service;

import org.louakfaoui.model.People;
import org.louakfaoui.repository.PeopleRepository;
import org.louakfaoui.response.PeopleResponse;
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
public class PeopleService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PeopleRepository peopleRepository;
    @Value("${starwarsapi.baseurl}")
    private String baseUrl;

    public List<People> getAllPeople() {
        //List<People> people = new ArrayList<>();
        String url = baseUrl + "/people/";

        do {
            ResponseEntity<PeopleResponse> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    PeopleResponse.class
            );

            return responseEntity.getBody().getResults();

        } while (url != null);

    }
    @Transactional
    public void saveAllPeople() {
        List<People> people = getAllPeople();
        peopleRepository.saveAll(people);
    }
}
