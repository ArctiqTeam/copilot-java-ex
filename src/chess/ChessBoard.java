package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ChessBoard {
    private ChessSquare[][] board;
    private List<ChessPiece> capturedPieces;
    private List<String> moveList;
    private String player1;
    private String player2;
    private static final Logger LOGGER = Logger.getLogger(ChessBoard.class.getName());

    public ChessBoard(String player1, String player2) {
        this.board = new ChessSquare[8][8];
        this.capturedPieces = new ArrayList<>();
        this.moveList = new ArrayList<>();
        this.player1 = player1;
        this.player2 = player2;

        for (int rank = 0; rank < 8; rank++) {
            for (char file = 0; file < 8; file++) {
                String square = (char) (file + 'a') + Integer.toString(rank + 1);
                this.board[rank][file] = new ChessSquare(square);
            }
        }
    }

    // create method to set initial chess board position
    public void setInitialPosition() {
        // Set the initial position of the pieces on the board
        // For each color and set of pieces in ChessPiece
        // Use the addPiece method to add pieces to the board
        // Add the black pieces to the rows 7 and 8 and the white pieces to the rows 1 and 2

    }

    public boolean isValidPiece(String color, String piece) {
        // Attempt to create a new ChessPiece object with the given color and piece
        try {
            ChessPiece chessPiece = new ChessPiece(color, piece);
        } catch (IllegalArgumentException e) {
            // If an IllegalArgumentException is thrown, return false
            LOGGER.severe("Invalid piece: " + piece + " for color: " + color);
            return false;
        }
        // If the object is created successfully, return true, otherwise return false
        return true;
    }

    // validate the input square by coordinates
    public boolean isValidSquare(String square) {
        // Check if the input square coordinate is valid
        try {
            ChessSquare chessSquare = new ChessSquare(square);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Invalid square: " + square);
            return false;
        }
        return true;
    }

    public void addPiece(String color, String piece, String square) {
        // Validate the input piece and position
        ChessPiece to_add = null;
        ChessSquare target = null;
        try {
            to_add = new ChessPiece(color, piece);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid piece: " + piece + " for color: " + color);
        }
        try {
            target = new ChessSquare(square);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid square: " + square);
        }

        // Check if the square is occupied
        if(this.getPieceAt(square) != null) {
            LOGGER.severe("Square is occupied: " + square);
            LOGGER.severe("Piece: " + this.getPieceAt(square).toString());
            throw new IllegalArgumentException("Square is occupied: " + square);
        } else {
            // Add the piece to the board
            this.board[target.getRankIdx()][target.getFileIdx()].setPiece(to_add);
        }
    }

    public void removePiece(String square) {
        // Remove piece from the board
        ChessSquare target = new ChessSquare(square);
        if (this.getPieceAt(square) != null) this.board[target.getRankIdx()][target.getFileIdx()].clearPiece();
    }

    public void takePiece(String square, ChessPiece piece) {
        // Remove the piece from the board and add it to the capturedPieces list
        this.capturedPieces.add(this.getPieceAt(square));
        this.removePiece(square);
        this.addPiece(piece.getColor(), piece.getType(), square);
    }

    public ChessPiece getPieceAt(String square) {
        // Get the piece at the given square
        ChessSquare target = new ChessSquare(square);
        return this.board[target.getRankIdx()][target.getFileIdx()].getPiece();
    }

    public void makeMove(String move) {
        // Make a move and update the board, capturedPieces, and moveList
    }

    public String getFEN() {
        // Generate and return the FEN string
        return "";
    }
}