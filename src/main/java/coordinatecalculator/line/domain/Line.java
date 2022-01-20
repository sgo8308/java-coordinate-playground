package coordinatecalculator.line.domain;

public class Line extends Figure {

    protected Line(Coordinate... coordinates) {
        super(coordinates);
    }

    @Override
    public String getAttributeMessage() {
        double distance = calculateDistance();
        return "�� �� ������ �Ÿ��� " + distance;
    }

    private double calculateDistance() {
        return Math.sqrt(
                Math.pow((Coordinate.xValueDifferenceBetween(coordinates.get(0), coordinates.get(1))), 2)
                        + Math.pow((Coordinate.yValueDifferenceBetween(coordinates.get(0), coordinates.get(1))), 2)
        );
    }
}