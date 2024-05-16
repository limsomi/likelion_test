package org.example.likelionkwuprod.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.likelionkwuprod.domain.Board;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoardResponse {
    private Long BoardId;
    private String boardAuthor;
    private String boardTitle;
    private String boardContent;

    public BoardResponse(Board board) {
        this.BoardId = board.getBoardId();
        this.boardAuthor = board.getBoardAuthor();
        this.boardTitle = board.getBoardTitle();
        this.boardContent = board.getBoardContent();
    }
}
