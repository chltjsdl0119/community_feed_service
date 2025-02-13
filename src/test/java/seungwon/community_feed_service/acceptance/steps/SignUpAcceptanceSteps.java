package seungwon.community_feed_service.acceptance.steps;

import io.restassured.RestAssured;
import org.springframework.http.MediaType;
import seungwon.community_feed_service.auth.application.dto.SendEmailRequestDto;

public class SignUpAcceptanceSteps {

    public static Integer requestSendEmail(SendEmailRequestDto dto) {
        return RestAssured
                .given()
                .body(dto)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .post("/signup/send-verification-email")
                .then()
                .extract()
                .jsonPath().get("code");
    }
}
