package chess;

import java.util.Collection;

public class KnightMoveGenerator extends MoveGenerator{
    public KnightMoveGenerator(ChessPosition startingPosition, ChessPiece piece, ChessBoard board) {
        super(startingPosition, piece, board);
    }

    private void checkValidity(int targetRow, int targetCol){
        if()
    }
    @Override
    Collection<ChessMove> getMoves() {
        int[][] directions = {{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
        for (int[] dir : directions){
            int row = startingPosition.getRow();
            int col = startingPosition.getColumn();
            int targetRow = row + dir[0];
            int targetCol = col + dir[1];
            ChessPosition target = new ChessPosition(targetRow,targetCol);
            checkValidity(target);
        }
        return validMoves;
    }
}
