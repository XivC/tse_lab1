import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import ru.itmo.func.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test {
    MockedStatic<Cos> cos = Mockito.mockStatic(Cos.class);
    MockedStatic<Csc> csc;
    MockedStatic<Ctg> ctg;
    MockedStatic<Ln> ln;
    MockedStatic<Log2> log2;
    MockedStatic<Log3> log3;
    MockedStatic<Sec> sec;
    MockedStatic<Sin> sin = Mockito.mockStatic(Sin.class);;
    MockedStatic<Tg> tg;

    final Map<Double, Double> cosTable = new HashMap<>() {{
        put(0.0, 1.0);
        put(0.7853981, 0.707106781); // pi/4
        put(1.5707963, 0.0);  // pi/2
        put(2.3561944, -0.707106781); // 3pi/4
        put(3.1415926, -1.0); // pi
        put(3.92699081, -0.707106781); // 5pi/4
        put(4.71238, 0.0); // 3pi/2
        put(5.497787143, 0.707106781); // 7pi/4
    }};

    final Map<Double, Double> sinTable = new HashMap<>() {{
        put(0.0, 1.0);
        put(0.7853981, 0.707106781); // pi/4
        put(1.5707963, 0.0);  // pi/2
        put(2.3561944, -0.707106781); // 3pi/4
        put(3.1415926, -1.0); // pi
        put(3.92699081, -0.707106781); // 5pi/4
        put(4.71238, 0.0); // 3pi/2
        put(5.497787143, 0.707106781); // 7pi/4
    }};


    @BeforeAll
    void doMock() {
        cos.when((() -> Cos.of(any(Double.class)))).thenAnswer((x) -> cosTable.get(x.getArgument(0)));
        sin.when((() -> Sin.of(any(Double.class)))).thenAnswer((x) -> sinTable.get(x.getArgument(0)));
    }

    private static Stream<Arguments> cosValues() {
        return Stream.of(
                Arguments.of(0.0, 1.0),
                Arguments.of(0.7853981, 0.707106781), // pi/4
                Arguments.of(1.5707963, 0),  // pi/2
                Arguments.of(2.3561944, -0.707106781), // 3pi/4
                Arguments.of(3.1415926, -1), // pi
                Arguments.of(3.92699081, -0.707106781), // 5pi/4
                Arguments.of(4.71238, 0), // 3pi/2
                Arguments.of(5.497787143, 0.707106781) // 7pi/4
        );
    }

    @ParameterizedTest
    @MethodSource("cosValues")
    public void testCosPrecision(double x, double expected){
        assertEquals(expected, Cos.of(x), Precision.E);
    }
}
