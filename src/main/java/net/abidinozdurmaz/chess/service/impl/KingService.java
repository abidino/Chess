package net.abidinozdurmaz.chess.service.impl;

import net.abidinozdurmaz.chess.dto.ChessBoard;
import net.abidinozdurmaz.chess.dto.PieceDto;
import net.abidinozdurmaz.chess.service.Piece;
import net.abidinozdurmaz.chess.util.ChessUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KingService implements Piece {

    @Override
    public List<PieceDto[][]> possibleMoves(ChessBoard chessBoard, PieceDto pieceDto) {
        PieceDto[][] sq = chessBoard.getSquares();
        List<PieceDto[][]> kingPossibleBoards = new ArrayList<>();

        int i = pieceDto.getLocationX();
        int j = pieceDto.getLocationY();

        //king move forward
        //stone eating is being checked
        if (j != 7 && (sq[i][j + 1] == null || sq[i][j + 1].getColor() != chessBoard.getMoveOrder())) {

            PieceDto[][] squares = chessBoard.cloneBoard();
            squares[i][j + 1] = sq[i][j];
            squares[i][j] = null;
            ChessUtil.updateLocation(squares[i][j + 1], i, j + 1);
            kingPossibleBoards.add(squares);
        }

        //king move right
        //stone eating is being checked
        if (i != 7 && (sq[i + 1][j] == null || sq[i + 1][j].getColor() != chessBoard.getMoveOrder())) {

            PieceDto[][] squares = chessBoard.cloneBoard();
            squares[i + 1][j] = sq[i][j];
            squares[i][j] = null;
            ChessUtil.updateLocation(squares[i + 1][j], i + 1, j);
            kingPossibleBoards.add(squares);
        }

        //king move upper right cross
        //stone eating is being checked
        if (i != 7 && j != 7 && (sq[i + 1][j + 1] == null || sq[i + 1][j + 1].getColor() != chessBoard.getMoveOrder())) {
            PieceDto[][] squares = chessBoard.cloneBoard();
            squares[i + 1][j + 1] = sq[i][j];
            squares[i][j] = null;
            ChessUtil.updateLocation(squares[i + 1][j + 1], i + 1, j + 1);
            kingPossibleBoards.add(squares);
        }

        //king move bottom right cross
        //stone eating is being checked
        if (i != 7 && j != 0 && (sq[i + 1][j - 1] == null || sq[i + 1][j - 1].getColor() != chessBoard.getMoveOrder())) {
            PieceDto[][] squares = chessBoard.cloneBoard();
            squares[i + 1][j - 1] = sq[i][j];
            squares[i][j] = null;
            ChessUtil.updateLocation(squares[i + 1][j - 1], i + 1, j - 1);
            kingPossibleBoards.add(squares);
        }

        //king move back
        //stone eating is being checked
        if (j != 0 && (sq[i][j - 1] == null || sq[i][j - 1].getColor() != chessBoard.getMoveOrder())) {

            PieceDto[][] squares = chessBoard.cloneBoard();
            squares[i][j - 1] = sq[i][j];
            squares[i][j] = null;
            ChessUtil.updateLocation(squares[i][j - 1], i, j - 1);
            kingPossibleBoards.add(squares);
        }

        //king move left
        //stone eating is being checked
        if (i != 0 && (sq[i - 1][j] == null || sq[i - 1][j].getColor() != chessBoard.getMoveOrder())) {

            PieceDto[][] squares = chessBoard.cloneBoard();
            squares[i - 1][j] = sq[i][j];
            squares[i][j] = null;
            ChessUtil.updateLocation(squares[i - 1][j], i - 1, j);
            kingPossibleBoards.add(squares);
        }

        //king move upper left cross
        //stone eating is being checked
        if (i != 0 && j != 7 && (sq[i - 1][j + 1] == null || sq[i - 1][j + 1].getColor() != chessBoard.getMoveOrder())) {

            PieceDto[][] squares = chessBoard.cloneBoard();
            squares[i - 1][j + 1] = sq[i][j];
            squares[i][j] = null;
            ChessUtil.updateLocation(squares[i - 1][j + 1], i - 1, j + 1);
            kingPossibleBoards.add(squares);
        }


        //king move bottom left cross
        //stone eating is being checked
        if (i != 0 && j != 0 && (sq[i - 1][j - 1] == null || sq[i - 1][j - 1].getColor() != chessBoard.getMoveOrder())) {

            PieceDto[][] squares = chessBoard.cloneBoard();
            squares[i - 1][j - 1] = sq[i][j];
            squares[i][j] = null;
            ChessUtil.updateLocation(squares[i - 1][j - 1], i - 1, j - 1);
            kingPossibleBoards.add(squares);
        }

        return kingPossibleBoards;
    }
}
