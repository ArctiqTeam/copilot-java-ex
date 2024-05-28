package com.arctiq.chess;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessSquareTest {

    @Test
    void getColorReturnsDarkForDarkSquare() {
        ChessSquare square = new ChessSquare("a1");
        assertEquals("dark", square.getColor());
    }

    @Test
    void getColorReturnsLightForLightSquare() {
        ChessSquare square = new ChessSquare("a2");
        assertEquals("light", square.getColor());
    }

    @Test
    void getRankReturnsCorrectRank() {
        ChessSquare square = new ChessSquare("a7");
        assertEquals(7, square.getRank());
    }

    @Test
    void getFileReturnsCorrectFile() {
        ChessSquare square = new ChessSquare("h1");
        assertEquals('h', square.getFile());
    }

    @Test
    void getSquareReturnsCorrectSquare() {
        ChessSquare square = new ChessSquare("e5");
        assertEquals("e5", square.getSquare());
    }

    @Test
    void isOccupiedReturnsFalseWhenNoPiece() {
        ChessSquare square = new ChessSquare("d4");
        assertFalse(square.isOccupied());
    }

    @Test
    void isOccupiedReturnsTrueWhenPiecePresent() {
        ChessSquare square = new ChessSquare("d4");
        square.setPiece(new ChessPiece("white", "rook"));
        assertTrue(square.isOccupied());
    }

    @Test
    void getPieceReturnsNullWhenNoPiece() {
        ChessSquare square = new ChessSquare("d4");
        assertNull(square.getPiece());
    }

    @Test
    void getPieceReturnsCorrectPieceWhenPiecePresent() {
        ChessSquare square = new ChessSquare("d4");
        ChessPiece piece = new ChessPiece("white", "rook");
        square.setPiece(piece);
        assertEquals(piece, square.getPiece());
    }

    @Test
    void setPieceSetsPieceCorrectly() {
        ChessSquare square = new ChessSquare("d4");
        ChessPiece piece = new ChessPiece("white", "rook");
        square.setPiece(piece);
        assertEquals(piece, square.getPiece());
    }

    @Test
    void clearPieceRemovesPiece() {
        ChessSquare square = new ChessSquare("d4");
        ChessPiece piece = new ChessPiece("white", "rook");
        square.setPiece(piece);
        square.clearPiece();
        assertNull(square.getPiece());
    }

    @Test
    void constructorThrowsExceptionForInvalidSquare() {
        assertThrows(IllegalArgumentException.class, () -> new ChessSquare("i9"));
    }

    @Test
    void constructorThrowsExceptionForInvalidRank() {
        assertThrows(IllegalArgumentException.class, () -> new ChessSquare("a9"));
    }

    @Test
    void constructorThrowsExceptionForInvalidFile() {
        assertThrows(IllegalArgumentException.class, () -> new ChessSquare("i1"));
    }
}