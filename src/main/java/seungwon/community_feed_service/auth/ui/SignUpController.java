package seungwon.community_feed_service.auth.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import seungwon.community_feed_service.auth.application.EmailService;
import seungwon.community_feed_service.auth.application.dto.CreateUserAuthRequestDto;
import seungwon.community_feed_service.auth.application.dto.SendEmailRequestDto;
import seungwon.community_feed_service.common.ui.Response;

@RestController
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignUpController {

    private final EmailService emailService;

    @PostMapping("/send-verification-email")
    public Response<Void> sendEmail(@RequestBody SendEmailRequestDto dto) {
        emailService.sendEmail(dto);
        return Response.ok(null);
    }

    @GetMapping("/verify-token")
    public Response<Void> verifyEmail(String email, String token) {
        emailService.verifyEmail(email, token);
        return Response.ok(null);
    }

    @PostMapping("/register")
    public Response<Long> register(@RequestBody CreateUserAuthRequestDto dto) {
        return Response.ok(1L);
    }
}
