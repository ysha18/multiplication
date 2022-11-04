package microservices.book.multiplication.challenge;

import microservices.book.multiplication.challenge.domain.ChallengeAttempt;
import microservices.book.multiplication.challenge.domain.ChallengeAttemptDTO;
import microservices.book.multiplication.challenge.services.ChallengeService;
import microservices.book.multiplication.challenge.services.ChallengeServiceImpl;
import microservices.book.multiplication.users.User;
import microservices.book.multiplication.users.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ChallengeServiceTest {

    ChallengeService challengeService;
    @Mock
    ChallengeAttemptRepository attemptRepository;
    @Mock
    UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        challengeService = new ChallengeServiceImpl(userRepository, attemptRepository);
        given(attemptRepository.save(any())).will(returnsFirstArg());
    }


    @Test
    public void checkRightAnswer() {
        // given
        ChallengeAttemptDTO challengeAttemptDTO = new ChallengeAttemptDTO(50, 60, "John Doe", 3000);
        // when
        ChallengeAttempt resultAttempt = challengeService.verifyAttempt(challengeAttemptDTO);
        // then
        then(resultAttempt.isCorrect()).isTrue();
        verify(userRepository).save(new User("john_doe"));
        verify(attemptRepository).save(resultAttempt);
    }

    @Test
    public void checkWrongAnswer() {
        ChallengeAttemptDTO challengeAttemptDTO = new ChallengeAttemptDTO(50, 60, "John Doe", 6000);
        ChallengeAttempt resultAttempt = challengeService.verifyAttempt(challengeAttemptDTO);
        then(resultAttempt.isCorrect()).isFalse();
        verify(userRepository).save(new User("john_doe"));
        verify(attemptRepository).save(resultAttempt);
    }

    @Test
    public void checkExistingUserTest() {
        // given
        User existingUser = new User(1L, "john_doe");
        given(userRepository.findByAlias("john_doe")).willReturn(Optional.of(existingUser));
        ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(50, 60, "john_doe", 5000);

        // when
        ChallengeAttempt resultAttempts = challengeService.verifyAttempt(attemptDTO);

        // then
        then(resultAttempts.isCorrect()).isFalse();
        then(resultAttempts.getUser()).isEqualTo(existingUser);
        verify(userRepository, never()).save(any());
        verify(attemptRepository).save(resultAttempts);
    }

    @Test
    public void checkRetrieveLastAttempt() {
        // given
        var attempt = new ChallengeAttempt(null, new User(" john_doe"), 50, 60, 5000, false);
        given(attemptRepository.lastAttempts("john_doe")).willReturn(List.of(attempt));

        // when
        var attempts = challengeService.getStatsForUser("john_doe");

        // then
        then(attempts).isNotEmpty();
        then(attempts).size().isEqualTo(1);
    }


}
