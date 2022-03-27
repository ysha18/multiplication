package microservices.book.multiplication.challenge.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservices.book.multiplication.challenge.domain.Challenge;
import microservices.book.multiplication.challenge.services.ChallengeGeneratorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/challenges")
public class ChallengeController {

  private final ChallengeGeneratorService challengeGeneratorService;

  @GetMapping("/random")
  public Challenge getRandomChallenge(){
    Challenge challenge = challengeGeneratorService.randomChallenge();
    log.info("Generating a random challenge: {}", challenge);
    return challenge;
  }
}
