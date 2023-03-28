import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import ru.itmo.func.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test {
    MockedStatic<Cos> cos;
    MockedStatic<Csc> csc;
    MockedStatic<Ctg> ctg;
    MockedStatic<Ln> ln;
    MockedStatic<Log2> log2;
    MockedStatic<Log3> log3;
    MockedStatic<Sec> sec;
    MockedStatic<Sin> sin;
    MockedStatic<Tg> tg;

    @BeforeAll
    void doMock(){
        this.cos = Mockito.mockStatic(Cos.class);
        this.csc = Mockito.mockStatic(Csc.class);
        this.ctg = Mockito.mockStatic(Ctg.class);
        this.ln = Mockito.mockStatic(Ln.class);
        this.log2 = Mockito.mockStatic(Log2.class);
        this.log3 = Mockito.mockStatic(Log3.class);
        this.sec = Mockito.mockStatic(Sec.class);
        this.sin = Mockito.mockStatic(Sin.class);
        this.tg = Mockito.mockStatic(Tg.class);

    }
}
