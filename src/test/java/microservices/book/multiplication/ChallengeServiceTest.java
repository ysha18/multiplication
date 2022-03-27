package microservices.book.multiplication;

import static org.assertj.core.api.BDDAssertions.then;

import microservices.book.multiplication.challenge.domain.ChallengeAttempt;
import microservices.book.multiplication.challenge.domain.ChallengeAttemptDTO;
import microservices.book.multiplication.challenge.services.ChallengeService;
import microservices.book.multiplication.challenge.services.ChallengeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ChallengeServiceTest {

  ChallengeService challengeService;

  @BeforeEach
  public void setUp(){
    challengeService = new ChallengeServiceImpl();
  }

  @Test
  public void checkRightAnswer(){
    ChallengeAttemptDTO challengeAttemptDTO = new ChallengeAttemptDTO(50 ,60, "John Doe", 3000);
    ChallengeAttempt resultAttempt = challengeService.verifyAttempt(challengeAttemptDTO);
    then(resultAttempt.isCorrect()).isTrue();
  }

  @Test
  public void checkWrongAnswer(){
    ChallengeAttemptDTO challengeAttemptDTO = new ChallengeAttemptDTO(50 ,60, "John Doe", 6000);
    ChallengeAttempt resultAttempt = challengeService.verifyAttempt(challengeAttemptDTO);
    then(resultAttempt.isCorrect()).isFalse();
  }



}
