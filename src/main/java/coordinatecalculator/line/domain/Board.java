package coordinatecalculator.line.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Board {

    String[][] board;

    public Board() {
        createBoard();
    }

    public void markPoints(Figure points) {
        points.markTo(board);
    }

    private void createBoard() {
        board = new String[CoordinateLimit.UPPER_LIMIT.value][CoordinateLimit.UPPER_LIMIT.value];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = "   ";
            }
        }
    }

    @Override
    public String toString() {
        return new StringBuilder().append(getBody()).append(getFooter()).toString();
    }

    private String getBody() {
        StringBuilder body = new StringBuilder();
        for (int rowNum = 0; rowNum < board.length; rowNum++) {
            body.append(getRow(rowNum));
        }
        return body.toString();
    }

    private String getRow(int rowNum) {
        return new StringBuilder()
                .append(getYValue(CoordinateLimit.UPPER_LIMIT.value - rowNum))
                .append(getRowBodyString(rowNum))
                .append("\n")
                .toString();
    }

    private String getYValue(int yValue) {
        if (yValue < 10) {
            return " " + yValue;
        }
        return "" + yValue;
    }

    private String getRowBodyString(int rowNum) {
        return Arrays.stream(getRowArray(rowNum), 0, board.length)
                .collect(Collectors.joining());
    }

    private String[] getRowArray(int rowNum) {
        return board[rowNum];
    }

    private String getFooter() {
        return " 0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24";
    }
}
