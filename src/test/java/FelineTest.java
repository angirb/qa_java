import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.example.Feline;

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
                {4, 4},
                {5, 5},

        };
    }
    @Test
    public void felineTest() {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittenCount);
        int expected = feline.getKittens(getKittenCount);
        assertEquals(expected, actual);
    }
    @Test
    public void felineTest2() {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittenCount);
        int expected = feline.getKittens(getKittenCount);
        assertEquals(expected, actual);
    }


}
