import model.entities.chessLayer.ChessMatch;
import services.UserInterface;

public class Main {
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        UserInterface.printBoard(chessMatch.getPieces());
    }
}