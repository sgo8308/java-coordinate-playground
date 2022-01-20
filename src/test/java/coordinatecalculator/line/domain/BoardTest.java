package coordinatecalculator.line.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BoardTest {
    @Test
    void toString_아무런_포인트도_색칠되지_않았을_때() {
        //given
        Board board = new Board();

        //when
        String boardString = board.toString();

        //then
        assertThat(boardString).hasToString(
                "24                                                                        \n"
                        + "23                                                                        \n"
                        + "22                                                                        \n"
                        + "21                                                                        \n"
                        + "20                                                                        \n"
                        + "19                                                                        \n"
                        + "18                                                                        \n"
                        + "17                                                                        \n"
                        + "16                                                                        \n"
                        + "15                                                                        \n"
                        + "14                                                                        \n"
                        + "13                                                                        \n"
                        + "12                                                                        \n"
                        + "11                                                                        \n"
                        + "10                                                                        \n"
                        + " 9                                                                        \n"
                        + " 8                                                                        \n"
                        + " 7                                                                        \n"
                        + " 6                                                                        \n"
                        + " 5                                                                        \n"
                        + " 4                                                                        \n"
                        + " 3                                                                        \n"
                        + " 2                                                                        \n"
                        + " 1                                                                        \n"
                        + " 0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24"
        );
    }


    @Test
    void toString_점이_마킹_되어있을_때() {
        //given
        Figure points = Figure.of(Coordinate.of(1, 1), Coordinate.of(5, 5));
        Board board = new Board();

        //when
        board.markPoints(points);

        //then
        assertThat(board.toString()).hasToString(
                          "24                                                                        \n"
                        + "23                                                                        \n"
                        + "22                                                                        \n"
                        + "21                                                                        \n"
                        + "20                                                                        \n"
                        + "19                                                                        \n"
                        + "18                                                                        \n"
                        + "17                                                                        \n"
                        + "16                                                                        \n"
                        + "15                                                                        \n"
                        + "14                                                                        \n"
                        + "13                                                                        \n"
                        + "12                                                                        \n"
                        + "11                                                                        \n"
                        + "10                                                                        \n"
                        + " 9                                                                        \n"
                        + " 8                                                                        \n"
                        + " 7                                                                        \n"
                        + " 6                                                                        \n"
                        + " 5              *                                                         \n"
                        + " 4                                                                        \n"
                        + " 3                                                                        \n"
                        + " 2                                                                        \n"
                        + " 1  *                                                                     \n"
                        + " 0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24"
        );
    }

    @Test
    void markPoint_경계값을_입력받았을_때() {
        //given
        Figure points = Figure.of(Coordinate.of(24, 24));
        Board board = new Board();

        //when
        board.markPoints(points);

        //then
        assertThat(board.toString()).hasToString(
                "24                                                                       *\n"
                        + "23                                                                        \n"
                        + "22                                                                        \n"
                        + "21                                                                        \n"
                        + "20                                                                        \n"
                        + "19                                                                        \n"
                        + "18                                                                        \n"
                        + "17                                                                        \n"
                        + "16                                                                        \n"
                        + "15                                                                        \n"
                        + "14                                                                        \n"
                        + "13                                                                        \n"
                        + "12                                                                        \n"
                        + "11                                                                        \n"
                        + "10                                                                        \n"
                        + " 9                                                                        \n"
                        + " 8                                                                        \n"
                        + " 7                                                                        \n"
                        + " 6                                                                        \n"
                        + " 5                                                                        \n"
                        + " 4                                                                        \n"
                        + " 3                                                                        \n"
                        + " 2                                                                        \n"
                        + " 1                                                                        \n"
                        + " 0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24"
        );
    }
}