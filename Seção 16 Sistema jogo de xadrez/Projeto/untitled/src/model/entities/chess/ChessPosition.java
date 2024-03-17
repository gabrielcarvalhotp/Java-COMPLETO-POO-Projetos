package model.entities.chess;

import model.entities.board.Position;
import model.entities.chess.exeptions.ChessExeption;

public class ChessPosition {

    private Integer row;
    private Character column;

    public ChessPosition(Integer row, Character column) {
        if (row < 1 || row > 8 || column < 'a' || column > 'h') {
            throw new ChessExeption("Error instantiating ChessPosition: Valid values are from a1 to h8");
        }
        this.row = row;
        this.column = column;
    }

    public Integer getRow() {
        return row;
    }

    public Character getColumn() {
        return column;
    }

    protected Position toPosition() {
        return new Position(8 - row, column - 'a');
    }

    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition(8 - position.getRow(), (char) ('a' - position.getColumn()));
    }

    @Override
    public String toString() {
        return "" + column + row;
    }
}
