import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineGetKittensIntTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 0 },
                { 1, 1 },
                { 2, 2 },
                { Integer.MAX_VALUE, Integer.MAX_VALUE }
        });
    }

    private final int kittensCountInput;

    private final int kittensCountExpected;

    public FelineGetKittensIntTest(int kittensCountInput, int kittensCountExpected) {
        this.kittensCountInput = kittensCountInput;
        this.kittensCountExpected = kittensCountExpected;
    }

    @Test
    public void getKittensPositiveAndZeroNumbersReturnsTheSameNumber() throws Exception {
        Feline feline = new Feline();
        int count = feline.getKittens(kittensCountInput);
        assertEquals(kittensCountExpected, count);
    }
}
