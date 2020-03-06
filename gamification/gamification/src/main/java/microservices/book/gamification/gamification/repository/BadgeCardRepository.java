package microservices.book.gamification.gamification.repository;

import microservices.book.gamification.gamification.domain.BadgeCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Handle data operations with BadgeCards
 */
public interface BadgeCardRepository extends JpaRepository<BadgeCard, Long> {
    /**
     * Retrieve all BadgeCards for a given user.
     * @param userId
     * @return the list of BadgeCards, sorted by most recent.
     */
    List<BadgeCard> findByUserIdOrderByBadgeTimestampDesc(final Long userId);

}
