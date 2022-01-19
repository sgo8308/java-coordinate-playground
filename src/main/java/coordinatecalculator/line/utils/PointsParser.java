package coordinatecalculator.line.utils;

import coordinatecalculator.line.domain.Point;
import coordinatecalculator.line.domain.Points;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PointsParser {
    public static Points parsePoints(String input) {
        String[] inputs = input.split("-");
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            String coordinate = inputs[i];
            points.add(parsePoint(coordinate));
        }
        return Points.of(points.toArray(new Point[points.size()]));
    }

    private static Point parsePoint(String inputs) {
        Matcher matcher = Pattern.compile("[0-9]+").matcher(inputs);
        matcher.find();
        int x = Integer.parseInt(matcher.group());
        matcher.find();
        int y = Integer.parseInt(matcher.group());
        return Point.of(x, y);
    }
}
