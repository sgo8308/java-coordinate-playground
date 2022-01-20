package coordinatecalculator.line.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Square extends Figure {

    public Square(Coordinate... coordinates) {
        super(coordinates);
        validation(coordinates);
    }

    private void validation(Coordinate... coordinates) {
        Arrays.stream(coordinates).forEach(this::validateHasSameXCoordinateAndSameYCoordinate);
    }

    private void validateHasSameXCoordinateAndSameYCoordinate(Coordinate coordinate) {
        if (hasSameXCoordinate(coordinate) && hasSameYCoordinate(coordinate)) {
            return;
        }
        throw new IllegalArgumentException("직사각형을 이루는 좌표만 입력 가능합니다.");
    }

    private boolean hasSameYCoordinate(Coordinate coordinate) {
        return findCoordinate(coordinate::hasSameYValue,
                getCoordinatesExcept(coordinate)) != null;
    }

    private boolean hasSameXCoordinate(Coordinate coordinate) {
        return findCoordinate(coordinate::hasSameXValue,
                getCoordinatesExcept(coordinate)) != null;
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
        Coordinate coordinateHasSameX = findCoordinate(firstCoordinate::hasSameXValue,
                getCoordinatesExcept(firstCoordinate));
        return Coordinate.yValueDifferenceBetween(firstCoordinate, coordinateHasSameX);
    }

    private int getWidth() {
        Coordinate firstCoordinate = coordinates.get(0);
        Coordinate coordinateHasSameY = findCoordinate(firstCoordinate::hasSameYValue,
                getCoordinatesExcept(firstCoordinate));
        return Coordinate.xValueDifferenceBetween(firstCoordinate, coordinateHasSameY);
    }

    private Coordinate getFirstCoordinate() {
        return coordinates.get(0);
    }

    private List<Coordinate> getCoordinatesExcept(Coordinate coordinate) {
        return coordinates.stream().filter(x -> !x.equals(coordinate)).collect(Collectors.toList());
    }

    private Coordinate findCoordinate(Predicate<Coordinate> hasSameValue,
            List<Coordinate> coordinates) {
        return coordinates.stream()
                .filter(hasSameValue)
                .findFirst()
                .orElse(null);
    }
}
