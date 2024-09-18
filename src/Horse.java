public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (this.checkDirection(line, column, toLine, toColumn)) {
            if ((Math.abs(toLine - line) == 2 && Math.abs(toColumn - column) == 1) || (Math.abs(toColumn - column) == 2 && Math.abs(toLine - line) == 1)) {
                if (chessBoard.board[toLine][toColumn] != null) {
                    return !chessBoard.board[toLine][toColumn].getColor().equals(color);
                } else return true;
            }
        }
        return false;
    }

    @Override
    String getSymbol() {
        return "H";
    }
}
