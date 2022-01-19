package coordinatecalculator.line.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Points {

    protected List<Point> points = new ArrayList<>();

    public static Points of(Point... points) {
        if (points.length == 2) {
            return new TwoPoints(points[0], points[1]);
        }
        return new OnePoint(points[0]);
    }

    public abstract String getAttributeMessage();

    public void markTo(String[][] board) {
        points.stream().map(Point::transform)
                .forEach(transformedPoint -> transformedPoint.markTo(board));
    }
}
