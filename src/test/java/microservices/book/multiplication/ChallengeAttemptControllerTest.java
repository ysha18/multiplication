package microservices.book.multiplication;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import microservices.book.multiplication.challenge.domain.ChallengeAttempt;
import microservices.book.multiplication.challenge.domain.ChallengeAttemptDTO;
import microservices.book.multiplication.challenge.services.ChallengeService;
import microservices.book.multiplication.users.User;

@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@WebMvcTest(ChallengeAttemptController.class)
public class ChallengeAttemptControllerTest {

    @MockBean
    private ChallengeService challengeService;
    @Autowired
    private MockMvc mvc;
    @Autowired
    private JacksonTester<ChallengeAttemptDto> jsonRequestTester;
    @Autowired
    private JacksonTester<ChallengeAttempt> jsonResultAttempt;

    @Test
    void postValidresult() throws Exception {
        // given
        User user = new User(1L, "john");
        long attemptId = 5L;
        ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(50, 70, "john", 3500);
        ChallengeAttempt expectedResponse = new ChallengeAttempt(attemptId, user, 50, 70, 3500, true);
        given(challengeService
                .verifyAttempt(eq(attemptDTO))
                .willReturn(expectedResponse);
                
                
        // when
        MockHttpServletResponse response = mvc.perform(
            post("/attemps")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonResultAttempt.write(attemptDTO)
                .getJson())
                .andReturn().getResponse()
            );

        // then
then(response.getStatus()).isEqualTo(HttpStatus.OK.value());
then(response.getContentAsString()).isEqualTo(jsonResultAttempt.write(expectedResponse).getJson());

    }

}
