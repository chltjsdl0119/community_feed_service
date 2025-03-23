package seungwon.community_feed_service.acceptance.steps;

import io.restassured.RestAssured;
import org.springframework.http.MediaType;
import seungwon.community_feed_service.auth.application.dto.CreateUserAuthRequestDto;
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

    public static Integer requestVerifyEmail(String email, String token) {
        return RestAssured
                .given()
                .queryParam("email", email)
                .queryParam("token", token)
                .when()
                .get("/signup/verify-token")
                .then()
                .extract()
                .jsonPath().get("code");
    }

    public static Integer registerUser(CreateUserAuthRequestDto dto) {
        return RestAssured
                .given()
                .body(dto)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .post("/signup/register")
                .then()
                .extract()
                .jsonPath().get("code");
    }
}
