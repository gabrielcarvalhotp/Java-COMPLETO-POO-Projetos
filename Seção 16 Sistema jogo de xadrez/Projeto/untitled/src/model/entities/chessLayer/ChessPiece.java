package model.entities.chessLayer;

import model.entities.boardLayer.Board;
import model.entities.boardLayer.Piece;
import model.enums.Color;

public class ChessPiece extends Piece {

    private final Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
