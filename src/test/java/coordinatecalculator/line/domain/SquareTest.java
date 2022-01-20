package coordinatecalculator.line.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class SquareTest {

    @Test
    void getAttributeMessage_4개의_점으로_이루어진_사각형의_넓이를_반환해야_한다() {
        //given
        Figure square = Figure.of(
                Coordinate.of(10, 10),
                Coordinate.of(22, 10),
                Coordinate.of(22, 18),
                Coordinate.of(10, 18)
        );
        //when
        String actualMessage = square.getAttributeMessage();

        //then
        assertThat(actualMessage).hasToString("사각형 넓이는 96");
    }

    @Test
    void Square_사각형이_아닌_포인트가_입력될_경우_예외를_던진다() {
        assertThatThrownBy(() -> {
            Figure square = Figure.of(
                    Coordinate.of(10, 9),
                    Coordinate.of(22, 10),
                    Coordinate.of(22, 18),
                    Coordinate.of(10, 18)
            );
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("직사각형을 이루는 좌표만 입력 가능합니다.");
    }
}