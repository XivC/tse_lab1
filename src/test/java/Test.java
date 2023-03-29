import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import ru.itmo.func.*;

import static org.mockito.Mockito.when;

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


    }
}
