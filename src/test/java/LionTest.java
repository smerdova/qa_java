import com.example.Cat;
import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    private Feline feline;

    private Lion lionMale;

    private Lion lionFemale;

    @Before
    public void setLions() throws Exception {
        this.lionMale = new Lion(feline, "Самец");
        this.lionFemale = new Lion(feline, "Самка");
    }

    @Test(expected = Exception.class)
    public void constructorUnknownSexThrowsException() throws Exception {
        new Lion(feline, "Неизвестный пол");
    }

    @Test
    public void getKittensWithoutParamsReturnsFromFeline() throws Exception {
        int expectedKittensCount = 1;
        Mockito.when(feline.getKittens()).thenReturn(expectedKittensCount);

        int count = lionMale.getKittens();

        assertEquals(expectedKittensCount, count);
    }

    @Test
    public void doesHaveManeMaleDoes() {
        boolean doesHaveMane = lionMale.doesHaveMane();
        assertTrue(doesHaveMane);
    }

    @Test
    public void doesHaveManeFemaleDoesNot() {
        boolean doesHaveMane = lionFemale.doesHaveMane();
        assertFalse(doesHaveMane);
    }

    @Test
    public void getFoodReturnsPredatorFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        String predatorKind = "Хищник";
        Mockito.when(feline.getFood(predatorKind)).thenReturn(expectedFood);

        List<String> food = lionMale.getFood();

        assertEquals(expectedFood, food);
    }
}
