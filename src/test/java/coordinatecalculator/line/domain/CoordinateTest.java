package coordinatecalculator.line.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CoordinateTest {

    @Test
    void validation_xy��ǥ��_��谪��_�����_���ܸ�_������() {
        assertThatThrownBy(() -> {
            Coordinate pointXOverUpperLimit = Coordinate.of(25, 5);
            Coordinate pointXUnderLowerLimit = Coordinate.of(-1, 2);
            Coordinate pointYOverUpperLimit = Coordinate.of(14, 25);
            Coordinate pointYUnderLowerLimit = Coordinate.of(16, -1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("��ǥ�� 0�̻� 24���ϸ� �Է� �����մϴ�.");
    }
}