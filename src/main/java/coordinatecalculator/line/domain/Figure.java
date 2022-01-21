package coordinatecalculator.line.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Figure {

    protected List<Coordinate> coordinates = new ArrayList<>();

    protected Figure(Coordinate... coordinates) {
        for (Coordinate coordinate : coordinates) {
            this.coordinates.add(coordinate);
        }
    }

    public static Figure of(Coordinate... coordinates) {
        if (coordinates.length == 2) {
            return new Line(coordinates[0], coordinates[1]);
        }

        if (coordinates.length == 3) {
            return new Triangle(coordinates[0], coordinates[1], coordinates[2]);
        }

        if (coordinates.length == 4) {
            return new Square(coordinates[0], coordinates[1], coordinates[2], coordinates[3]);
        }

        return new Dot(coordinates[0]);
    }

    public abstract String getAttributeMessage();

    public void markTo(String[][] board) {
        coordinates.stream().map(Coordinate::transform)
                .forEach(transformedPoint -> transformedPoint.markTo(board));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Figure points1 = (Figure) o;
        return Objects.equals(coordinates, points1.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }
}
