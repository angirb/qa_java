import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.example.Feline;
import com.example.Lion;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)

public class LionTest {

    private final String lionSex;
    private final boolean lionHasMane;

    public LionTest(String lionSex, boolean lionHasMane) {
        this.lionSex = lionSex;
        this.lionHasMane = lionHasMane;

    }

    @Parameterized.Parameters

    public static Object[][] getLionSex() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }
    @Test
    public void checkLionHasManeTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(lionSex, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(lionHasMane,actual);
    }
    @Test
    public void checkLionSexTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(lionSex, feline);
        boolean actual = lion.doesHaveMane();
        boolean expected = lionHasMane;
        assertEquals(expected, actual);
    }
    @Test
    public void lionGetKittensTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(lionSex, feline);
        int actual = lion.getKittens();
        int expected = feline.getKittens();
        Mockito.when(feline.getKittens()).thenReturn(expected);
        assertEquals(expected, actual);
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
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(lionSex, feline);
        List <String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List <String> actual = lion.getFood();
        assertEquals(expected, actual);

    }
}