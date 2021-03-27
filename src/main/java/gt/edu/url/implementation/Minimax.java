package gt.edu.url.implementation;

import gt.edu.url.adapter.Board;
import gt.edu.url.adapter.Piece;

import java.util.Random;

public class Minimax {
    // Encuentra la mejor utilidad para el jugador originalPlayer
    public static <Move> double minimax(Board<Move> board, boolean maximizing, Piece originalPlayer, int maxDepth) {
        if(board.isWin() || board.isDraw() || maxDepth == 0){
            return board.evaluate(originalPlayer);
        }
        if (maximizing) {
            var higher = Double.NEGATIVE_INFINITY;
            for (Move data : board.getLegalMoves()) {
                var temp = minimax(board.move(data), false, originalPlayer, maxDepth - 1);
                higher = Math.max(temp, higher);
            }
            return higher;
        } else {
            var less = Double.POSITIVE_INFINITY;
            for (Move data : board.getLegalMoves()) {
                double temp = minimax(board.move(data), true, originalPlayer, maxDepth - 1);
                less = Math.min(temp, less);
            }
            return less;
        }

    }

    public static <Move> Move findBestMove(Board<Move> board, int maxDepth) {
        double bestEval = Double.NEGATIVE_INFINITY;
        Move bestMove = null; // won't stay null for sure
        for (Move move : board.getLegalMoves()) {
            double result = minimax(board.move(move), false, board.getTurn(),
                    maxDepth);
            if (result > bestEval) {
                bestEval = result;
                bestMove = move;
            }
        }
        return bestMove;
    }
}
