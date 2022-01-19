package coordinatecalculator.line.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;
import static org.assertj.core.api.Assertions.setMaxStackTraceElementsDisplayed;

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

    @Test
    void calculateDistance_�Ϲ�����_�ΰ���_��ǥ_����_�Ÿ���_��() {
        //given
        Point point1 = Point.of(1, 1);
        Point point2 = Point.of(2, 2);

        //when
        double distance = Point.calculateDistance(point1, point2);

        //then
        assertThat(distance).isEqualTo(Math.sqrt(2), offset(0.1d));
    }

    @Test
    void calculateDistance_��谪��_����ִ�_�ΰ���_��ǥ��_��() {
        //given
        Point point1 = Point.of(0, 1);
        Point point2 = Point.of(2, 0);

        //when
        double distance = Point.calculateDistance(point1, point2);

        //then
        assertThat(distance).isEqualTo(Math.sqrt(5), offset(0.1d));
    }
}