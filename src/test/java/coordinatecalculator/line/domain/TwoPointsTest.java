package coordinatecalculator.line.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TwoPointsTest {
   @Test
   void getAttributeMessage_��_��_������_�Ÿ���_��ȯ�Ѵ�() {
       //given
       TwoPoints points = new TwoPoints(Point.of(1,1), Point.of(2,2));

       //when
       String actual = points.getAttributeMessage();

       //then
       assertThat(actual).hasToString("�� �� ������ �Ÿ��� " + Math.sqrt(2));
   }

}