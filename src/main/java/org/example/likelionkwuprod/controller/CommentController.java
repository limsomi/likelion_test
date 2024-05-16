package org.example.likelionkwuprod.controller;

import lombok.RequiredArgsConstructor;
import org.example.likelionkwuprod.domain.Comment;
import org.example.likelionkwuprod.dto.CommentRequest;
import org.example.likelionkwuprod.dto.CommentResponse;
import org.example.likelionkwuprod.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/board")
@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{boardId}/comment/create")
    public ResponseEntity<String> createBoard(
            @RequestBody CommentRequest commentRequest,
            @PathVariable Long boardId) {
        if (commentService.createComment(commentRequest, boardId)) {
            return ResponseEntity.ok("댓글 작성 완료");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{boardId}/comment")
    public ResponseEntity<List<CommentResponse>> getBoardComments(@PathVariable Long boardId) {
        List<Comment> comments = commentService.getCommentByBoardId(boardId);
        List<CommentResponse> commentResponses = new ArrayList<>();

        for (Comment comment : comments) {
            commentResponses.add(new CommentResponse(comment));
        }

        if (commentResponses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(commentResponses);
        }
    }
}
