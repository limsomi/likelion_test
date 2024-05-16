package org.example.likelionkwuprod.service;

import lombok.RequiredArgsConstructor;
import org.example.likelionkwuprod.domain.Board;
import org.example.likelionkwuprod.domain.Comment;
import org.example.likelionkwuprod.domain.User;
import org.example.likelionkwuprod.dto.CommentRequest;
import org.example.likelionkwuprod.repository.BoardRepository;
import org.example.likelionkwuprod.repository.CommentRepository;
import org.example.likelionkwuprod.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public boolean createComment(CommentRequest commentRequest, Long boardId) {
        String username = commentRequest.getUsername();
        Board board = boardRepository.findByBoardId(boardId);

        if (username == null) {
            return false;
        } else {
            Comment comment = new Comment(commentRequest, board);
            if (userRepository.findByUsername(username).isEmpty()) {
                User user = new User(username);
                userRepository.save(user);
            }
            commentRepository.save(comment);
            return true;
        }
    }

    public List<Comment> getCommentByBoardId(Long boardId) {
        return commentRepository.findByBoardBoardId(boardId);
    }


}
