package net.abidinozdurmaz.chess.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.abidinozdurmaz.chess.type.Color;
import net.abidinozdurmaz.chess.type.PieceType;

import java.util.Objects;

import static net.abidinozdurmaz.chess.type.PieceType.ROOK;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ChessBoard {
    private PieceDto[][] squares;
    private Color moveOrder;

    public static PieceDto[][] startingSequence() {
        PieceDto[][] squares = new PieceDto[8][8];

        squares[0][0] = new PieceDto(ROOK, 0, 0, Color.WHITE);
        squares[1][0] = new PieceDto(PieceType.KNIGHT, 1, 0, Color.WHITE);
        squares[2][0] = new PieceDto(PieceType.BISHOP, 2, 0, Color.WHITE);
        squares[3][0] = new PieceDto(PieceType.QUEEN, 3, 0, Color.WHITE);
        squares[4][0] = new PieceDto(PieceType.KING, 4, 0, Color.WHITE);
        squares[5][0] = new PieceDto(PieceType.BISHOP, 5, 0, Color.WHITE);
        squares[6][0] = new PieceDto(PieceType.KNIGHT, 6, 0, Color.WHITE);
        squares[7][0] = new PieceDto(PieceType.ROOK, 7, 0, Color.WHITE);
        squares[0][1] = new PieceDto(PieceType.PAWN, 0, 1, Color.WHITE);
        squares[1][1] = new PieceDto(PieceType.PAWN, 1, 1, Color.WHITE);
        squares[2][1] = new PieceDto(PieceType.PAWN, 2, 1, Color.WHITE);
        squares[3][1] = new PieceDto(PieceType.PAWN, 3, 1, Color.WHITE);
        squares[4][1] = new PieceDto(PieceType.PAWN, 4, 1, Color.WHITE);
        squares[5][1] = new PieceDto(PieceType.PAWN, 5, 1, Color.WHITE);
        squares[6][1] = new PieceDto(PieceType.PAWN, 6, 1, Color.WHITE);
        squares[7][1] = new PieceDto(PieceType.PAWN, 7, 1, Color.WHITE);

        squares[0][6] = new PieceDto(PieceType.PAWN, 0, 6, Color.BLACK);
        squares[1][6] = new PieceDto(PieceType.PAWN, 1, 6, Color.BLACK);
        squares[2][6] = new PieceDto(PieceType.PAWN, 2, 6, Color.BLACK);
        squares[3][6] = new PieceDto(PieceType.PAWN, 3, 6, Color.BLACK);
        squares[4][6] = new PieceDto(PieceType.PAWN, 4, 6, Color.BLACK);
        squares[5][6] = new PieceDto(PieceType.PAWN, 5, 6, Color.BLACK);
        squares[6][6] = new PieceDto(PieceType.PAWN, 6, 6, Color.BLACK);
        squares[7][6] = new PieceDto(PieceType.PAWN, 7, 6, Color.BLACK);
        squares[0][7] = new PieceDto(PieceType.ROOK, 0, 7, Color.BLACK);
        squares[1][7] = new PieceDto(PieceType.KNIGHT, 1, 7, Color.BLACK);
        squares[2][7] = new PieceDto(PieceType.BISHOP, 2, 7, Color.BLACK);
        squares[3][7] = new PieceDto(PieceType.QUEEN, 3, 7, Color.BLACK);
        squares[4][7] = new PieceDto(PieceType.KING, 4, 7, Color.BLACK);
        squares[5][7] = new PieceDto(PieceType.BISHOP, 5, 7, Color.BLACK);
        squares[6][7] = new PieceDto(PieceType.KNIGHT, 6, 7, Color.BLACK);
        squares[7][7] = new PieceDto(PieceType.ROOK, 7, 7, Color.BLACK);
        return squares;
    }

    public PieceDto[][] cloneBoard() {
        PieceDto[][] cloneSquare = new PieceDto[8][8];
        for (int j = 0; j < cloneSquare.length; j++) {
            for (int k = 0; k < cloneSquare.length; k++) {
                PieceDto pieceDto = this.squares[j][k];
                if (Objects.nonNull(pieceDto)) {
                    cloneSquare[j][k] = new PieceDto(pieceDto.getPieceType(), j, k, pieceDto.getColor());
                }
            }
        }
        return cloneSquare;
    }
}
