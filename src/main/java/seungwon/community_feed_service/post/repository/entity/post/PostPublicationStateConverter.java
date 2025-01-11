package seungwon.community_feed_service.post.repository.entity.post;

import jakarta.persistence.AttributeConverter;
import seungwon.community_feed_service.post.domain.PostPublicationState;

public class PostPublicationStateConverter implements AttributeConverter<PostPublicationState, String> {

    @Override
    public String convertToDatabaseColumn(PostPublicationState state) {
        return state.name();
    }

    @Override
    public PostPublicationState convertToEntityAttribute(String s) {
        return PostPublicationState.valueOf(s);
    }
}
