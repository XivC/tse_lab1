import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
        put(-0.9, 0.6216099682706644);
        put(-0.8, 0.6967067093471654);
        put(-0.7, 0.7648421872844885);
        put(-0.6, 0.8253356149096783);
        put(-0.5, 0.8775825618903728);
        put(-0.4, 0.9210609940028851);
        put(-0.3, 0.955336489125606);
        put(-0.2, 0.9800665778412416);
        put(-0.1, 0.9950041652780258);
        put(0.0, 1.0);
        put(0.1, 0.9950041652780258);
        put(0.2, 0.9800665778412416);
        put(0.3, 0.955336489125606);
        put(0.4, 0.9210609940028851);
        put(0.5, 0.8775825618903728);
        put(0.6, 0.8253356149096783);
        put(0.7, 0.7648421872844885);
        put(0.8, 0.6967067093471654);
        put(0.9, 0.6216099682706644);
    }};
    final Map<Double, Double> sinTable = new HashMap<>() {{
        put(-0.9, -0.7833269096274834);
        put(-0.8, -0.7173560908995228);
        put(-0.7, -0.644217687237691);
        put(-0.6, -0.5646424733950354);
        put(-0.5, -0.479425538604203);
        put(-0.4, -0.3894183423086505);
        put(-0.3, -0.29552020666133955);
        put(-0.2, -0.19866933079506122);
        put(-0.1, -0.09983341664682815);
        put(0.0, 0.0);
        put(0.1, 0.09983341664682815);
        put(0.2, 0.19866933079506122);
        put(0.3, 0.29552020666133955);
        put(0.4, 0.3894183423086505);
        put(0.5, 0.479425538604203);
        put(0.6, 0.5646424733950354);
        put(0.7, 0.644217687237691);
        put(0.8, 0.7173560908995228);
        put(0.9, 0.7833269096274834);
    }};
    final Map<Double, Double> tgTable = new HashMap<>() {{
        put(-0.9, -1.260158217550339);
        put(-0.8, -1.0296385570503641);
        put(-0.7, -0.8422883804630793);
        put(-0.6, -0.6841368083416923);
        put(-0.5, -0.5463024898437905);
        put(-0.4, -0.4227932187381618);
        put(-0.3, -0.3093362496096232);
        put(-0.2, -0.20271003550867248);
        put(-0.1, -0.10033467208545054);
        put(0.0, 0.0);
        put(0.1, 0.10033467208545054);
        put(0.2, 0.20271003550867248);
        put(0.3, 0.3093362496096232);
        put(0.4, 0.4227932187381618);
        put(0.5, 0.5463024898437905);
        put(0.6, 0.6841368083416923);
        put(0.7, 0.8422883804630793);
        put(0.8, 1.0296385570503641);
        put(0.9, 1.260158217550339);
    }};
    final Map<Double, Double> ctgTable = new HashMap<>() {{
        put(-0.9, -0.7935511478423173);
        put(-0.8, -0.9712146006504743);
        put(-0.7, -1.1872418321266796);
        put(-0.6, -1.4616959470781021);
        put(-0.5, -1.830487721712452);
        put(-0.4, -2.3652224200391103);
        put(-0.3, -3.232728143765828);
        put(-0.2, -4.933154875586894);
        put(-0.1, -9.96664442325924);
        put(0.0, Double.POSITIVE_INFINITY);
        put(0.1, 9.96664442325924);
        put(0.2, 4.933154875586894);
        put(0.3, 3.232728143765828);
        put(0.4, 2.3652224200391103);
        put(0.5, 1.830487721712452);
        put(0.6, 1.4616959470781021);
        put(0.7, 1.1872418321266796);
        put(0.8, 0.9712146006504743);
        put(0.9, 0.7935511478423173);
    }};
    final Map<Double, Double> cscTable = new HashMap<>() {{
        put(-0.9, -1.2766062134588954);
        put(-0.8, -1.394007819388636);
        put(-0.7, -1.552270326957104);
        put(-0.6, -1.7710321966877254);
        put(-0.5, -2.085829642933488);
        put(-0.4, -2.567932455547783);
        put(-0.3, -3.383863361824123);
        put(-0.2, -5.033489547672344);
        put(-0.1, -10.016686131634776);
        put(0.0, Double.POSITIVE_INFINITY);
        put(0.1, 10.016686131634776);
        put(0.2, 5.033489547672344);
        put(0.3, 3.383863361824123);
        put(0.4, 2.567932455547783);
        put(0.5, 2.085829642933488);
        put(0.6, 1.7710321966877254);
        put(0.7, 1.552270326957104);
        put(0.8, 1.394007819388636);
        put(0.9, 1.2766062134588954);
    }};
    final Map<Double, Double> secTable = new HashMap<>() {{
        put(-0.9, 1.6087258104660498);
        put(-0.8, 1.43532419967224);
        put(-0.7, 1.3074592597335937);
        put(-0.6, 1.2116283145123166);
        put(-0.5, 1.139493927324549);
        put(-0.4, 1.0857044283832387);
        put(-0.3, 1.0467516015380856);
        put(-0.2, 1.0203388449411928);
        put(-0.1, 1.0050209184004553);
        put(0.0, 1.0);
        put(0.1, 1.0050209184004553);
        put(0.2, 1.0203388449411928);
        put(0.3, 1.0467516015380856);
        put(0.4, 1.0857044283832387);
        put(0.5, 1.139493927324549);
        put(0.6, 1.2116283145123166);
        put(0.7, 1.3074592597335937);
        put(0.8, 1.43532419967224);
        put(0.9, 1.6087258104660498);
    }};
    final Map<Double, Double> lnTable = new HashMap<>() {{
        put(-0.9, Double.NaN);
        put(-0.8, Double.NaN);
        put(-0.7, Double.NaN);
        put(-0.6, Double.NaN);
        put(-0.5, Double.NaN);
        put(-0.4, Double.NaN);
        put(-0.3, Double.NaN);
        put(-0.2, Double.NaN);
        put(-0.1, Double.NaN);
        put(0.0, Double.NaN);
        put(0.1, -2.3025850929940455);
        put(0.2, -1.6094379124341003);
        put(0.3, -1.2039728043259361);
        put(0.4, -0.916290731874155);
        put(0.5, -0.6931471805599453);
        put(0.6, -0.5108256237659907);
        put(0.7, -0.35667494393873245);
        put(0.8, -0.2231435513142097);
        put(0.9, -0.10536051565782628);
    }};
    final Map<Double, Double> ln2Table = new HashMap<>() {{
        put(-0.9, Double.NaN);
        put(-0.8, Double.NaN);
        put(-0.7, Double.NaN);
        put(-0.6, Double.NaN);
        put(-0.5, Double.NaN);
        put(-0.4, Double.NaN);
        put(-0.3, Double.NaN);
        put(-0.2, Double.NaN);
        put(-0.1, Double.NaN);
        put(0.0, Double.NaN);
        put(0.1, -3.321928094887362);
        put(0.2, -2.321928094887362);
        put(0.3, -1.7369655941662063);
        put(0.4, -1.3219280948873622);
        put(0.5, -1.0);
        put(0.6, -0.7369655941662062);
        put(0.7, -0.5145731728297583);
        put(0.8, -0.3219280948873623);
        put(0.9, -0.15200309344504995);
    }};
    final Map<Double, Double> ln3Table = new HashMap<>() {{
        put(-0.9, Double.NaN);
        put(-0.8, Double.NaN);
        put(-0.7, Double.NaN);
        put(-0.6, Double.NaN);
        put(-0.5, Double.NaN);
        put(-0.4, Double.NaN);
        put(-0.3, Double.NaN);
        put(-0.2, Double.NaN);
        put(-0.1, Double.NaN);
        put(0.0, Double.NaN);
        put(0.1, -2.0959032742893844);
        put(0.2, -1.4649735207179269);
        put(0.3, -1.0959032742893846);
        put(0.4, -0.8340437671464696);
        put(0.5, -0.6309297535714574);
        put(0.6, -0.4649735207179272);
        put(0.7, -0.32465952512796237);
        put(0.8, -0.20311401357501224);
        put(0.9, -0.09590327428938458);
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

    private static Stream<Arguments> fnValues() {
        return Stream.of(
                Arguments.of(-0.9, -1.335747),
                Arguments.of(-0.8, -1.515089),
                Arguments.of(-0.7, -1.667577),
                Arguments.of(-0.6, -1.790705),
                Arguments.of(-0.5, -1.883594),
                Arguments.of(-0.4, -1.947220),
                Arguments.of(-0.3, -1.984537),
                Arguments.of(-0.2, -2.000514),
                Arguments.of(-0.1, -2.002320),
                Arguments.of(0.0, Double.NaN),
                Arguments.of(0.1, -10151970560.936403),
                Arguments.of(0.2, -47144218.941045),
                Arguments.of(0.3, -606130.252194),
                Arguments.of(0.4, -10089.051282),
                Arguments.of(0.5, -153.985575),
                Arguments.of(0.6, -2.040425),
                Arguments.of(0.7, -0.331861),
                Arguments.of(0.8, -0.203120),
                Arguments.of(0.9, -0.095903)
        );
    }



    @ParameterizedTest
    @MethodSource("fnValues")
    public void testCos(double x, Double expected){
        cos.when((() -> Cos.of(any(Double.class)))).thenCallRealMethod();
        assertEquals(expected, Fn.of(x), expected.isInfinite() || expected.isNaN() ? 0 : Precision.E * Math.abs(expected));
    }

    @ParameterizedTest
    @MethodSource("fnValues")
    public void testSin(double x, Double expected) {
        sin.when((() -> Sin.of(any(Double.class)))).thenCallRealMethod();
        assertEquals(expected, Fn.of(x), expected.isInfinite() || expected.isNaN() ? 0 : Precision.E * Math.abs(expected));
    }

    @ParameterizedTest
    @MethodSource("fnValues")
    public void testTg(double x, Double expected) {
        tg.when((() -> Tg.of(any(Double.class)))).thenCallRealMethod();
        assertEquals(expected, Fn.of(x), expected.isInfinite() || expected.isNaN() ? 0 : Precision.E * Math.abs(expected));
    }

    @ParameterizedTest
    @MethodSource("fnValues")
    public void testCtg(double x, Double expected) {
        ctg.when((() -> Ctg.of(any(Double.class)))).thenCallRealMethod();
        assertEquals(expected, Fn.of(x), expected.isInfinite() || expected.isNaN() ? 0 : Precision.E * Math.abs(expected));
    }

    @ParameterizedTest
    @MethodSource("fnValues")
    public void testCsc(double x, Double expected) {
        csc.when((() -> Csc.of(any(Double.class)))).thenCallRealMethod();
        assertEquals(expected, Fn.of(x), expected.isInfinite() || expected.isNaN() ? 0 : Precision.E * Math.abs(expected));
    }

    @ParameterizedTest
    @MethodSource("fnValues")
    public void testSec(double x, Double expected) {
        sec.when((() -> Sec.of(any(Double.class)))).thenCallRealMethod();
        assertEquals(expected, Fn.of(x), expected.isInfinite() || expected.isNaN() ? 0 : Precision.E * Math.abs(expected));
    }

    @ParameterizedTest
    @MethodSource("fnValues")
    public void testLn(double x, Double expected) {
        ln.when((() -> Ln.of(any(Double.class)))).thenCallRealMethod();
        assertEquals(expected, Fn.of(x), expected.isInfinite() || expected.isNaN() ? 0 : Precision.E * Math.abs(expected));
    }

    @ParameterizedTest
    @MethodSource("fnValues")
    public void testLn2(double x, Double expected) {
        ln2.when((() -> Ln2.of(any(Double.class)))).thenCallRealMethod();
        assertEquals(expected, Fn.of(x), expected.isInfinite() || expected.isNaN() ? 0 : Precision.E * Math.abs(expected));
    }

    @ParameterizedTest
    @MethodSource("fnValues")
    public void testLn3(double x, Double expected) {
        ln3.when((() -> Ln3.of(any(Double.class)))).thenCallRealMethod();
        assertEquals(expected, Fn.of(x), expected.isInfinite() || expected.isNaN() ? 0 : Precision.E * Math.abs(expected));
    }
}
