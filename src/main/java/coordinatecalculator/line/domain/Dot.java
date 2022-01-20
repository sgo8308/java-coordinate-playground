package coordinatecalculator.line.domain;

public class Dot extends Figure {

    protected Dot(Coordinate point) {
        coordinates.add(point);
    }

    @Override
    public String getAttributeMessage() {
        return "";
    }
}
