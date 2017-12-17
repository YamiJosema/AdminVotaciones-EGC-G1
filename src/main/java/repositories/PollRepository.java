package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.poll;

@Repository
public interface PollRepository extends JpaRepository<poll, Integer> {

}
