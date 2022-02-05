package net.abidinozdurmaz.chess.record;

import net.abidinozdurmaz.chess.dto.ChessBoard;
import net.abidinozdurmaz.chess.dto.PieceDto;
import net.abidinozdurmaz.chess.service.impl.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record FacadeRecord(PawnService pawnService,
                           KnightService knightService,
                           BishopService bishopService,
                           RookService rookService,
                           QueenService queenService,
                           KingService kingService) {

    public List<PieceDto[][]> possibleMoves(ChessBoard chessBoard, PieceDto pieceDto) {

        return switch (pieceDto.getPieceType()) {
            case PAWN -> pawnService.possibleMoves(chessBoard, pieceDto);

            case KNIGHT -> knightService.possibleMoves(chessBoard, pieceDto);

            case BISHOP -> bishopService.possibleMoves(chessBoard, pieceDto);

            case ROOK -> rookService.possibleMoves(chessBoard, pieceDto);

            case QUEEN -> queenService.possibleMoves(chessBoard, pieceDto);

            case KING -> kingService.possibleMoves(chessBoard, pieceDto);
        };
    }
}
