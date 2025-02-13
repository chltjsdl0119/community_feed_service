package seungwon.community_feed_service.acceptance.auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seungwon.community_feed_service.acceptance.utils.AcceptanceTestTemplate;
import seungwon.community_feed_service.auth.application.dto.SendEmailRequestDto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static seungwon.community_feed_service.acceptance.steps.SignUpAcceptanceSteps.requestSendEmail;


class SignUpAcceptanceTest extends AcceptanceTestTemplate {

    private final String email = "email@email.com";

    @BeforeEach
    void setUp() {
        this.cleanUp();
    }

    @Test
    void givenEmail_whenSendEmail_thenVerificationTokenSaved() {
        // given
        SendEmailRequestDto dto = new SendEmailRequestDto(email);

        // when
        Integer code = requestSendEmail(dto);

        // then
        String token = (email);
        assertNotNull(token);
        assertEquals(0, code);
    }

    @Test
    void givenInvalidEmail_whenEmailSend_thenVerificationTokenNotSaved() {
        // Given
        SendEmailRequestDto dto = new SendEmailRequestDto("abcd");

        // When
        Integer code = requestSendEmail(dto);

        // Then
        assertEquals(400, code);
    }
}
