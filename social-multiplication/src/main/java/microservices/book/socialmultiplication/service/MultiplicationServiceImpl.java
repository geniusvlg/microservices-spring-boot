package microservices.book.socialmultiplication.service;

import microservices.book.socialmultiplication.domain.Multiplication;
import microservices.book.socialmultiplication.domain.MultiplicationResultAttempt;
import microservices.book.socialmultiplication.domain.User;
import microservices.book.socialmultiplication.repository.MultiplicationResultAttemptRepository;
import microservices.book.socialmultiplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {

    private RandomGeneratorService randomGeneratorService;

    private MultiplicationResultAttemptRepository attemptRepository;

    private UserRepository userRepository;

    @Autowired
    public MultiplicationServiceImpl(final RandomGeneratorService randomGeneratorService,
                                     final MultiplicationResultAttemptRepository attemptRepository,
                                     final UserRepository userRepository) {
        this.randomGeneratorService = randomGeneratorService;
        this.attemptRepository = attemptRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = randomGeneratorService.
                generateRandomFactor();
        int factorB = randomGeneratorService.
                generateRandomFactor();
        return new Multiplication(factorA, factorB);
    }

    @Transactional
    @Override
    public boolean checkAttempt(final MultiplicationResultAttempt resultAttempt) {

        // Check if the user already exists for that alias
        Optional<User> user = userRepository.findByAlias(resultAttempt.getUser().getAlias());

        // Avoid 'hack' attempt
        Assert.isTrue(!resultAttempt.isCorrect(), "You can't send an attempt marked as correct!!");

        // Check if the attempt is correct
        boolean isCorrect = resultAttempt.getResultAttempt() == resultAttempt.getMultiplication().getFactorA() *
                resultAttempt.getMultiplication().getFactorB();

        // Create a copy, now setting the 'correct' field accordingly
        MultiplicationResultAttempt checkedAttempt = new MultiplicationResultAttempt(
                user.orElse(resultAttempt.getUser()),
                resultAttempt.getMultiplication(),
                resultAttempt.getResultAttempt(),
                isCorrect
        );

        // Stores the attempt
        attemptRepository.save(checkedAttempt);

        // Return the result
        return isCorrect;
    }
}
