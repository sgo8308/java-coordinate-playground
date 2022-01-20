package coordinatecalculator.line.controller;

import coordinatecalculator.line.domain.Board;
import coordinatecalculator.line.domain.Figure;
import coordinatecalculator.line.utils.FigureParser;
import coordinatecalculator.line.view.InputView;
import coordinatecalculator.line.view.OutputView;

public class CoordinateController {
    public static void main(String[] args) {
        Figure points = inputUntilValidPoints();
        Board board = new Board();
        board.markPoints(points);
        OutputView.printBoard(board.toString());
        OutputView.printAttribute(points.getAttributeMessage());
    }

    private static Figure inputUntilValidPoints() {
        String input = "";
        boolean isValid = false;
        while (!isValid) {
            OutputView.printInputMessage();
            input = InputView.inputCoordinate();
            isValid = isValid(input);
        }
        return FigureParser.parsePoints(input);
    }

    private static boolean isValid(String input) {
        try {
            FigureParser.isValid(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return false;
        }
        return true;
    }
}
