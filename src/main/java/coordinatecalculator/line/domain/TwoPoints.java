package coordinatecalculator.line.domain;

public class TwoPoints extends Points {

    protected TwoPoints(Point point1, Point point2) {
        points.add(point1);
        points.add(point2);
    }

    @Override
    public String getAttributeMessage() {
        double distance = calculateDistance();
        return "두 점 사이의 거리는 " + distance;
    }

    private double calculateDistance() {
        return Math.sqrt(
                Math.pow((Point.getXValueDifference(points.get(0), points.get(1))), 2)
                        + Math.pow((Point.getYValueDifference(points.get(0), points.get(1))), 2)
        );
    }
}