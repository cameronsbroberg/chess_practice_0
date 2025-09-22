package chess;

import java.util.Collection;

public class BishopMoveGenerator extends MoveGenerator {

    public BishopMoveGenerator(ChessPosition startingPosition, ChessPiece piece, ChessBoard board) {
        super(startingPosition, piece, board);
    }

    @Override Collection<ChessMove> getMoves(){
        int[][] directions = {{1,1},{1,-1},{-1,1},{-1,-1}};
        for (int[] dir : directions){
            int x = startingPosition.getColumn();
            int y = startingPosition.getRow();
            while(true){
                x += dir[0];
                y += dir[1];
                if(x < 1 || x > 8 || y < 1 || y > 8){
                    break;
                }
                if(board.getPiece(new ChessPosition(y,x)) == null){
                    validMoves.add(new ChessMove(startingPosition, new ChessPosition(y,x),null));
                    continue;
                }
                if(board.getPiece(new ChessPosition(y,x)).getTeamColor() == piece.getTeamColor()){
                    break;
                }
                if(board.getPiece(new ChessPosition(y,x)).getTeamColor() != piece.getTeamColor()){
                    validMoves.add(new ChessMove(startingPosition,new ChessPosition(y,x),null));
                    break;
                }
            }
        }
        return validMoves;
    }
}
