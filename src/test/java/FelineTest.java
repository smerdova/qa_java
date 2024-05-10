import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    Feline feline;

    @Before
    public void setFeline() throws Exception {
        this.feline = new Feline();
    }

    @Test
    public void getFamilyReturnsFeline() {
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
    }

    @Test
    public void eatMeatReturnsPredatorFood() throws Exception {
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void getKittensWithoutParamsReturnsOne() throws Exception {
        int count = feline.getKittens();
        assertEquals(1, count);
    }
}
