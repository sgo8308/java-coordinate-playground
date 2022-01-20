package coordinatecalculator.line.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CoordinateTest {

    @Test
    void validation_xy좌표가_경계값을_벗어나면_예외를_던진다() {
        assertThatThrownBy(() -> {
            Coordinate pointXOverUpperLimit = Coordinate.of(25, 5);
            Coordinate pointXUnderLowerLimit = Coordinate.of(-1, 2);
            Coordinate pointYOverUpperLimit = Coordinate.of(14, 25);
            Coordinate pointYUnderLowerLimit = Coordinate.of(16, -1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("좌표는 0이상 24이하만 입력 가능합니다.");
    }
}