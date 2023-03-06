package org.louakfaoui.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "people")
public class People {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "height")
    private String height;
    @Column(name = "mass")
    private String mass;
    @Column(name = "hair_color")
    private String hairColor;
    @Column(name = "skin_color")
    private String skinColor;
    @Column(name = "eye_color")
    private String eyeColor;
    @Column(name = "birth_year")
    private String birthYear;
    @Column(name = "gender")
    private String gender;
    @Column(name = "homeworld")
    private String homeworld;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "films_people",
            joinColumns = @JoinColumn(name = "people_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id"))
    private List<Film> films;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "starship_people",
            joinColumns = @JoinColumn(name = "people_id"),
            inverseJoinColumns = @JoinColumn(name = "starship_id"))
    private List<Starship> starships;
    @Column(name = "created")
    private Date created;
    @Column(name = "edited")
    private Date edited;
    @Column(name = "url")
    private String url;

}
