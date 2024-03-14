package model.entities.boardLayer;

public class Piece {

    protected Position position;
    private Board board;

    public Piece() {

    }

    public Piece(Board board) {
        this.board = board;
        this.position = null;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    protected Board getBoard() {
        return board;
    }
}
