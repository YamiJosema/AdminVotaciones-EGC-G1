package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.question;
@Repository
public interface QuestionRepository extends JpaRepository<question, Integer>{


}
