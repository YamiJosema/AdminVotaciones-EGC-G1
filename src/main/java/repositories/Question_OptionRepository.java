package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.question_option;

@Repository
public interface Question_OptionRepository extends JpaRepository<question_option, Integer> {

}
