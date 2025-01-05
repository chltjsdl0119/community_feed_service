package seungwon.community_feed_service.post.domain.content;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PostContentTest {

    @Test
    void givenContentLengthIsOk_whenCreated_thenReturnTextContent() {
        // Given
        String text = "this is a test";

        // When
        PostContent postContent = new PostContent(text);

        // Then
        assertEquals(text, postContent.contentText);
    }

    @Test
    void givenContentLengthIsOver_whenCreated_thenThrowError() {
        // Given
        String content = "a".repeat(501);

        // When, Then
        assertThrows(IllegalArgumentException.class, () -> new PostContent(content));
    }

    @ParameterizedTest
    @ValueSource(strings = {"뷁", "닭", "굵", "삵"})
    void givenContentLengthIsOverAndKorean_whenCreated_thenThrowError(String koreanWord) {
        // Given
        String content = koreanWord.repeat(501);

        // When, Then
        assertThrows(IllegalArgumentException.class, () -> new PostContent(content));
    }

    @Test
    void givenContentLengthIsUnder_whenCreated_thenThrowError() {
        // Given
        String content = "a".repeat(4);

        // When, Then
        assertThrows(IllegalArgumentException.class, () -> new PostContent(content));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void givenContentIsEmpty_whenCreated_thenThrowError(String content) {
        // When, Then
        assertThrows(IllegalArgumentException.class, () -> new PostContent(content));
    }

    @Test
    void givenContentLengthIsOk_whenUpdated_thenNotThrowError() {
        // Given
        String content = "this is a test";
        PostContent postContent = new PostContent(content);

        // When, Then
        postContent.updateContent("this is a updated content");
    }

    @Test
    void givenContentLengthIsOk_whenUpdated_thenReturnUpdatedContent() {
        // Given
        String content = "this is a test";
        PostContent postContent = new PostContent(content);

        // When
        String updatedContent = "this is a updated content";
        postContent.updateContent(updatedContent);

        // Then
        assertEquals(updatedContent, postContent.contentText);
    }

    @Test
    void givenContentLengthIsOver_whenUpdated_thenThrowError() {
        // Given
        String content = "this is a test";
        PostContent postContent = new PostContent(content);

        // When, Then
        String value = "a".repeat(501);
        assertThrows(IllegalArgumentException.class, () -> postContent.updateContent(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"뷁", "닭", "굵", "삵"})
    void givenContentLengthIsOverAndKorean_whenUpdated_thenThrowError(String koreanWord) {
        // Given
        String content = "this is a test";
        PostContent postContent = new PostContent(content);

        // When, Then
        String value = "a".repeat(501);
        assertThrows(IllegalArgumentException.class, () -> postContent.updateContent(value));
    }

    @Test
    void givenContentLengthIsUnder_whenUpdated_thenThrowError() {
        // Given
        String content = "this is a test";
        PostContent postContent = new PostContent(content);

        // When, Then
        String value = "a".repeat(4);
        assertThrows(IllegalArgumentException.class, () -> postContent.updateContent(value));
    }
}