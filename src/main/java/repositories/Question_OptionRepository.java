package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Question_Option;

@Repository
public interface Question_OptionRepository extends JpaRepository<Question_Option, Integer> {

}
