package model.entities.chess;

import model.entities.board.Board;
import model.entities.board.Piece;
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
