package chess;

import java.util.Collection;

public class KingMoveGenerator extends MoveGenerator{

    public KingMoveGenerator(ChessPosition startingPosition, ChessPiece piece, ChessBoard board) {
        super(startingPosition, piece, board);
    }
    private void checkValidity(int targetRow, int targetCol){
        if(!(targetRow < 1 || targetRow > 8 || targetCol < 1 || targetCol > 8)) {
            if (board.getPiece(new ChessPosition(targetRow, targetCol)) == null) {
                validMoves.add(new ChessMove(startingPosition, new ChessPosition(targetRow, targetCol), null));
            } else if (board.getPiece(new ChessPosition(targetRow, targetCol)).getTeamColor() != piece.getTeamColor()) {
                validMoves.add(new ChessMove(startingPosition, new ChessPosition(targetRow, targetCol), null));
            }
        }
    }
    @Override
    Collection<ChessMove> getMoves() {
        int[][] directions = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
        for(int[] dir : directions){
            int row = startingPosition.getRow();
            int col = startingPosition.getColumn();
            int targetRow = row + dir[0];
            int targetCol = col + dir[1];
            checkValidity(targetRow, targetCol);
        }
        return validMoves;
    }
}
