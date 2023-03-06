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
@Table(name="films")
public class Film {
    @Id
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "episode_id")
    private Integer episodeId;
    @Column(name = "opening_crawl")
    private String openingCrawl;
    @Column(name = "director")
    private String director;
    @Column(name = "producer")
    private String producer;
    @Column(name = "release_date")
    private Date releaseDate;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_people",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "people_id"))
    private List<People> people;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_starship",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "starship_id"))
    private List<Starship> starships;
    @Column(name = "created")
    private Date created;
    @Column(name = "edited")
    private Date edited;
    @Column(name = "url")
    private String url;
}

