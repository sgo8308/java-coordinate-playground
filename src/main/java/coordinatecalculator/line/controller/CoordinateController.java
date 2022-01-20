package coordinatecalculator.line.controller;

import coordinatecalculator.line.domain.Board;
import coordinatecalculator.line.domain.Points;
import coordinatecalculator.line.utils.PointsParser;
import coordinatecalculator.line.view.InputView;
import coordinatecalculator.line.view.OutputView;

public class CoordinateController {
    public static void main(String[] args) {
        Points points = inputUntilValidPoints();
        Board board = new Board();
        board.markPoints(points);
        OutputView.printBoard(board.toString());
        OutputView.printAttribute(points.getAttributeMessage());
    }

    private static Points inputUntilValidPoints() {
        String input = "";
        boolean isValid = false;
        while (!isValid) {
            OutputView.printInputMessage();
            input = InputView.inputCoordinate();
            isValid = isValid(input);
        }
        return PointsParser.parsePoints(input);
    }

    private static boolean isValid(String input) {
        try {
            PointsParser.isValid(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return false;
        }
        return true;
    }
}
