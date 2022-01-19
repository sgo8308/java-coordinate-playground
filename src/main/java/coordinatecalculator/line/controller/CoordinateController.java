package coordinatecalculator.line.controller;

import coordinatecalculator.line.domain.Board;
import coordinatecalculator.line.domain.Points;
import coordinatecalculator.line.utils.PointsParser;
import coordinatecalculator.line.view.InputView;
import coordinatecalculator.line.view.OutputView;

public class CoordinateController {
    public static void main(String[] args) {
        OutputView.printInputMessage();
        String input = InputView.inputCoordinate();
        Points points = PointsParser.parsePoints(input);
        Board board = new Board();
        board.markPoints(points);
        OutputView.printBoard(board.toString());
        OutputView.printAttribute(points.getAttributeMessage());
    }
}
