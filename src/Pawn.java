public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (this.checkDirection(line, column, toLine, toColumn)) {
            if ((this.color.equals("White") && line == 1 && toLine == 3 && toColumn - column == 0 && chessBoard.board[2][toColumn] == null)
                    || (this.color.equals("Black") && line == 6 && toLine == 4 && toColumn - column == 0 && chessBoard.board[5][toColumn] == null)
                    || (this.color.equals("White") && toLine - line == 1 && toColumn - column == 0 && chessBoard.board[toLine][toColumn] == null)
                    || (this.color.equals("Black") && toLine - line == -1 && toColumn - column == 0 && chessBoard.board[toLine][toColumn] == null)
                    || (this.color.equals("White") && toLine - line == 1 && Math.abs(toColumn - column) == 1 && chessBoard.board[toLine][toColumn].getColor().equals("Black"))
                    || (this.color.equals("Black") && toLine - line == -1 && Math.abs(toColumn - column) == 1) && chessBoard.board[toLine][toColumn].getColor().equals("White"))
                if (chessBoard.board[toLine][toColumn] != null) {
                    this.pawnToQueenAttack(chessBoard, line, column, toLine, toColumn);
                    return !chessBoard.board[toLine][toColumn].getColor().equals(color);
                } else {
                    this.pawnToQueen(chessBoard, line, column, toLine, toColumn);
                    return true;
                }
        }
        return false;
    }

    @Override
    String getSymbol() {
        return "P";
    }
}

