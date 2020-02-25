package microservices.book.socialmultiplication.repository;

import org.springframework.data.repository.CrudRepository;

/**
 * This interface allows us to save and retrieve Multiplications
 */
public interface MultiplicationRepository extends CrudRepository<MultiplicationRepository,Long> {
}
