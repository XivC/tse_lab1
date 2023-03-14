import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.itmo.series.Series;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCos {

    private static Stream<Arguments> cosValues() {
        return Stream.of(
                Arguments.of(0.0, 1.0),
                Arguments.of(0.7853981, 0.707106781), // pi/4
                Arguments.of(1.5707963, 0.0),  // pi/2
                Arguments.of(2.3561944, -0.707106781), // 3pi/4
                Arguments.of(3.1415926, -1.0), // pi
                Arguments.of(3.92699081, -0.707106781), // 5pi/4
                Arguments.of(4.71238, 0), // 3pi/2
                Arguments.of(5.497787143, 0.707106781) // 7pi/4
        );
    }

    private static Stream<Arguments> factValues() {
        return Stream.of(
                Arguments.of(0L, 1L),
                Arguments.of(1L, 1L),
                Arguments.of(2L, 2L),
                Arguments.of(3L, 6L),
                Arguments.of(4L, 24L),
                Arguments.of(5L, 120L),
                Arguments.of(6L, 720L),
                Arguments.of(7L, 5040L)
        );
    }


    @ParameterizedTest
    @MethodSource("factValues")
    public void testFactorial(long x, long expected){
        assertEquals(Series.factorial(x), expected);
    }

    @ParameterizedTest
    @MethodSource("cosValues")
    public void testCosPrecision(double x, double expected){
        assertTrue(Math.abs(Series.cos(x) - expected) <= 0.1);

    }
}
