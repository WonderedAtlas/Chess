public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (this.checkDirection(line, column, toLine, toColumn)) {
            if (Math.abs(toLine - line) <= 1 && Math.abs(toColumn - column) <= 1 && (toLine != line || toColumn != column)) {
                if (this.isUnderAttack(chessBoard, toLine, toColumn)) {
                    return false;
                } else if (chessBoard.board[toLine][toColumn] != null) {
                    return !chessBoard.board[toLine][toColumn].getColor().equals(color);
                } else return true;
            }
        } else return false;
        return false;
    }

    boolean isUnderAttack(ChessBoard board, int line, int column) {
        if (this.checkDirection(line, column)) {
            for (int i = 0; i < board.board.length; ++i) {
                for (int j = 0; j < board.board[0].length; ++j) {
                    if (board.board[i][j] != null && !board.board[i][j].getColor().equals(this.color) && board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    String getSymbol() {
        return "K";
    }
}



