package org.example.likelionkwuprod.repository;

import org.example.likelionkwuprod.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBoardBoardId(Long boardId);
}
