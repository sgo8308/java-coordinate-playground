package coordinatecalculator.line.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;
import static org.assertj.core.api.Assertions.setMaxStackTraceElementsDisplayed;

import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    void validation_xy좌표가_경계값을_벗어나면_예외를_던진다() {
        assertThatThrownBy(() -> {
            Point pointXOverUpperLimit = Point.of(25, 5);
            Point pointXUnderLowerLimit = Point.of(-1, 2);
            Point pointYOverUpperLimit = Point.of(14, 25);
            Point pointYUnderLowerLimit = Point.of(16, -1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("좌표는 0이상 24이하만 입력 가능합니다.");
    }

    @Test
    void calculateDistance_일반적인_두개의_좌표_사이_거리일_때() {
        //given
        Point point1 = Point.of(1, 1);
        Point point2 = Point.of(2, 2);

        //when
        double distance = Point.calculateDistance(point1, point2);

        //then
        assertThat(distance).isEqualTo(Math.sqrt(2), offset(0.1d));
    }

    @Test
    void calculateDistance_경계값이_들어있는_두개의_좌표일_때() {
        //given
        Point point1 = Point.of(0, 1);
        Point point2 = Point.of(2, 0);

        //when
        double distance = Point.calculateDistance(point1, point2);

        //then
        assertThat(distance).isEqualTo(Math.sqrt(5), offset(0.1d));
    }
}