package org.louakfaoui.repository;

import org.louakfaoui.model.Starship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarshipRepository extends JpaRepository<Starship, Long> {
}
