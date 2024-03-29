package services;

import model.entities.chess.ChessPiece;
import model.entities.chess.ChessPosition;
import model.entities.chess.exeptions.ChessExeption;
import model.enums.Color;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printBoard(ChessPiece[][] chessPieces) {
        for (int i = 0; i < chessPieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < chessPieces.length; j++) {
                printPiece(chessPieces[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    private static void printPiece(ChessPiece chessPiece) {
        if (chessPiece == null) {
            System.out.print("- " + ANSI_RESET);
        }
        else {
            if (chessPiece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + chessPiece + ANSI_RESET);
            } else {
                System.out.print(ANSI_YELLOW + chessPiece + ANSI_RESET);
            }
            System.out.print(" ");
        }
    }

    public static ChessPosition readChessPosition(Scanner scanner) {
        try {
            String position = scanner.nextLine();
            int row = Integer.parseInt(position.substring(1));
            char column = position.charAt(0);
            return new ChessPosition(row, column);
        } catch (ChessExeption e) {
            throw new ChessExeption(e.getMessage());
        } catch (RuntimeException e) {
            throw new InputMismatchException("Error reading ChessPosition: Valid values are from a1 to h8");
        }
    }

}
