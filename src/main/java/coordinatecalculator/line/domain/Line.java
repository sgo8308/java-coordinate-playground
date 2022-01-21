package coordinatecalculator.line.domain;

public class Line extends Figure {

    protected Line(Coordinate... coordinates) {
        super(coordinates);
    }

    @Override
    public String getAttributeMessage() {
        double distance = calculateDistance(coordinates.get(0), coordinates.get(1));
        return "두 점 사이의 거리는 " + distance;
    }

    public static double calculateDistance(Coordinate a, Coordinate b) {
        return Math.sqrt(
                Math.pow((Coordinate.xValueDifferenceBetween(a, b)), 2)
                        + Math.pow((Coordinate.yValueDifferenceBetween(a, b)), 2)
        );
    }
}