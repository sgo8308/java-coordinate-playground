package coordinatecalculator.line.domain;

public class Line extends Figure {

    protected Line(Coordinate point1, Coordinate point2) {
        coordinates.add(point1);
        coordinates.add(point2);
    }

    @Override
    public String getAttributeMessage() {
        double distance = calculateDistance();
        return "두 점 사이의 거리는 " + distance;
    }

    private double calculateDistance() {
        return Math.sqrt(
                Math.pow((Coordinate.getXValueDifference(coordinates.get(0), coordinates.get(1))), 2)
                        + Math.pow((Coordinate.getYValueDifference(coordinates.get(0), coordinates.get(1))), 2)
        );
    }
}