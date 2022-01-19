package coordinatecalculator.line.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TwoPointsTest {
   @Test
   void getAttributeMessage_두_점_사이의_거리를_반환한다() {
       //given
       TwoPoints points = new TwoPoints(Point.of(1,1), Point.of(2,2));

       //when
       String actual = points.getAttributeMessage();

       //then
       assertThat(actual).hasToString("두 점 사이의 거리는 " + Math.sqrt(2));
   }

}