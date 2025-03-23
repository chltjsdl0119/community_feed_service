package seungwon.community_feed_service.auth.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seungwon.community_feed_service.auth.application.dto.SendEmailRequestDto;
import seungwon.community_feed_service.auth.application.interfaces.EmailSendRepository;
import seungwon.community_feed_service.auth.application.interfaces.EmailVerificationRepository;
import seungwon.community_feed_service.auth.domain.Email;
import seungwon.community_feed_service.auth.domain.RandomTokenGenerator;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailSendRepository emailSendRepository;
    private final EmailVerificationRepository emailVerificationRepository;

    public void sendEmail(SendEmailRequestDto dto) {
        Email email = Email.createEmail(dto.email());
        String token = RandomTokenGenerator.generateToken();

        emailSendRepository.sendEmail(email, token);
        emailVerificationRepository.createEmailVerification(email, token);
    }

    public void verifyEmail(String email, String token) {
        Email emailValue = Email.createEmail(email);
        emailVerificationRepository.verifyEmail(emailValue, token);
    }
}
