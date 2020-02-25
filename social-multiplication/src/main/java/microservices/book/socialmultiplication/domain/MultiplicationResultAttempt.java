package microservices.book.socialmultiplication.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Identifies the attempt from a {@link User} to solve a
 * {@link Multiplication}.
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public final class MultiplicationResultAttempt {

    private final User user;
    private final Multiplication multiplication;
    private final int resultAttempt;

    private final boolean correct;

    /**
     * @RequiredArgsConstructor generates a constructor taking all the final fields.
     */

    // Empty constructor for JSON (de)serialization
    MultiplicationResultAttempt() {
        this(null, null, -1, false);
    }
}
