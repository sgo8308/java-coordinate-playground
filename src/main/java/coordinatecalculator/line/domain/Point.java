package coordinatecalculator.line.domain;

public class Point {

    int x;
    int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(int x, int y) {
        validation(x, y);
        return new Point(x, y);
    }

    private static void validation(int x, int y) {
        if (!isValid(x) || !isValid(y)) {
            throw new IllegalArgumentException("��ǥ�� 0�̻� 24���ϸ� �Է� �����մϴ�.");
        }
    }

    private static boolean isValid(int coordinate) {
       return PointLimit.isInsideLimit(coordinate);
    }
}
