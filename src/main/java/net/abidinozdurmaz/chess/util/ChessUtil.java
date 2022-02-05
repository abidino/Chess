package net.abidinozdurmaz.chess.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.abidinozdurmaz.chess.dto.PieceDto;
import net.abidinozdurmaz.chess.type.Color;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChessUtil {

    public static PieceDto[][] spinBoard(PieceDto[][] squares) {

        PieceDto[][] spinBoardList = new PieceDto[8][8];

        for (int i = 0; i < spinBoardList.length; i++) {
            for (int j = 0; j < spinBoardList.length; j++) {
                spinBoardList[i][j] = squares[7 - i][7 - j];
                updateLocation(spinBoardList[i][j], i, j);
            }
        }
        return spinBoardList;
    }


    private static int getTotalPoints(PieceDto[][] squares) {

        int totalWhitePoints = 0;
        int totalBlackPoints = 0;

        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                PieceDto pieceDto = squares[i][j];
                if (pieceDto != null) {
                    if (pieceDto.getColor() == Color.BLACK) {
                        totalBlackPoints += pieceDto.getPieceType().getPoint();
                    } else {
                        totalWhitePoints += pieceDto.getPieceType().getPoint();
                    }
                }
            }
        }

        return totalWhitePoints - totalBlackPoints;
    }

    public static PieceDto[][] bestMove(List<PieceDto[][]> pieceDtos) {

        if (CollectionUtils.isEmpty(pieceDtos)) {
            return new PieceDto[0][0];
        }

        PieceDto[][] bestMove = pieceDtos.get(0);
        int maxPoints = getTotalPoints(bestMove);

        for (PieceDto[][] pieceDto : pieceDtos) {
            int totalPoints = getTotalPoints(pieceDto);
            if (totalPoints > maxPoints) {
                bestMove = pieceDto;
            }
        }

        return bestMove;
    }

    public static void updateLocation(PieceDto pieceDto, int x, int y) {
        if (Objects.nonNull(pieceDto)) {
            pieceDto.setLocationX(x);
            pieceDto.setLocationY(y);
        }
    }
}
