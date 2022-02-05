package net.abidinozdurmaz.chess.dto;

import lombok.Getter;
import lombok.Setter;
import net.abidinozdurmaz.chess.type.Color;
import net.abidinozdurmaz.chess.type.PieceType;

@Getter
@Setter
public class PieceDto {
    protected int locationX;
    protected int locationY;
    protected Color color;
    protected PieceType pieceType;

    public PieceDto(PieceType pieceType, int locationX, int locationY, Color color) {
        this.pieceType = pieceType;
        this.locationX = locationX;
        this.locationY = locationY;
        this.color = color;
    }
}
