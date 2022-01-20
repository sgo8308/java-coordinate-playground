package coordinatecalculator.line.utils;

import coordinatecalculator.line.domain.Coordinate;
import coordinatecalculator.line.domain.Figure;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FigureParser {

    public static Figure parsePoints(String input) {
        String[] inputs = input.split("-");
        ArrayList<Coordinate> points = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            String coordinate = inputs[i];
            points.add(parsePoint(coordinate));
        }
        return Figure.of(points.toArray(new Coordinate[points.size()]));
    }

    private static Coordinate parsePoint(String coordinate) {
        Matcher XYValueMatcher = Pattern.compile("[0-9]+").matcher(coordinate);
        List<Integer> values = new ArrayList<>();
        while (XYValueMatcher.find()) {
            values.add(Integer.valueOf(XYValueMatcher.group()));
        }
        return Coordinate.of(values.get(0), values.get(1));
    }

    public static void isValid(String input) {
        inputValidation(input);
        parsePoints(input);
    }

    private static void inputValidation(String input) {
        if (!input.matches("^(\\([0-9]+,[0-9]+\\)-)*(\\([0-9]+,[0-9]+\\))$")) {
            throw new IllegalArgumentException("정확한 형식을 지켜서 입력해주세요. ex (10,10)-(5,23)");
        }
    }
}
