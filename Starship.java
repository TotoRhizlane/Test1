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
@Table(name="starships")
public class Starship {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "model")
    private String model;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "cost_in_credits")
    private String costInCredits;
    @Column(name = "length")
    private String length;
    @Column(name = "max_atmosphering_speed")
    private String maxAtmospheringSpeed;
    @Column(name = "crew")
    private String crew;
    @Column(name = "passengers")
    private String passengers;
    @Column(name = "cargo_capacity")
    private String cargoCapacity;
    @Column(name = "consumables")
    private String consumables;
    @Column(name = "hyper_drive_rating")
    private String hyperdriveRating;
    @Column(name = "MGLT")
    private String MGLT;
    @Column(name = "starship_class")
    private String starshipClass;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_starship",
            joinColumns = @JoinColumn(name = "starship_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id"))
    private List<Film> films;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "starship_people",
            joinColumns = @JoinColumn(name = "starship_id"),
            inverseJoinColumns = @JoinColumn(name = "people_id"))
    private List<People> people;
    @Column(name = "created")
    private Date created;
    @Column(name = "edited")
    private Date edited;
    @Column(name = "url")
    private String url;
}
