package com.arctiq.chess;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a chess piece with a color and type.
 */
public class ChessPiece {
    private final String color;
    private final String type;
    private static final Map<String, String> pieceMap;

    /*
      Static initializer block to populate the pieceMap with chess piece types
      and their corresponding FEN notation.
     */
    static {
        pieceMap = new HashMap<>();
        pieceMap.put("pawn", "p");
        pieceMap.put("knight", "n");
        pieceMap.put("bishop", "b");
        pieceMap.put("rook", "r");
        pieceMap.put("queen", "q");
        pieceMap.put("king", "k");
    }

    /**
     * Constructs a ChessPiece with the specified color and type.
     * @param color the color of the chess piece, either "white" or "black".
     * @param type the type of the chess piece, e.g., "pawn", "knight", "bishop", etc.
     * @throws IllegalArgumentException if the color or type is invalid.
     */
    public ChessPiece(String color, String type) {
        if (!isValidColor(color) || !isValidType(type)) {
            throw new IllegalArgumentException("Invalid color or type");
        }
        this.color = color;
        this.type = type;
    }

    /**
     * Checks if the specified color is valid.
     * @param color the color to check.
     * @return true if the color is "white" or "black", false otherwise.
     */
    private boolean isValidColor(String color) {
        return color.equals("white") || color.equals("black");
    }

    /**
     * Checks if the specified type is valid.
     * @param type the type to check.
     * @return true if the type is a key in the pieceMap, false otherwise.
     */
    private boolean isValidType(String type) {
        return pieceMap.containsKey(type);
    }

    /**
     * Returns the color of this ChessPiece.
     * @return the color of this ChessPiece.
     */
    public String getColor() {
        return color;
    }

    /**
     * Returns the type of this ChessPiece.
     * @return the type of this ChessPiece.
     */
    public String getType() {
        return type;
    }

    /**
     * Returns a string representation of this ChessPiece.
     * @return a string representation of this ChessPiece in the format "color type".
     */
    public String toString() {
        return color + " " + type;
    }

    /**
     * Returns the FEN notation of this ChessPiece.
     * @return the FEN notation of this ChessPiece. The notation is uppercase if the color is "white", lowercase otherwise.
     */
    public String toFEN() {
        String pieceChar = pieceMap.get(type);
        return color.equals("white") ? pieceChar.toUpperCase() : pieceChar;
    }
}