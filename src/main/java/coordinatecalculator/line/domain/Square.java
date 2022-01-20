package coordinatecalculator.line.domain;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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
        return getHeight() * getWidth();
    }

    private int getHeight() {
        Coordinate firstCoordinate = getFirstCoordinate();
        Coordinate coordinateHasSameX = findCoordinate(getCoordinatesExceptFirst(), firstCoordinate::hasSameXValue);
        return Coordinate.yValueDifferenceBetween(firstCoordinate, coordinateHasSameX);
    }

    private int getWidth() {
        Coordinate firstCoordinate = getFirstCoordinate();
        Coordinate coordinateHasSameY = findCoordinate(getCoordinatesExceptFirst(), firstCoordinate::hasSameYValue);
        return Coordinate.xValueDifferenceBetween(firstCoordinate, coordinateHasSameY);
    }

    private Coordinate getFirstCoordinate() {
        return coordinates.get(0);
    }

    private List<Coordinate> getCoordinatesExceptFirst() {
        return IntStream.range(1, coordinates.size())
                .mapToObj(coordinates::get)
                .collect(Collectors.toList());
    }

    private Coordinate findCoordinate(List<Coordinate> coordinates, Predicate<Coordinate> hasSameValue) {
        return coordinates.stream()
                .filter(hasSameValue)
                .findFirst()
                .orElse(null);
    }
}
