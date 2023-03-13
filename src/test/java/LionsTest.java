import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.example.Feline;
import com.example.Lion;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class LionsTest {

@Mock
Feline feline;

    @Test
    public void lionGetKittensTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самец", feline);
        int expected = 4;
        Mockito.when(feline.getKittens()).thenReturn(expected);
        int actual = lion.getKittens();
        assertEquals(expected,actual);
    }
    @Test
    public void sexLionExceptionTest() {
        Feline feline = Mockito.mock(Feline.class);
        String sexLionIsIncorrect = "Используйте допустимые значения пола животного - самец или самка";
        Exception actual = null;
        try {
            new Lion(sexLionIsIncorrect, feline);
        } catch (Exception exception) {
            actual = exception;
        }
        Assert.assertNotNull(actual);
    }
    @Test
    public void lionGetFoodTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn((List.of("Животные", "Птицы", "Рыба")));
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);

    }
}
