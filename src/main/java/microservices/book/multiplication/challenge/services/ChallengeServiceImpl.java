package microservices.book.multiplication.challenge.services;

import microservices.book.multiplication.challenge.domain.ChallengeAttempt;
import microservices.book.multiplication.challenge.domain.ChallengeAttemptDTO;
import microservices.book.multiplication.users.User;
import org.springframework.stereotype.Service;

@Service
public class ChallengeServiceImpl implements ChallengeService{


  @Override
  public ChallengeAttempt verifyAttempt(ChallengeAttemptDTO attemptDTO) {
    // Check if the attempt is correct
    boolean isCorrect = attemptDTO.getGuess() == attemptDTO.getFactorA() * attemptDTO.getFactorB();
    // We don't use identifiers for now
    User user = new User(null, attemptDTO.getUserAlias());
    // Builds the domain object. Null id for now.
    return  new ChallengeAttempt(null,
        user.getId(),
        attemptDTO.getFactorA(),
        attemptDTO.getFactorB(),
        attemptDTO.getGuess(),
        isCorrect
    );
  }
}
