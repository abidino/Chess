package net.abidinozdurmaz.chess.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.abidinozdurmaz.chess.type.Color;
import net.abidinozdurmaz.chess.type.PieceType;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class PieceDto {
    protected PieceType pieceType;
    @NotNull
    protected int locationX;
    protected int locationY;
    protected Color color;


}
