package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.census;
@Repository
public interface CensusRepository extends JpaRepository<census, Integer>{


}
