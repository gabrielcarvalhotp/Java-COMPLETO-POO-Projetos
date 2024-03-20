package model.entities.chess;

import model.entities.board.Board;
import model.entities.board.Piece;
import model.entities.board.Position;
import model.entities.chess.exeptions.ChessExeption;
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

    private void placePiece(ChessPiece chessPiece, int row, char column) {
        board.placePiece(chessPiece, new ChessPosition(row, column).toPosition());
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        validadeSourcePosition(sourcePosition.toPosition());
        Piece piece = makeMove(sourcePosition.toPosition(), targetPosition.toPosition());
        return (ChessPiece) piece;
    }

    private void validadeSourcePosition(Position position) {
        if (!board.thereIsAPiece(position)) {
            throw new ChessExeption("There is no piece on source position");
        }
        if (!board.piece(position).isThereAnyPossibleMove()) {
            throw new ChessExeption("There is no possible moves for the chosen piece");
        }
    }

    private Piece makeMove(Position source, Position target) {
        Piece removedPiece = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(removedPiece, target);
        return  capturedPiece;
    }

    private void initialSetup() {
        placePiece(new King(board, Color.WHITE),1, 'a');
        placePiece(new Rook(board, Color.WHITE), 1,'b');

        placePiece(new King(board, Color.WHITE),8, 'a');
        placePiece(new Rook(board, Color.WHITE), 8,'b');
    }
}
