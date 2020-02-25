package microservices.book.socialmultiplication.repository;

import microservices.book.socialmultiplication.domain.MultiplicationResultAttempt;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * This interface allows us to store and retrieve attempts
 */

public interface MultiplicationResultAttemptRepository extends CrudRepository<MultiplicationResultAttempt, Long> {

    List<MultiplicationResultAttempt> findTop5ByUserAliasOrderByIdDesc(String userAlias);
}
