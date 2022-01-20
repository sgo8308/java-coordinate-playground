package coordinatecalculator.line.domain;

public class Line extends Figure {

    protected Line(Coordinate... coordinates) {
        super(coordinates);
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