package model.entities.chess;

import model.entities.board.Board;
import model.entities.board.Position;
import model.entities.chess.pieces.King;
import model.entities.chess.pieces.Rook;
import model.enums.Color;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] chessPieces = new ChessPiece[board.getRows()][board.getColumns()];

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                chessPieces[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return chessPieces;
    }

    private void initialSetup() {
        board.placePiece(new King(board, Color.BLACK), new Position(2, 0));
        board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
    }
}
