package coordinatecalculator.line.domain;

public class Dot extends Figure {

    protected Dot(Coordinate... coordinates) {
        super(coordinates);
    }

    @Override
    public String getAttributeMessage() {
        return "";
    }
}
