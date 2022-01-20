package coordinatecalculator.line.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LineTest {
   @Test
   void getAttributeMessage_��_��_������_�Ÿ���_��ȯ�Ѵ�() {
       //given
       Line points = new Line(Coordinate.of(1,1), Coordinate.of(2,2));

       //when
       String actual = points.getAttributeMessage();

       //then
       assertThat(actual).hasToString("�� �� ������ �Ÿ��� " + Math.sqrt(2));
   }

}