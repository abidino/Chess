package net.abidinozdurmaz.chess.service;

import net.abidinozdurmaz.chess.dto.ChessBoard;
import net.abidinozdurmaz.chess.dto.PieceDto;

import java.util.List;

public interface Piece {
    List<PieceDto[][]> possibleMoves(ChessBoard chessBoard, PieceDto pieceDto);
}
