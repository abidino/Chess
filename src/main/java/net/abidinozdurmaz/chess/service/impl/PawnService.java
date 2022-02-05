package net.abidinozdurmaz.chess.service.impl;

import net.abidinozdurmaz.chess.dto.ChessBoard;
import net.abidinozdurmaz.chess.dto.PieceDto;
import net.abidinozdurmaz.chess.service.Piece;
import net.abidinozdurmaz.chess.type.PieceType;
import net.abidinozdurmaz.chess.util.ChessUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PawnService implements Piece {

    @Override
    public List<PieceDto[][]> possibleMoves(ChessBoard chessBoard, PieceDto pieceDto) {
        PieceDto[][] sq = chessBoard.getSquares();
        List<PieceDto[][]> pawnPossibleBoards = new ArrayList<>();

        int i = pieceDto.getLocationX();
        int j = pieceDto.getLocationY();

        if (j != 7) {
            //pawn move forward two steps
            if (j == 1 && sq[i][j + 2] == null && sq[i][j + 1] == null) {
                PieceDto[][] squares = chessBoard.cloneBoard();
                squares[i][j + 2] = sq[i][j];
                squares[i][j] = null;
                ChessUtil.updateLocation(squares[i][j + 2], i, j + 2);
                pawnPossibleBoards.add(squares);
            }

            //pawn eats right cross piece
            if (i != 7 && sq[i + 1][j + 1] != null && sq[i + 1][j + 1].getColor() != chessBoard.getMoveOrder()) {
                PieceDto[][] squares = chessBoard.cloneBoard();

                //checking queen transformation status
                if (j == 6) {
                    squares[i + 1][j + 1] = new PieceDto(PieceType.QUEEN, i + 1, j + 1, chessBoard.getMoveOrder());
                } else {
                    squares[i + 1][j + 1] = sq[i][j];
                    ChessUtil.updateLocation(squares[i + 1][j + 1], i + 1, j + 1);
                }
                squares[i][j] = null;
                pawnPossibleBoards.add(squares);

            }
            //pawn eats left cross piece
            if (i != 0 && sq[i - 1][j + 1] != null && sq[i - 1][j + 1].getColor() != chessBoard.getMoveOrder()) {
                PieceDto[][] squares = chessBoard.cloneBoard();

                //checking queen transformation status
                if (j == 6) {
                    squares[i - 1][j + 1] = new PieceDto(PieceType.QUEEN, i - 1, j + 1, chessBoard.getMoveOrder());
                } else {
                    squares[i - 1][j + 1] = sq[i][j];
                    ChessUtil.updateLocation(squares[i - 1][j + 1], i - 1, j + 1);
                }
                squares[i][j] = null;
                pawnPossibleBoards.add(squares);
            }

            //pawn move forward
            if (sq[i][j + 1] == null) {
                PieceDto[][] squares = chessBoard.cloneBoard();

                //checking queen transformation status
                if (j == 6) {
                    squares[i][j + 1] = new PieceDto(PieceType.QUEEN, i, j + 1, chessBoard.getMoveOrder());
                } else {
                    squares[i][j + 1] = sq[i][j];
                    ChessUtil.updateLocation(squares[i][j + 1], i, j + 1);
                }
                squares[i][j] = null;
                pawnPossibleBoards.add(squares);
            }
        }
        return pawnPossibleBoards;
    }
}
