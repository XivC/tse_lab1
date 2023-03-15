import org.junit.jupiter.api.Test;
import ru.itmo.bsort.GFG;

import java.util.*;
import java.util.stream.Collectors;

import static ru.itmo.bsort.GFG.fillBuckets;

public class TestSort {

    @Test

    void testFillBuckets() {
        assert Arrays.equals(fillBuckets(List.of(1f, 2f, 3f)), new List[]{
                List.of(1f),
                List.of(2f),
                List.of(3f)
        });
    }
    @Test
    void testVoidArray() {
        List<Float> nums = List.of();
        assert GFG.sort(nums).equals(nums);
    }


    @Test
    void testSort() {
        List<Float> nums = List.of( -0000f, 1f, 0.213f, 0.1111111f );
        assert GFG.sort(nums).equals(List.of( -0000f, 0.1111111f,  0.213f, 1f));
    }
}
