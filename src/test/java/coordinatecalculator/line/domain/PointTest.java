package coordinatecalculator.line.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PointTest {
   @Test
   void validation_xy좌표가_경계값을_벗어나면_예외를_던진다() {
       Assertions.assertThatThrownBy(()->{
           Point pointXOverUpperLimit = Point.of(25, 5);
           Point pointXUnderLowerLimit = Point.of(-1, 2);
           Point pointYOverUpperLimit = Point.of(14, 25);
           Point pointYUnderLowerLimit = Point.of(16, -1);
       }).isInstanceOf(IllegalArgumentException.class)
               .hasMessage("좌표는 0이상 24이하만 입력 가능합니다.");
   }
}