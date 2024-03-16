package model.entities.chess.pieces;

import model.entities.board.Board;
import model.entities.chess.ChessPiece;
import model.enums.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }
}
