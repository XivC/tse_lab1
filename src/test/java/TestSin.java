import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.itmo.func.Cos;
import ru.itmo.func.Sin;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSin {

    private static Stream<Arguments> values() {
        return Stream.of(
                Arguments.of(0.0, 0.0),
                Arguments.of(0.7853981, 0.707106781), // pi/4
                Arguments.of(1.5707963, 1),  // pi/2
                Arguments.of(2.3561944, 0.707106781), // 3pi/4
                Arguments.of(3.1415926, 0), // pi
                Arguments.of(3.92699081, -0.707106781), // 5pi/4
                Arguments.of(4.71238, -1), // 3pi/2
                Arguments.of(5.497787143, -0.707106781) // 7pi/4
        );
    }

    @ParameterizedTest
    @MethodSource("values")
    public void testSinPrecision(double x, double expected){
        assertEquals(expected, Cos.of(x), Precision.E);
    }
}
