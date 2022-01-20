package coordinatecalculator.line.domain;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Square extends Figure {

    public Square(Coordinate... coordinates) {
        super(coordinates);
    }

    @Override
    public String getAttributeMessage() {
        return "사각형 넓이는 " + calculateArea();
    }

    private int calculateArea() {
        int height = getHeight();
        int width = getWidth();
        return height * width;
    }

    private int getHeight() {
        Coordinate co1 = coordinates.get(0);
        Coordinate co2 = findCoordinate(co1::hasSameXValue);
        return Coordinate.yValueDifferenceBetween(co1, co2);
    }

    private int getWidth() {
        Coordinate co1 = coordinates.get(0);
        Coordinate co2 = findCoordinate(co1::hasSameYValue);
        return Coordinate.xValueDifferenceBetween(co1, co2);
    }

    private Coordinate findCoordinate(Predicate<Coordinate> hasSameValue) {
        return IntStream.range(1, coordinates.size())
                .mapToObj(coordinates::get)
                .filter(hasSameValue)
                .findFirst()
                .orElse(null);
    }
}
