package chess;

import java.util.Collection;

public class PawnMoveGenerator extends MoveGenerator{
    public PawnMoveGenerator(ChessPosition startingPosition, ChessPiece piece, ChessBoard board) {
        super(startingPosition, piece, board);
    }
    private void promote(ChessPosition target){
        if(target.getRow() > 8 || target.getRow() < 1 || target.getColumn() < 1 || target.getColumn() > 8){
            return;
        }
        if(target.getRow() == 8 || target.getRow() == 1){
            ChessPiece.PieceType[] promotions = {
                    ChessPiece.PieceType.KNIGHT,
                    ChessPiece.PieceType.BISHOP,
                    ChessPiece.PieceType.ROOK,
                    ChessPiece.PieceType.QUEEN
            };
            for(ChessPiece.PieceType promotion : promotions){
                validMoves.add(new ChessMove(startingPosition,target,promotion));
            }
        } else{
            validMoves.add(new ChessMove(startingPosition,target,null));
        }
    }
    @Override
    Collection<ChessMove> getMoves() {
        int row = startingPosition.getRow();
        int col = startingPosition.getColumn();
        int[][] captures;
        if(piece.getTeamColor() == ChessGame.TeamColor.WHITE){
            captures = new int[][]{{1, -1}, {1, 1}};
        }
        else{
            captures = new int[][]{{-1, -1},{-1,1}};
        }
        for(int[] capture : captures){
            if (col + capture[1] > 8 || col + capture[1] < 1){
                continue;
            }
            ChessPosition target = new ChessPosition(row + capture[0],col + capture[1]);
            if(board.getPiece(target) == null){
                continue;
            } else if(board.getPiece(target).getTeamColor() != piece.getTeamColor()) {
                promote(target);
            }
        }
//        if (piece.getTeamColor() == ChessGame.TeamColor.WHITE){
//            int targetRow = row + 1;
//            ChessPosition targetPosition = new ChessPosition(targetRow,col);
//            if(!(targetRow > 8) && board.getPiece(targetPosition) == null){
//                promote(targetPosition);
//                if(row == 2 && board.getPiece(new ChessPosition(row + 2,col)) == null){
//                    validMoves.add(new ChessMove(startingPosition,new ChessPosition(row + 2,col),null));
//                }
//            }
//        }
//        else{
//            int targetRow = row - 1;
//            ChessPosition targetPosition = new ChessPosition(targetRow,col);
//            if(!(targetRow < 1) && board.getPiece(targetPosition) == null){
//                promote(targetPosition);
//                if(row == 7 && board.getPiece(new ChessPosition(row + 2,col)) == null){
//                    validMoves.add(new ChessMove(startingPosition,new ChessPosition(row + 2,col),null));
//                }
//            }
//        }
        int targetRow;
        if(piece.getTeamColor() == ChessGame.TeamColor.WHITE){targetRow = 1;} else { targetRow = -1;}
        ChessPosition target = new ChessPosition(row + targetRow,col);
        if(board.getPiece(target) == null) {
            promote(new ChessPosition(row + targetRow, col));
            if (row == 2 && piece.getTeamColor() == ChessGame.TeamColor.WHITE) {
                int doubleMoveTargetRow = row + 2;
                if (board.getPiece(new ChessPosition(doubleMoveTargetRow, col)) == null) {
                    validMoves.add(new ChessMove(startingPosition, new ChessPosition(doubleMoveTargetRow, col), null));
                }
            }
            if (row == 7 && piece.getTeamColor() == ChessGame.TeamColor.BLACK) {
                int doubleMoveTargetRow = row - 2;
                if (board.getPiece(new ChessPosition(doubleMoveTargetRow, col)) == null) {
                    validMoves.add(new ChessMove(startingPosition, new ChessPosition(row - 2, col), null));
                }
            }
        }
        return validMoves;
    }
}
