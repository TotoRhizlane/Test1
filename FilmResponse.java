package org.louakfaoui.response;

import lombok.Data;
import org.louakfaoui.model.Film;

import java.util.List;

@Data
public class FilmResponse {
    private List<Film> results;
    private String next;
}
