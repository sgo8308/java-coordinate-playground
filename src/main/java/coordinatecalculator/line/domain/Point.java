package coordinatecalculator.line.domain;

public class Point {

    private final int x;
    private final int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(int x, int y) {
        validation(x, y);
        return new Point(x, y);
    }

    private static void validation(int x, int y) {
        if (isValid(x) && isValid(y)) {
            return;
        }
        throw new IllegalArgumentException("좌표는 0이상 24이하만 입력 가능합니다.");
    }

    private static boolean isValid(int coordinate) {
        return PointLimit.isInsideLimit(coordinate);
    }

    public static int getXValueDifference(Point point1, Point point2) {
       return point1.x - point2.x;
    }

    public static int getYValueDifference(Point point1, Point point2) {
        return point1.y - point2.y;
    }

    public Point transform() {
        return new Point(24 - y, x - 1);
    }

    public void markTo(String[][] board) {
        board[x][y] = "  *";
    }
}
