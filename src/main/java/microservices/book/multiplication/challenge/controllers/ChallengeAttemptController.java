package microservices.book.multiplication.challenge.controllers;

import javax.validation.Valid;
import microservices.book.multiplication.challenge.domain.ChallengeAttempt;
import microservices.book.multiplication.challenge.domain.ChallengeAttemptDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservices.book.multiplication.challenge.domain.Challenge;
import microservices.book.multiplication.challenge.services.ChallengeService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/attempts")
public class ChallengeAttemptController {

    private final ChallengeService challengeService;

    // @GetMapping("/{challengeId}")
    // public Challenge getChallengeWithParam(@PathVariable("challengeId") Long challengeId, @RequestParam("factor") int factor){
    //     return null;
    // }
    @PostMapping
    ResponseEntity<ChallengeAttempt> postResult(@RequestBody @Valid ChallengeAttemptDTO challengeAttemptDTO){
        return ResponseEntity.ok(challengeService.verifyAttempt(challengeAttemptDTO));
    }
}
