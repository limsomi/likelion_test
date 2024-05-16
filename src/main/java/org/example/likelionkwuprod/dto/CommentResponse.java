package org.example.likelionkwuprod.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.likelionkwuprod.domain.Comment;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommentResponse {
    private Long commentId;
    private String commentAuthor;
    private String commentContent;
    private Long boardId;
    private String boardTitle;

    public CommentResponse(Comment comment) {
        this.commentId = comment.getCommentId();
        this.commentAuthor = comment.getCommentAuthor();
        this.commentContent = comment.getCommentContent();
        this.boardId = comment.getBoard().getBoardId();
        this.boardTitle = comment.getBoard().getBoardTitle();
    }
}
