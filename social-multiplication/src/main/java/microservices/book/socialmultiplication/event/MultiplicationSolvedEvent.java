package microservices.book.socialmultiplication.event;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Event that models the fact that {@link microservices.book.socialmultiplication.domain.Multiplication}
 * has been resolved in the system. Provides some context information about the multiplication
 */

@ToString
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class MultiplicationSolvedEvent implements Serializable {
    private final Long multiplicationResultAttempt;
    private final Long userId;
    private final boolean correct;


}
