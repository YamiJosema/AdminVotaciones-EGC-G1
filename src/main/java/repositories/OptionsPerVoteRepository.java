
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.OptionsPerVote;

@Repository
public interface OptionsPerVoteRepository extends JpaRepository<OptionsPerVote, Integer> {

}
