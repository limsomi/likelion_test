package org.example.likelionkwuprod.repository;

import org.example.likelionkwuprod.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByBoardId(Long boardId);
    List<Board> findBoardByBoardAuthor(String boardAuthor);
}
