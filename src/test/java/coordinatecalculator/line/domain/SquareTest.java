package coordinatecalculator.line.domain;

import static org.assertj.core.api.Assertions.assertThat;

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
}