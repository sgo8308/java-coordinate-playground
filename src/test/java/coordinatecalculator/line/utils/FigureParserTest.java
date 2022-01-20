package coordinatecalculator.line.utils;

import coordinatecalculator.line.domain.Coordinate;
import coordinatecalculator.line.domain.Figure;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FigureParserTest {

    @Test
    void parsePoints_�ϳ���_����Ʈ��_�־�����_��_OnePoint��ȯ() {
        //given
        String input = "(10,10)";

        //when
        Figure points = FigureParser.parsePoints(input);

        //then
        Assertions.assertThat(points).isEqualTo(Figure.of(Coordinate.of(10, 10)));
    }

    @Test
    void parsePoints_2����_����Ʈ��_�ֿ�����_��_TwoPoints��ȯ() {
        //given
        String input = "(10,10)-(14,15)j";

        //when
        Figure points = FigureParser.parsePoints(input);

        //then
        Assertions.assertThat(points).isEqualTo(Figure.of(Coordinate.of(10, 10), Coordinate.of(14,15)));
    }
}