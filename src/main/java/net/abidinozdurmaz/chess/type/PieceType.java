package net.abidinozdurmaz.chess.type;

import lombok.Getter;

@Getter
public enum PieceType {
    PAWN(1), KNIGHT(3), BISHOP(3), ROOK(5), QUEEN(8), KING(100);

    private final int point;

    PieceType(int point) {
        this.point = point;
    }
}
