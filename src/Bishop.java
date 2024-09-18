public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (this.checkDirection(line, column, toLine, toColumn)) {
            if ((Math.abs(toLine - line) > 0) && (Math.abs(toColumn - column) == Math.abs(toLine - line))) {
                return this.checkBishopMoves(chessBoard, line, column, toLine, toColumn);
            }
        } else return false;
        return false;
    }

    @Override
    String getSymbol() {
        return "B";
    }
}
