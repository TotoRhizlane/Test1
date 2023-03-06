package org.louakfaoui.response;

import lombok.Data;
import org.louakfaoui.model.People;

import java.util.List;
@Data
public class PeopleResponse {
    private List<People> results;
    private String next;
}
