package chess;

import java.util.ArrayList;
import java.util.Collection;

public class MoveGenerator {
    protected ChessPosition startingPosition;
    protected ChessPiece piece;
    protected Collection<ChessMove> validMoves;
    protected ChessBoard board;

    public MoveGenerator(ChessPosition startingPosition, ChessPiece piece, ChessBoard board) {
        this.startingPosition = startingPosition;
        this.piece = piece;
        this.validMoves = new ArrayList<>();
        this.board = board;
    }
    Collection <ChessMove> getMoves(){
        return validMoves;
    }
}
