import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    private Feline feline;

    private Cat cat;

    @Before
    public void setCat() throws Exception {
        this.cat = new Cat(feline);
    }

    @Test
    public void getSoundReturnsMeow() throws Exception {
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    @Test
    public void getFoodReturnsMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        List<String> food = cat.getFood();

        assertEquals(expectedFood, food);
    }
}
