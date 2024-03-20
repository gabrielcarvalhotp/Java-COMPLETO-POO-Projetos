import model.entities.chess.ChessMatch;
import model.entities.chess.ChessPiece;
import model.entities.chess.ChessPosition;
import model.entities.chess.exeptions.ChessExeption;
import services.UserInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        while (true) {
            try {
                UserInterface.clearScreen();
                UserInterface.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UserInterface.readChessPosition(scanner);
                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UserInterface.readChessPosition(scanner);
                ChessPiece chessPiece = chessMatch.performChessMove(source, target);
            } catch (ChessExeption | InputMismatchException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
    }
}