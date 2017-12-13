
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Option;

@Repository
public interface OptionRepository extends JpaRepository<Option, Integer> {

}
