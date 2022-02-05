package net.abidinozdurmaz.chess.service.impl;

import net.abidinozdurmaz.chess.dto.ChessBoard;
import net.abidinozdurmaz.chess.dto.PieceDto;
import net.abidinozdurmaz.chess.service.Piece;
import net.abidinozdurmaz.chess.util.PieceMoveUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BishopService implements Piece {

    @Override
    public List<PieceDto[][]> possibleMoves(ChessBoard chessBoard, PieceDto pieceDto) {

        List<PieceDto[][]> bishopPossibleBoards = new ArrayList<>();

        PieceMoveUtil.moveRightUpCross(chessBoard, pieceDto, bishopPossibleBoards);
        PieceMoveUtil.moveLeftUpCross(chessBoard, pieceDto, bishopPossibleBoards);
        PieceMoveUtil.moveRightDownCross(chessBoard, pieceDto, bishopPossibleBoards);
        PieceMoveUtil.moveLeftDownCross(chessBoard, pieceDto, bishopPossibleBoards);

        return bishopPossibleBoards;
    }
}
