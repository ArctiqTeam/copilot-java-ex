package com.arctiq.chess;

import java.util.HashMap;
import java.util.Map;

public class ChessPiece {
    private final String color;
    private final String type;
    private static final Map<String, String> pieceMap;

    static {
        pieceMap = new HashMap<>();
        pieceMap.put("pawn", "p");
        pieceMap.put("knight", "n");
        pieceMap.put("bishop", "b");
        pieceMap.put("rook", "r");
        pieceMap.put("queen", "q");
        pieceMap.put("king", "k");
    }

    public ChessPiece(String color, String type) {
        if (!isValidColor(color) || !isValidType(type)) {
            throw new IllegalArgumentException("Invalid color or type");
        }
        this.color = color;
        this.type = type;
    }

    private boolean isValidColor(String color) {
        return color.equals("white") || color.equals("black");
    }

    private boolean isValidType(String type) {
        return pieceMap.containsKey(type);
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return color + " " + type;
    }

    public String toFEN() {
        String pieceChar = pieceMap.get(type);
        return color.equals("white") ? pieceChar.toUpperCase() : pieceChar;
    }
}