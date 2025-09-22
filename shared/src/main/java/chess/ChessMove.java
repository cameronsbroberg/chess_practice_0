package chess;

import java.util.Objects;

/**
 * Represents moving a chess piece on a chessboard
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessMove {
    ChessPosition startPosition;
    ChessPosition endPosition;
    ChessPiece.PieceType promotionPiece;

    public ChessMove(ChessPosition startPosition, ChessPosition endPosition, ChessPiece.PieceType promotionPiece) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.promotionPiece = promotionPiece;
    }

    /**
     * @return ChessPosition of starting location
     */
    public ChessPosition getStartPosition() {
        return startPosition;
    }

    /**
     * @return ChessPosition of ending location
     */
    public ChessPosition getEndPosition() {
        return this.endPosition;
    }

    /**
     * Gets the type of piece to promote a pawn to if pawn promotion is part of this
     * chess move
     *
     * @return Type of piece to promote a pawn to, or null if no promotion
     */
    public ChessPiece.PieceType getPromotionPiece() {
        return this.promotionPiece;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessMove chessMove = (ChessMove) o;
//        if(((ChessMove) o).promotionPiece == null ^ promotionPiece == null){
//            return false;
//        }
//        if(((ChessMove) o).promotionPiece == null && promotionPiece == null){
//            return startPosition.equals(((ChessMove) o).startPosition) && endPosition.equals(((ChessMove) o).endPosition);
//        }
        return startPosition.equals(((ChessMove) o).startPosition) && endPosition.equals(((ChessMove) o).endPosition) && promotionPiece == ((ChessMove) o).promotionPiece;//promotionPiece.equals(((ChessMove) o).promotionPiece);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPosition, endPosition, promotionPiece);
    }

    @Override
    public String toString() {
        return "ChessMove{" + startPosition +
                "," + endPosition +
                "," + promotionPiece +
                '}';
    }
}
