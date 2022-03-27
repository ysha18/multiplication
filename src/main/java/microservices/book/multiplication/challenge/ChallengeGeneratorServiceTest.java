package microservices.book.multiplication.challenge;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.BDDAssertions.then;

import java.util.Random;
import microservices.book.multiplication.challenge.domain.Challenge;
import microservices.book.multiplication.challenge.services.ChallengeGeneratorService;
import microservices.book.multiplication.challenge.services.ChallengeGeneratorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ChallengeGeneratorServiceTest {

  private ChallengeGeneratorService challengeGeneratorService;
  @Spy
  private Random random;

  @BeforeEach
  public void setUp(){
    challengeGeneratorService = new ChallengeGeneratorServiceImpl(random);
  }

  @Test
  public void generateRandomNumberIsWithinExpectedLimits(){
    // given
    given(random.nextInt(89)).willReturn(20,30);
    // then calling the service return expected values
    Challenge challenge = challengeGeneratorService.randomChallenge();
    then(challenge).isEqualTo(new Challenge(31,41));
  }
}
