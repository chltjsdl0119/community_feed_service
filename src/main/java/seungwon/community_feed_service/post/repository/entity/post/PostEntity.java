package seungwon.community_feed_service.post.repository.entity.post;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import seungwon.community_feed_service.common.domain.PositiveIntegerCounter;
import seungwon.community_feed_service.common.repository.entity.TimeBaseEntity;
import seungwon.community_feed_service.post.domain.Post;
import seungwon.community_feed_service.post.domain.PostPublicationState;
import seungwon.community_feed_service.post.domain.content.PostContent;
import seungwon.community_feed_service.user.repository.entity.UserEntity;

@Entity
@Table(name = "community_post")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostEntity extends TimeBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private UserEntity author;

    private String content;

    @ColumnDefault("0")
    private int commentCount;

    @Convert(converter = PostPublicationStateConverter.class)
    private PostPublicationState state;

    private Integer likeCount;

    public PostEntity(Post post) {
        this.id = post.getId();
        this.author = new UserEntity(post.getAuthor());
        this.content = post.getContent().getContentText();
        this.state = post.getState();
        this.likeCount = post.getLikeCount();
    }

    public Post toPost() {
        return Post.builder()
                .id(id)
                .author(author.toUser())
                .content(new PostContent(content))
                .state(state)
                .likeCounter(new PositiveIntegerCounter(likeCount))
                .build();
    }
}
