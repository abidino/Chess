package net.abidinozdurmaz.chess.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.abidinozdurmaz.chess.dto.ChessBoard;
import net.abidinozdurmaz.chess.dto.PieceDto;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PieceMoveUtil {

    public static void moveUp(ChessBoard chessBoard, PieceDto pieceDto, List<PieceDto[][]> possibleBoards) {

        int i = pieceDto.getLocationX();
        int j = pieceDto.getLocationY();
        PieceDto[][] sq = chessBoard.getSquares();

        if (j != 7) {

            for (int k = j + 1; k <= 7; k++) {
                if (sq[i][k] == null ||
                        sq[i][k].getColor() != chessBoard.getMoveOrder()) {

                    if (sq[i][k] != null &&
                            sq[i][k].getColor() != chessBoard.getMoveOrder()) {
                        PieceDto[][] squares = chessBoard.cloneBoard();
                        squares[i][k] = sq[i][j];
                        squares[i][j] = null;
                        ChessUtil.updateLocation(squares[i][k], i, k);
                        possibleBoards.add(squares);
                        break;
                    }

                    PieceDto[][] squares = chessBoard.cloneBoard();
                    squares[i][k] = sq[i][j];
                    squares[i][j] = null;
                    ChessUtil.updateLocation(squares[i][k], i, k);
                    possibleBoards.add(squares);
                } else break;
            }

        }
    }

    public static void moveDown(ChessBoard chessBoard, PieceDto pieceDto, List<PieceDto[][]> possibleBoards) {

        int i = pieceDto.getLocationX();
        int j = pieceDto.getLocationY();
        PieceDto[][] sq = chessBoard.getSquares();

        if (j != 0) {
            for (int k = j - 1; k >= 0; k--) {
                if (sq[i][k] == null ||
                        sq[i][k].getColor() != chessBoard.getMoveOrder()) {

                    if (sq[i][k] != null &&
                            sq[i][k].getColor() != chessBoard.getMoveOrder()) {
                        PieceDto[][] squares = chessBoard.cloneBoard();
                        squares[i][k] = sq[i][j];
                        squares[i][j] = null;
                        ChessUtil.updateLocation(squares[i][k], i, k);
                        possibleBoards.add(squares);
                        break;
                    }

                    PieceDto[][] squares = chessBoard.cloneBoard();
                    squares[i][k] = sq[i][j];
                    squares[i][j] = null;
                    ChessUtil.updateLocation(squares[i][k], i, k);
                    possibleBoards.add(squares);
                } else break;
            }
        }
    }

    public static void moveRight(ChessBoard chessBoard, PieceDto pieceDto, List<PieceDto[][]> possibleBoards) {

        int i = pieceDto.getLocationX();
        int j = pieceDto.getLocationY();
        PieceDto[][] sq = chessBoard.getSquares();

        if (i != 7) {
            for (int k = i + 1; k <= 7; k++) {

                if (sq[k][j] == null ||
                        sq[k][j].getColor() != chessBoard.getMoveOrder()) {

                    if (sq[k][j] != null &&
                            sq[k][j].getColor() != chessBoard.getMoveOrder()) {
                        PieceDto[][] squares = chessBoard.cloneBoard();
                        squares[k][j] = sq[i][j];
                        squares[i][j] = null;
                        ChessUtil.updateLocation(squares[k][j], k, j);
                        possibleBoards.add(squares);
                        break;
                    }

                    PieceDto[][] squares = chessBoard.cloneBoard();
                    squares[k][j] = sq[i][j];
                    squares[i][j] = null;
                    ChessUtil.updateLocation(squares[k][j], k, j);
                    possibleBoards.add(squares);
                } else break;
            }
        }
    }

    public static void moveLeft(ChessBoard chessBoard, PieceDto pieceDto, List<PieceDto[][]> possibleBoards) {

        int i = pieceDto.getLocationX();
        int j = pieceDto.getLocationY();
        PieceDto[][] sq = chessBoard.getSquares();

        if (i != 0) {
            for (int k = i - 1; k >= 0; k--) {
                if (sq[k][j] == null ||
                        sq[k][j].getColor() != chessBoard.getMoveOrder()) {

                    if (sq[k][j] != null &&
                            sq[k][j].getColor() != chessBoard.getMoveOrder()) {
                        PieceDto[][] squares = chessBoard.cloneBoard();
                        squares[k][j] = sq[i][j];
                        squares[i][j] = null;
                        ChessUtil.updateLocation(squares[k][j], k, j);
                        possibleBoards.add(squares);
                        break;
                    }
                    PieceDto[][] squares = chessBoard.cloneBoard();
                    squares[k][j] = sq[i][j];
                    squares[i][j] = null;
                    ChessUtil.updateLocation(squares[k][j], k, j);
                    possibleBoards.add(squares);
                } else break;
            }
        }
    }

    public static void moveRightUpCross(ChessBoard chessBoard, PieceDto pieceDto, List<PieceDto[][]> possibleBoards) {

        int i = pieceDto.getLocationX();
        int j = pieceDto.getLocationY();
        PieceDto[][] sq = chessBoard.getSquares();

        if (i != 7 && j != 7) {
            int l = i + 1;
            for (int k = j + 1; k <= 7; k++, l++) {

                if (sq[l][k] == null ||
                        sq[l][k].getColor() != chessBoard.getMoveOrder()) {

                    if (sq[l][k] != null &&
                            sq[l][k].getColor() != chessBoard.getMoveOrder()) {
                        PieceDto[][] squares = chessBoard.cloneBoard();
                        squares[l][k] = sq[i][j];
                        squares[i][j] = null;
                        ChessUtil.updateLocation(squares[l][k], l, k);
                        possibleBoards.add(squares);
                        break;
                    }

                    PieceDto[][] squares = chessBoard.cloneBoard();
                    squares[l][k] = sq[i][j];
                    squares[i][j] = null;
                    ChessUtil.updateLocation(squares[l][k], l, k);
                    possibleBoards.add(squares);

                    if (l == 7) break;
                } else break;
            }

        }

    }

    public static void moveLeftUpCross(ChessBoard chessBoard, PieceDto pieceDto, List<PieceDto[][]> possibleBoards) {

        int i = pieceDto.getLocationX();
        int j = pieceDto.getLocationY();
        PieceDto[][] sq = chessBoard.getSquares();

        if (i != 0 && j != 7) {
            int l = i - 1;
            for (int k = j + 1; k <= 7; k++, l--) {

                if (sq[l][k] == null ||
                        sq[l][k].getColor() != chessBoard.getMoveOrder()) {

                    if (sq[l][k] != null &&
                            sq[l][k].getColor() != chessBoard.getMoveOrder()) {
                        PieceDto[][] squares = chessBoard.cloneBoard();
                        squares[l][k] = sq[i][j];
                        squares[i][j] = null;
                        ChessUtil.updateLocation(squares[l][k], l, k);
                        possibleBoards.add(squares);
                        break;
                    }

                    PieceDto[][] squares = chessBoard.cloneBoard();
                    squares[l][k] = sq[i][j];
                    squares[i][j] = null;
                    ChessUtil.updateLocation(squares[l][k], l, k);
                    possibleBoards.add(squares);
                    if (l == 0) break;

                } else break;
            }
        }
    }

    public static void moveRightDownCross(ChessBoard chessBoard, PieceDto pieceDto, List<PieceDto[][]> possibleBoards) {
        int i = pieceDto.getLocationX();
        int j = pieceDto.getLocationY();
        PieceDto[][] sq = chessBoard.getSquares();

        if (i != 7 && j != 0) {
            int l = i + 1;
            for (int k = j - 1; k >= 0; k--, l++) {
                if (sq[l][k] == null ||
                        sq[l][k].getColor() != chessBoard.getMoveOrder()) {

                    if (sq[l][k] != null &&
                            sq[l][k].getColor() != chessBoard.getMoveOrder()) {
                        PieceDto[][] squares = chessBoard.cloneBoard();
                        squares[l][k] = sq[i][j];
                        squares[i][j] = null;
                        ChessUtil.updateLocation(squares[l][k], l, k);
                        possibleBoards.add(squares);
                        break;
                    }

                    PieceDto[][] squares = chessBoard.cloneBoard();
                    squares[l][k] = sq[i][j];
                    squares[i][j] = null;
                    ChessUtil.updateLocation(squares[l][k], l, k);
                    possibleBoards.add(squares);
                    if (l == 7) break;
                } else break;
            }
        }
    }

    public static void moveLeftDownCross(ChessBoard chessBoard, PieceDto pieceDto, List<PieceDto[][]> possibleBoards) {

        int i = pieceDto.getLocationX();
        int j = pieceDto.getLocationY();
        PieceDto[][] sq = chessBoard.getSquares();

        if (i != 0 && j != 0) {
            int l = i - 1;
            for (int k = j - 1; k >= 0; k--, l--) {

                if (sq[l][k] == null ||
                        sq[l][k].getColor() != chessBoard.getMoveOrder()) {
                    if (sq[l][k] != null &&
                            sq[l][k].getColor() != chessBoard.getMoveOrder()) {
                        PieceDto[][] squares = chessBoard.cloneBoard();
                        squares[l][k] = sq[i][j];
                        squares[i][j] = null;
                        ChessUtil.updateLocation(squares[l][k], l, k);
                        possibleBoards.add(squares);
                        break;
                    }
                    PieceDto[][] squares = chessBoard.cloneBoard();
                    squares[l][k] = sq[i][j];
                    squares[i][j] = null;
                    ChessUtil.updateLocation(squares[l][k], l, k);
                    possibleBoards.add(squares);
                    if (l == 0) break;
                } else break;
            }
        }
    }
}
