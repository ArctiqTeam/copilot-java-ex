package com.arctiq.chess;

public class ChessSquare {
    private final boolean isDark;
    private final int rank;
    private final int rank_idx;
    private final char file;
    private final int file_idx;
    private boolean occupied;
    private ChessPiece piece;

    public ChessSquare(String square) {
        if (square.length() != 2) {
            throw new IllegalArgumentException("Invalid square. Square must be in the format of file and rank (e.g. a1)");
        }
        char file = square.charAt(0);
        int rank = Integer.parseInt(square.substring(1));
        if (rank < 1 || rank > 8) {
            throw new IllegalArgumentException("Invalid rank. Rank must be within the range of 1-8");
        }
        if (file < 'a' || file > 'h') {
            throw new IllegalArgumentException("Invalid file. File must be within the range of a-h");
        }
        this.isDark = ((rank + (file - 'a')) % 2) == 0;
        this.rank = rank;
        this.rank_idx = rank - 1;
        this.file = file;
        this.file_idx = file - 'a';
        this.occupied = false;
        this.piece = null;
    }

    public String getColor() {
        if (isDark) {
            return "dark";
        } else {
            return "light";
        }
    }

    public int getRank() {
        return rank;
    }

    public int getRankIdx() {
        return rank_idx;
    }

    public char getFile() {
        return file;
    }

    public int getFileIdx() {
        return file_idx;
    }

    public String getSquare() {
        return file + Integer.toString(rank);
    }

    public boolean isOccupied() {
        return occupied;
    }

    public ChessPiece getPiece() {
        return piece;
    }

    public void setPiece(ChessPiece piece) {
        this.piece = piece;
        this.occupied = piece != null;
    }

    public void clearPiece() {
        this.piece = null;
        this.occupied = false;
    }
}