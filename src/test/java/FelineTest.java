import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.example.Feline;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class FelineTest {

    private final int kittenCount;
    private final int getKittenCount;

    public FelineTest(int kittenCount, int getKittenCount) {
        this.kittenCount = kittenCount;
        this.getKittenCount = getKittenCount;
    }
    @Parameterized.Parameters

    public static Object[][] kittenCount() {
        return new Object[][] {
                {1, 1,},
                {9, 9},
                {19, 19}
        };
    }
    @Test
    public void felineTest() {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittenCount);
        assertEquals(getKittenCount, actual);
    }
    @Test
    public void felineTestEatFood() throws Exception {
        Feline feline = new Feline();
        List <String> actual = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actual);
    }
    @Test
    public void felineCheckKittens() {
        Feline feline = new Feline();
        Assert.assertEquals(1, feline.getKittens());
    }
    @Test
    public void felineTestGetFamily() {
        Feline feline = new Feline();
        String actual = feline.getFamily();
        String expected = "Кошачьи";
        assertEquals(expected, actual);

    }
}
