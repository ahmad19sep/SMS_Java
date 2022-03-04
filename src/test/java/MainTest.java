import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testAddDouble() {
        double answer = Main.addTwoDoubles(1.5, 2.5);
        Assertions.assertEquals(4.0, answer);
    }
}
