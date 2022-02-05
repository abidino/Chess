package net.abidinozdurmaz.chess.service.impl;

import net.abidinozdurmaz.chess.dto.ChessBoard;
import net.abidinozdurmaz.chess.dto.PieceDto;
import net.abidinozdurmaz.chess.service.Piece;
import net.abidinozdurmaz.chess.util.ChessUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KnightService implements Piece {

    @Override
    public List<PieceDto[][]> possibleMoves(ChessBoard chessBoard, PieceDto pieceDto) {

        PieceDto[][] sq = chessBoard.getSquares();
        List<PieceDto[][]> knightPossibleBoards = new ArrayList<>();

        int i = pieceDto.getLocationX();
        int j = pieceDto.getLocationY();

        //knight move 2 right 1 forward
        if (i < 6 && j != 7 && (sq[i + 2][j + 1] == null || sq[i + 2][j + 1].getColor() != chessBoard.getMoveOrder())) {
            PieceDto[][] squares = chessBoard.cloneBoard();
            squares[i + 2][j + 1] = sq[i][j];
            squares[i][j] = null;
            ChessUtil.updateLocation(squares[i + 2][j + 1], i + 2, j + 1);
            knightPossibleBoards.add(squares);
        }

        //knight move 2 right 1 back
        if (i < 6 && j != 0 && (sq[i + 2][j - 1] == null || sq[i + 2][j - 1].getColor() != chessBoard.getMoveOrder())) {

            PieceDto[][] squares = chessBoard.cloneBoard();
            squares[i + 2][j - 1] = sq[i][j];
            squares[i][j] = null;
            ChessUtil.updateLocation(squares[i + 2][j - 1], i + 2, j - 1);
            knightPossibleBoards.add(squares);
        }

        //knight move 2 left 1 forward
        if (i > 1 && j != 7 && (sq[i - 2][j + 1] == null || sq[i - 2][j + 1].getColor() != chessBoard.getMoveOrder())) {

            PieceDto[][] squares = chessBoard.cloneBoard();
            squares[i - 2][j + 1] = sq[i][j];
            squares[i][j] = null;
            ChessUtil.updateLocation(squares[i - 2][j + 1], i - 2, j + 1);
            knightPossibleBoards.add(squares);
        }

        //knight move 2 left 1 back
        if (i > 1 && j != 0 && (sq[i - 2][j - 1] == null || sq[i - 2][j - 1].getColor() != chessBoard.getMoveOrder())) {

            PieceDto[][] squares = chessBoard.cloneBoard();
            squares[i - 2][j - 1] = sq[i][j];
            squares[i][j] = null;
            ChessUtil.updateLocation(squares[i - 2][j - 1], i - 2, j - 1);
            knightPossibleBoards.add(squares);
        }

        //knight move 1 right 2 forward
        if (i != 7 && j < 6 && (sq[i + 1][j + 2] == null || sq[i + 1][j + 2].getColor() != chessBoard.getMoveOrder())) {

            PieceDto[][] squares = chessBoard.cloneBoard();
            squares[i + 1][j + 2] = sq[i][j];
            squares[i][j] = null;
            ChessUtil.updateLocation(squares[i + 1][j + 2], i + 1, j + 2);
            knightPossibleBoards.add(squares);

        }

        //knight move 1 left 2 forward
        if (i != 0 && j < 6 && (sq[i - 1][j + 2] == null || sq[i - 1][j + 2].getColor() != chessBoard.getMoveOrder())) {

            PieceDto[][] squares = chessBoard.cloneBoard();
            squares[i - 1][j + 2] = sq[i][j];
            squares[i][j] = null;
            ChessUtil.updateLocation(squares[i - 1][j + 2], i - 1, j + 2);
            knightPossibleBoards.add(squares);
        }

        //knight move 1 right 2 back
        if (i != 7 && j > 1 && (sq[i + 1][j - 2] == null || sq[i + 1][j - 2].getColor() != chessBoard.getMoveOrder())) {

            PieceDto[][] squares = chessBoard.cloneBoard();
            squares[i + 1][j - 2] = sq[i][j];
            squares[i][j] = null;
            ChessUtil.updateLocation(squares[i + 1][j - 2], i + 1, j - 2);
            knightPossibleBoards.add(squares);
        }

        //knight move 1 left 2 back
        if (i != 0 && j > 1 && (sq[i - 1][j - 2] == null || sq[i - 1][j - 2].getColor() != chessBoard.getMoveOrder())) {

            PieceDto[][] squares = chessBoard.cloneBoard();
            squares[i - 1][j - 2] = sq[i][j];
            squares[i][j] = null;
            ChessUtil.updateLocation(squares[i - 1][j - 2], i - 1, j - 2);
            knightPossibleBoards.add(squares);
        }

        return knightPossibleBoards;
    }
}
