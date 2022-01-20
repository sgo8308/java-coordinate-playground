package coordinatecalculator.line.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class SquareTest {

    @Test
    void getAttributeMessage_4����_������_�̷����_�簢����_���̸�_��ȯ�ؾ�_�Ѵ�() {
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
        assertThat(actualMessage).hasToString("�簢�� ���̴� 96");
    }

    @Test
    void Square_�簢����_�ƴ�_����Ʈ��_�Էµ�_���_���ܸ�_������() {
        assertThatThrownBy(() -> {
            Figure square = Figure.of(
                    Coordinate.of(10, 9),
                    Coordinate.of(22, 10),
                    Coordinate.of(22, 18),
                    Coordinate.of(10, 18)
            );
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("���簢���� �̷�� ��ǥ�� �Է� �����մϴ�.");
    }
}