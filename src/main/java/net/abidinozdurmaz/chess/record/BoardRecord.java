package net.abidinozdurmaz.chess.record;

import net.abidinozdurmaz.chess.dto.ChessBoard;
import net.abidinozdurmaz.chess.dto.PieceDto;
import net.abidinozdurmaz.chess.type.Color;
import net.abidinozdurmaz.chess.util.ChessUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public record BoardRecord(FacadeRecord facadeRecord) {

    public ChessBoard move(ChessBoard chessBoard) {
        List<PieceDto[][]> possibleMoves = new ArrayList<>();

        if (chessBoard.getMoveOrder() == Color.BLACK) {
            chessBoard.setSquares(ChessUtil.spinBoard(chessBoard.getSquares()));
        }
        PieceDto[][] squares = chessBoard.getSquares();

        for (int i = 0; i < chessBoard.getSquares().length; i++) {
            for (int j = 0; j < chessBoard.getSquares().length; j++) {
                if (Objects.nonNull(chessBoard.getSquares()[i][j]) && chessBoard.getMoveOrder() == chessBoard.getSquares()[i][j].getColor()) {
                    possibleMoves.addAll(facadeRecord.possibleMoves(chessBoard, squares[i][j]));
                }
            }
        }

        PieceDto[][] pieceDto = ChessUtil.bestMove(possibleMoves);
        if (chessBoard.getMoveOrder() == Color.BLACK) {
            chessBoard.setSquares(ChessUtil.spinBoard(pieceDto));
            chessBoard.setMoveOrder(Color.WHITE);
        } else {
            chessBoard.setSquares(pieceDto);
            chessBoard.setMoveOrder(Color.BLACK);
        }
        return chessBoard;
    }

}
