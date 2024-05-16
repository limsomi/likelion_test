package org.example.likelionkwuprod.controller;

import lombok.RequiredArgsConstructor;
import org.example.likelionkwuprod.domain.Board;
import org.example.likelionkwuprod.dto.BoardRequest;
import org.example.likelionkwuprod.dto.BoardResponse;
import org.example.likelionkwuprod.repository.BoardRepository;
import org.example.likelionkwuprod.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/board")
@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @PostMapping("/create")
    public ResponseEntity<String> createBoard(@RequestBody BoardRequest boardRequest) {
        if (boardService.createBoard(boardRequest)) {
            return ResponseEntity.ok("질문글 생성 완료");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<BoardResponse>> getAllBoards() {
        List<Board> boards = boardService.getAllBoards();
        List<BoardResponse> boardResponse = new ArrayList<>();

        for (Board board : boards) {
            boardResponse.add(new BoardResponse(board));
        }

        if (boards.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(boardResponse);
        }
    }

    @GetMapping("/boardId/{boardId}")
    public ResponseEntity<BoardResponse> getBoardByBoardId(@PathVariable Long boardId) {
        Board board = boardService.getBoardById(boardId);
        if (board == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        BoardResponse boardResponse = new BoardResponse(board);
        return ResponseEntity.ok(boardResponse);
    }

    @GetMapping("/boardAuthor/{boardAuthor}")
    public ResponseEntity<List<BoardResponse>> getBoardByBoardAuthor(@PathVariable String boardAuthor) {
        List<Board> boards = boardRepository.findBoardByBoardAuthor(boardAuthor);
        List<BoardResponse> boardResponse = new ArrayList<>();

        for (Board board : boards) {
            boardResponse.add(new BoardResponse(board));
        }

        if (boardResponse.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(boardResponse);
        }
    }
}
