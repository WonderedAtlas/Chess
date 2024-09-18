public abstract class ChessPiece {

    String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public boolean checkDirection(int line, int column, int toLine, int toColumn) {
        return (line >= 0 && line <= 7 && column >= 0 && column <= 7 && toLine >= 0 && toLine <= 7 && toColumn >= 0 && toColumn <= 7);
    }

    public boolean checkDirection(int line, int column) {
        return (line >= 0 && line <= 7 && column >= 0 && column <= 7);
    }

    public abstract String getColor();

    abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    abstract String getSymbol();

    public boolean checkRookMoves(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine - line == 0) {
            if (toColumn > column) {
                for (int i = column + 1; i < toColumn; i++) {
                    if (chessBoard.board[toLine][i] != null) return false;
                }
            } else if (toColumn < column) {
                for (int i = column - 1; i > toColumn; i--) {
                    if (chessBoard.board[toLine][i] != null) return false;
                }
            }
        } else {
            if (toLine > line) {
                for (int i = line + 1; i < toLine; i++) {
                    if (chessBoard.board[i][toColumn] != null) return false;
                }
            } else {
                for (int i = line - 1; i > toLine; i--) {
                    if (chessBoard.board[i][toColumn] != null) return false;
                }
            }
        }
        if (chessBoard.board[toLine][toColumn] != null) {
            return !chessBoard.board[toLine][toColumn].getColor().equals(color);
        } else return true;
    }

    public boolean checkBishopMoves(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < line && toColumn < column) {
            for (int i = 1; i < Math.abs(toColumn - column); i++) {
                if (chessBoard.board[line - i][column - i] != null) return false;
            }
        } else if (toLine > line && toColumn < column) {
            for (int i = 1; i < Math.abs(toColumn - column); i++) {
                if (chessBoard.board[line + i][column - i] != null) return false;
            }
        } else if (toLine < line && toColumn > column) {
            for (int i = 1; i < Math.abs(toColumn - column); i++) {
                if (chessBoard.board[line - i][column + i] != null) return false;
            }
        } else if (toLine > line && toColumn > column) {
            for (int i = 1; i < Math.abs(toColumn - column); i++) {
                if (chessBoard.board[line + i][column + i] != null) return false;
            }
        }
        if (chessBoard.board[toLine][toColumn] != null) {
            return !chessBoard.board[toLine][toColumn].getColor().equals(color);
        } else return true;
    }

    public void pawnToQueenAttack(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (this.color.equals("Black") && toLine == 0 && !chessBoard.board[toLine][toColumn].getColor().equals(color)) {
            chessBoard.board[line][column] = new Queen("Black");

        } else if (this.color.equals("White") && toLine == 7 && !chessBoard.board[toLine][toColumn].getColor().equals(color)) {
            chessBoard.board[line][column] = new Queen("White");
        }
    }

    public void pawnToQueen(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (this.color.equals("Black") && toLine == 0) {
            chessBoard.board[line][column] = new Queen("Black");
        } else if (this.color.equals("White") && toLine == 7) {
            chessBoard.board[line][column] = new Queen("White");
        }
    }
}
