package coordinatecalculator.line.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TriangleTest {
   @Test
   void getAttributeMessage_�ﰢ����_���̸�_��ȯ�Ѵ�() {
       //given
       Figure triangle = Figure.of(
               Coordinate.of(10, 10),
               Coordinate.of(14, 15),
               Coordinate.of(20, 8)
       );
       //when
       String actualMessage = triangle.getAttributeMessage();

       //then
       assertThat(actualMessage).hasToString("�ﰢ�� ���̴� 29.0");
   }
}