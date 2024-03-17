package model.entities.board;

import model.entities.board.exceptions.BoardException;

public class Board {
    private Integer rows;

    private Integer columns;

    private Piece[][] pieces;

    public Board() {

    }

    public Board(Integer rows, Integer columns) {
        if (rows < 1 && columns < 1) {
            throw new BoardException("Error create board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        this.pieces = new Piece[rows][columns];
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getColumns() {
        return columns;
    }

    public Piece piece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on de board");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on de board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("There is aready a piece on position " + position);
        }
        this.pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position) {
        Piece piece = piece(position);
        if (piece == null) {
            return null;
        }
        pieces[position.getRow()][position.getColumn()] = null;
        return piece;
    }

    public boolean positionExists(int row, int column) {
        return row >= 0 && row <= rows && columns >= 0 && column <= columns;
    }
    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on de board");
        }
        return piece(position) != null;
    }
}
