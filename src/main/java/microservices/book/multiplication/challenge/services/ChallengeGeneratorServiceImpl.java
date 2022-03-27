package microservices.book.multiplication.challenge.services;
import microservices.book.multiplication.challenge.domain.Challenge;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class ChallengeGeneratorServiceImpl implements ChallengeGeneratorService {
    private final Random random;
    private final static int MINIMUM_FACTOR = 11;
    private final static int MAXIMUM_FACTOR = 100;

    ChallengeGeneratorServiceImpl() {
        this.random = new Random();
    }
    public ChallengeGeneratorServiceImpl(final Random random) {
        this.random = random;
    }

    public int next(){
        return random.nextInt(MAXIMUM_FACTOR - MINIMUM_FACTOR) + MINIMUM_FACTOR;
    }

    @Override
    public Challenge randomChallenge() {
        return new Challenge(next(), next());
    }
}