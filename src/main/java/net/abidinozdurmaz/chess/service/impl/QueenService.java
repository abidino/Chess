package net.abidinozdurmaz.chess.service.impl;

import net.abidinozdurmaz.chess.dto.ChessBoard;
import net.abidinozdurmaz.chess.dto.PieceDto;
import net.abidinozdurmaz.chess.service.Piece;
import net.abidinozdurmaz.chess.util.PieceMoveUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueenService implements Piece {

    @Override
    public List<PieceDto[][]> possibleMoves(ChessBoard chessBoard, PieceDto pieceDto) {
        List<PieceDto[][]> queenPossibleBoards = new ArrayList<>();

        PieceMoveUtil.moveUp(chessBoard, pieceDto, queenPossibleBoards);
        PieceMoveUtil.moveDown(chessBoard, pieceDto, queenPossibleBoards);
        PieceMoveUtil.moveRight(chessBoard, pieceDto, queenPossibleBoards);
        PieceMoveUtil.moveLeft(chessBoard, pieceDto, queenPossibleBoards);
        PieceMoveUtil.moveRightUpCross(chessBoard, pieceDto, queenPossibleBoards);
        PieceMoveUtil.moveLeftUpCross(chessBoard, pieceDto, queenPossibleBoards);
        PieceMoveUtil.moveRightDownCross(chessBoard, pieceDto, queenPossibleBoards);
        PieceMoveUtil.moveLeftDownCross(chessBoard, pieceDto, queenPossibleBoards);

        return queenPossibleBoards;
    }
}
