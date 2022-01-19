package coordinatecalculator.line.utils;

import coordinatecalculator.line.domain.Point;
import coordinatecalculator.line.domain.Points;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PointsParserTest {

    @Test
    void parsePoints_�ϳ���_����Ʈ��_�־�����_��_OnePoint��ȯ() {
        //given
        String input = "(10,10)";

        //when
        Points points = PointsParser.parsePoints(input);

        //then
        Assertions.assertThat(points).isEqualTo(Points.of(Point.of(10, 10)));
    }

    @Test
    void parsePoints_2����_����Ʈ��_�ֿ�����_��_TwoPoints��ȯ() {
        //given
        String input = "(10,10)-(14,15)j";

        //when
        Points points = PointsParser.parsePoints(input);

        //then
        Assertions.assertThat(points).isEqualTo(Points.of(Point.of(10, 10), Point.of(14,15)));
    }
}