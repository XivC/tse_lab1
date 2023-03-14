import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.itmo.domain.*;

import java.util.stream.Stream;

public class TestPerson {

    private Person person;

    @BeforeEach
    void init() {
        person = new Person(
                "Кек",
                new Location("Мостик"),
                0x00FF00,
                0
        );
    }

    @Test
    void testMove() {
        int start = person.getLocation().getCoordinate();
        person.move();
        int end = person.getLocation().getCoordinate();
        assert start + 1 == end;
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void testDestroy(boolean isInhabited) {
        Planet planet = new Planet(isInhabited);
        assert !planet.isDestroyed();
        try {
            person.destroy(planet);
            assert isInhabited;
        } catch (InformerPerson informer) {
            assert !isInhabited;
        }
        assert planet.isDestroyed();
    }

    @Test
    void testShout() {
        InformerPerson informer = new InformerPerson("", person.getLocation());
        int personMoodInitial = person.getMood();
        int informerMoodInitial = informer.getMood();
        person.shout(informer);
        assert personMoodInitial + 1 == person.getMood();
        assert informerMoodInitial - 1 == informer.getMood();
    }

    @ParameterizedTest
    @MethodSource("sitValues")
    void testSit(int resistance, int mood) {
        person.setMood(mood);
        Chair chair = new Chair(resistance);
        int damage = -person.getMood();
        Sound sound = person.sit(chair);
        if (resistance - damage > 0) {
            assert sound == Sound.PITY_CREAK;
        } else {
            assert sound == Sound.CRASH;
        }
    }

    private static Stream<Arguments> sitValues() {
        return Stream.of(
                Arguments.of(-1, 1),
                Arguments.of(0, 1),
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(-1, 0),
                Arguments.of(0, 0),
                Arguments.of(1, 0),
                Arguments.of(2, 0),
                Arguments.of(-1, -1),
                Arguments.of(0, -1),
                Arguments.of(1, -1),
                Arguments.of(2, -1)
        );
    }
}
