package coordinatecalculator.line.utils;

import coordinatecalculator.line.domain.Coordinate;
import coordinatecalculator.line.domain.Figure;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FigureParserTest {

    @Test
    void parsePoints_하나의_포인트가_주어졌을_때_OnePoint반환() {
        //given
        String input = "(10,10)";

        //when
        Figure points = FigureParser.parsePoints(input);

        //then
        Assertions.assertThat(points).isEqualTo(Figure.of(Coordinate.of(10, 10)));
    }

    @Test
    void parsePoints_2개의_포인트가_주여졌을_때_TwoPoints반환() {
        //given
        String input = "(10,10)-(14,15)j";

        //when
        Figure points = FigureParser.parsePoints(input);

        //then
        Assertions.assertThat(points).isEqualTo(Figure.of(Coordinate.of(10, 10), Coordinate.of(14,15)));
    }
}