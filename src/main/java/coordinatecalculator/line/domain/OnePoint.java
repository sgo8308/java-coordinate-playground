package coordinatecalculator.line.domain;

public class OnePoint extends Points {

    protected OnePoint(Point point) {
        points.add(point);
    }

    @Override
    public String getAttributeMessage() {
        return "";
    }
}
