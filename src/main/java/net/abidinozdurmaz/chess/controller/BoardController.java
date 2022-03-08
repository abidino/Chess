package net.abidinozdurmaz.chess.controller;

import lombok.RequiredArgsConstructor;
import net.abidinozdurmaz.chess.dto.ChessBoard;
import net.abidinozdurmaz.chess.record.BoardRecord;
import net.abidinozdurmaz.chess.type.Color;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardController {

    private final BoardRecord boardRecord;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/move")
    public ChessBoard move(@RequestBody ChessBoard chessBoard) {
        return boardRecord.move(chessBoard);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/start-board")
    public ChessBoard startBoard() {
        return new ChessBoard(ChessBoard.startingSequence(), Color.WHITE);
    }
}