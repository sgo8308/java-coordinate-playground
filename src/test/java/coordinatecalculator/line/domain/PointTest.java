package coordinatecalculator.line.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    void validation_xy��ǥ��_��谪��_�����_���ܸ�_������() {
        assertThatThrownBy(() -> {
            Point pointXOverUpperLimit = Point.of(25, 5);
            Point pointXUnderLowerLimit = Point.of(-1, 2);
            Point pointYOverUpperLimit = Point.of(14, 25);
            Point pointYUnderLowerLimit = Point.of(16, -1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("��ǥ�� 0�̻� 24���ϸ� �Է� �����մϴ�.");
    }
}