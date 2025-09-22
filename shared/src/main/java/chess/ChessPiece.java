package chess;

import java.util.Collection;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {
    private PieceType pieceType;
    private final ChessGame.TeamColor color;
    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.pieceType = type;
        this.color = pieceColor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessPiece that = (ChessPiece) o;
        return pieceType.equals(that.pieceType) && color.equals(that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceType, color);
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return this.color;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return this.pieceType;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        switch(pieceType){
            case KING:
                return new KingMoveGenerator(myPosition,this,board).getMoves();
            case QUEEN:
                Collection<ChessMove> diagonals = new BishopMoveGenerator(myPosition,this,board).getMoves();
                Collection<ChessMove> slides = new RookMoveGenerator(myPosition,this,board).getMoves();
                diagonals.addAll(slides);
                return diagonals;
            case BISHOP:
                return new BishopMoveGenerator(myPosition,this,board).getMoves();
            case KNIGHT:
                return new KnightMoveGenerator(myPosition,this,board).getMoves();
            case ROOK:
                return new RookMoveGenerator(myPosition,this,board).getMoves();
            case PAWN:
                return new PawnMoveGenerator(myPosition,this,board).getMoves();
        }
    return null;
    }
}
