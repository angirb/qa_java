import org.junit.Assert;
import org.junit.Test;
import com.example.Feline;

import java.util.List;

import static org.junit.Assert.assertEquals;



public class FelineTest {

    @Test
    public void felineTestEatFood() throws Exception {
        Feline feline = new Feline();
        List<String> actual = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actual);
    }
    @Test
    public void felineCheckKittens() {
        Feline feline = new Feline();
        Assert.assertEquals(4, feline.getKittens());
    }
    @Test
    public void felineTestGetFamily() {
        Feline feline = new Feline();
        String actual = feline.getFamily();
        String expected = "Кошачьи";
        assertEquals(expected, actual);

    }
    @Test
    public void felineTest() {
        Feline feline = new Feline();
        int actual = feline.getKittens();
        int expected = 4;
        assertEquals(expected, actual);
    }
}
