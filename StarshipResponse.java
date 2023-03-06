package org.louakfaoui.response;

import lombok.Data;
import org.louakfaoui.model.Starship;

import java.util.List;

@Data
public class StarshipResponse {
    private List<Starship> results;
    private String next;
}
