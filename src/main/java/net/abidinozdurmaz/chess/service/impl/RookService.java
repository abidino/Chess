package net.abidinozdurmaz.chess.service.impl;

import net.abidinozdurmaz.chess.dto.ChessBoard;
import net.abidinozdurmaz.chess.dto.PieceDto;
import net.abidinozdurmaz.chess.service.Piece;
import net.abidinozdurmaz.chess.util.PieceMoveUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RookService implements Piece {

    @Override
    public List<PieceDto[][]> possibleMoves(ChessBoard chessBoard, PieceDto pieceDto) {

        List<PieceDto[][]> rookPossibleBoards = new ArrayList<>();

        PieceMoveUtil.moveUp(chessBoard, pieceDto, rookPossibleBoards);
        PieceMoveUtil.moveDown(chessBoard, pieceDto, rookPossibleBoards);
        PieceMoveUtil.moveRight(chessBoard, pieceDto, rookPossibleBoards);
        PieceMoveUtil.moveLeft(chessBoard, pieceDto, rookPossibleBoards);

        return rookPossibleBoards;
    }
}
