import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test {
    MockedStatic<Cos> cos = Mockito.mockStatic(Cos.class);
    MockedStatic<Csc> csc = Mockito.mockStatic(Csc.class);
    MockedStatic<Ctg> ctg = Mockito.mockStatic(Ctg.class);
    MockedStatic<Ln> ln = Mockito.mockStatic(Ln.class);
    MockedStatic<Ln2> ln2 = Mockito.mockStatic(Ln2.class);
    MockedStatic<Ln3> ln3 = Mockito.mockStatic(Ln3.class);
    MockedStatic<Sec> sec = Mockito.mockStatic(Sec.class);
    MockedStatic<Sin> sin = Mockito.mockStatic(Sin.class);;
    MockedStatic<Tg> tg = Mockito.mockStatic(Tg.class);

    final Map<Double, Double> cosTable = new HashMap<>() {{
        put(0.7853981, 0.7071068260153117);
        put(2.3561944, -0.707106717410926);
        put(3.1415926, -0.9999999999999986);
        put(3.92699081, -0.7071067861272734);
        put(4.71238, -8.98038469016786e-06);
        put(5.497787143, 0.7071067806334924);
    }};
    final Map<Double, Double> sinTable = new HashMap<>() {{
        put(0.7853981, 0.7071067363577804);
        put(2.3561944, 0.7071068449621633);
        put(3.1415926, 5.3589793170057245e-08);
        put(3.92699081, -0.7071067762458216);
        put(4.71238, -0.9999999999596764);
        put(5.497787143, -0.7071067817396027);
    }};
    final Map<Double, Double> tgTable = new HashMap<>() {{
        put(0.7853981, 0.9999998732051113);
        put(2.3561944, -1.0000001803847058);
        put(3.1415926, -5.3589793170057325e-08);
        put(3.92699081, 0.999999986025517);
        put(4.71238, 111353.80437037653);
        put(5.497787143, -1.0000000015642763);
    }};
    final Map<Double, Double> ctgTable = new HashMap<>() {{
        put(0.7853981, 1.0000001267949048);
        put(2.3561944, -0.9999998196153267);
        put(3.1415926, -18660269.817177396);
        put(3.92699081, 1.0000000139744831);
        put(4.71238, 8.980384690529982e-06);
        put(5.497787143, -0.9999999984357237);
    }};
    final Map<Double, Double> cscTable = new HashMap<>() {{
        put(0.7853981, 1.414213652030635);
        put(2.3561944, 1.4142134348218751);
        put(3.1415926, 18660269.817177422);
        put(3.92699081, -1.4142135722545468);
        put(4.71238, -1.0000000000403237);
        put(5.497787143, -1.4142135612669846);
    }};
    final Map<Double, Double> secTable = new HashMap<>() {{
        put(0.7853981, 1.4142134727155724);
        put(2.3561944, -1.4142136899243496);
        put(3.1415926, -1.0000000000000016);
        put(3.92699081, -1.4142135524916433);
        put(4.71238, -111353.80437486671);
        put(5.497787143, 1.4142135634792052);
    }};
    final Map<Double, Double> lnTable = new HashMap<>() {{
        put(0.7853981, -0.24156455599063195);
        put(2.3561944, 0.8570477751187985);
        put(3.1415926, 1.144729868791239);
        put(3.92699081, 1.3678734353843234);
        put(4.71238, 1.5501930882589297);
        put(5.497787143, 1.7043456736425586);
    }};
    final Map<Double, Double> ln2Table = new HashMap<>() {{
        put(0.7853981, -0.34850398698222906);
        put(2.3561944, 1.2364585749688102);
        put(3.1415926, 1.6514961048625945);
        put(3.92699081, 1.9734242217927134);
        put(4.71238, 2.236455880851505);
        put(5.497787143, 2.4588510513246793);
    }};
    final Map<Double, Double> ln3Table = new HashMap<>() {{
        put(0.7853981, -0.21988153462536816);
        put(2.3561944, 0.7801185040063867);
        put(3.1415926, 1.0419780304651785);
        put(3.92699081, 1.2450920579476217);
        put(4.71238, 1.4110465577790767);
        put(5.497787143, 1.5513622878811986);
    }};


    @BeforeAll
    void doMock() {
        cos.when((() -> Cos.of(any(Double.class)))).thenAnswer((x) -> cosTable.get(x.getArgument(0, Double.class)));
        sin.when((() -> Sin.of(any(Double.class)))).thenAnswer((x) -> sinTable.get(x.getArgument(0, Double.class)));
        tg.when((() -> Tg.of(any(Double.class)))).thenAnswer((x) -> tgTable.get(x.getArgument(0, Double.class)));
        ctg.when((() -> Ctg.of(any(Double.class)))).thenAnswer((x) -> ctgTable.get(x.getArgument(0, Double.class)));
        csc.when((() -> Csc.of(any(Double.class)))).thenAnswer((x) -> cscTable.get(x.getArgument(0, Double.class)));
        sec.when((() -> Sec.of(any(Double.class)))).thenAnswer((x) -> secTable.get(x.getArgument(0, Double.class)));
        ln.when((() -> Ln.of(any(Double.class)))).thenAnswer((x) -> lnTable.get(x.getArgument(0, Double.class)));
        ln2.when((() -> Ln2.of(any(Double.class)))).thenAnswer((x) -> ln2Table.get(x.getArgument(0, Double.class)));
        ln3.when((() -> Ln3.of(any(Double.class)))).thenAnswer((x) -> ln3Table.get(x.getArgument(0, Double.class)));
    }

    private static Stream<Arguments> cosValues() {
        return Stream.of(
                Arguments.of(0.7853981, 0.707106781), // pi/4
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
