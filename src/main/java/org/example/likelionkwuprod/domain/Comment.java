package org.example.likelionkwuprod.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.likelionkwuprod.dto.CommentRequest;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private String commentAuthor;

    @Column(nullable = false)
    private String commentContent;

    @ManyToOne
    private Board board;

    public Comment(CommentRequest commentRequest, Board board) {
        this.commentAuthor = commentRequest.getUsername();
        this.commentContent = commentRequest.getCommentContent();
        this.board = board;
    }
}
