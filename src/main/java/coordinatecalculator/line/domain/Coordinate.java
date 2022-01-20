package coordinatecalculator.line.domain;

import java.util.Objects;

public class Coordinate {

    private final int x;
    private final int y;

    private Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinate of(int x, int y) {
        validation(x, y);
        return new Coordinate(x, y);
    }

    private static void validation(int x, int y) {
        if (isValid(x) && isValid(y)) {
            return;
        }
        throw new IllegalArgumentException("좌표는 0이상 24이하만 입력 가능합니다.");
    }

    private static boolean isValid(int coordinate) {
        return CoordinateLimit.isInsideLimit(coordinate);
    }

    public Coordinate transform() {
        return new Coordinate(24 - y, x - 1);
    }

    public void markTo(String[][] board) {
        board[x][y] = "  *";
    }

    public static int xValueDifferenceBetween(Coordinate point1, Coordinate point2) {
        return Math.abs(point1.x - point2.x);
    }

    public static int yValueDifferenceBetween(Coordinate point1, Coordinate point2) {
        return Math.abs(point1.y - point2.y);
    }

    public boolean hasSameYValue(Coordinate coordinate) {
        return this.y == coordinate.y;
    }

    public boolean hasSameXValue(Coordinate coordinate) {
        return this.x == coordinate.x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coordinate point = (Coordinate) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
