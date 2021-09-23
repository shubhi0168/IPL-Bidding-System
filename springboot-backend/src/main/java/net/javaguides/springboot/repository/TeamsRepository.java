package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Bid;
import net.javaguides.springboot.model.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Integer> {

}
