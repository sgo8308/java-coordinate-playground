package coordinatecalculator.line.domain;

public class Triangle extends Figure {

    protected Triangle(Coordinate... coordinates) {
        super(coordinates);
    }

    @Override
    public String getAttributeMessage() {
        return "»ï°¢Çü ³ÐÀÌ´Â " + calculateArea();
    }

    private double calculateArea() {
        double a = Line.calculateDistance(coordinates.get(0), coordinates.get(1));
        double b = Line.calculateDistance(coordinates.get(0), coordinates.get(2));
        double c = Line.calculateDistance(coordinates.get(1), coordinates.get(2));
        return heronFormula(a, b, c);
    }

    private double heronFormula(double length1, double length2, double length3) {
        return (1d / 4d)
                *
                Math.sqrt(
                        4 * Math.pow(length1, 2) * Math.pow(length2, 2)
                                -
                                Math.pow(
                                        Math.pow(length1, 2)
                                        + Math.pow(length2, 2)
                                        - Math.pow(length3, 2),
                                        2)
                );
    }
}
