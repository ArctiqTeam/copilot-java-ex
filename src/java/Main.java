package java;

import java.chess.ChessBoard;

public class Main {
    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard("Player1", "Player2");
        chessBoard.setInitialPosition();
        chessBoard.getFEN();
    }
}