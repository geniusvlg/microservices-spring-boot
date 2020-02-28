package microservices.book.socialmultiplication.repository;

import microservices.book.socialmultiplication.domain.Multiplication;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface allows us to save and retrieve Multiplications
 */
public interface MultiplicationRepository extends CrudRepository<Multiplication, Long> {
}
