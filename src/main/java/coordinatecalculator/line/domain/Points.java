package coordinatecalculator.line.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Points {

    List<Point> points;

    protected Points() {
        this.points = new ArrayList<>();
    }

    public static Points of(Point... points) {
        if (points.length == 2) {
            return new TwoPoints(points[0], points[1]);
        }
        return new OnePoint(points[0]);
    }

    public abstract String getAttributeMessage();

    public void mark(String[][] board) {
        for (Point point : points) {
            Point newPoint = point.transform();
            board[newPoint.getX()][newPoint.getY()] = "  *";
        }
    }
}
