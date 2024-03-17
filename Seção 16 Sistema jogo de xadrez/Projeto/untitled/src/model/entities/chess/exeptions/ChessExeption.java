package model.entities.chess.exeptions;

import model.entities.board.exceptions.BoardException;

public class ChessExeption extends BoardException {
    public ChessExeption(String message) {
        super(message);
    }
}
