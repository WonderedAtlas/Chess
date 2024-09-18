public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (this.checkDirection(line, column, toLine, toColumn)) {
            if ((Math.abs(toLine - line) > 0 && toColumn - column == 0)
                    || (Math.abs(toColumn - column) > 0 && toLine - line == 0)) {
                return this.checkRookMoves(chessBoard, line, column, toLine, toColumn);
            }
        } else return false;
        return false;
    }

    @Override
    String getSymbol() {
        return "R";
    }
}
