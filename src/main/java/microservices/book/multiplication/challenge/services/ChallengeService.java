package microservices.book.multiplication.challenge.services;

import microservices.book.multiplication.challenge.domain.ChallengeAttempt;
import microservices.book.multiplication.challenge.domain.ChallengeAttemptDTO;

public interface ChallengeService {
/**
* Verifies if an attempt coming from the presentation layer is correct or not.
*
* @return the resulting ChallengeAttempt object
*/
ChallengeAttempt verifyAttempt(ChallengeAttemptDTO resultAttempt);
}
