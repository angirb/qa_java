import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.example.Feline;
import com.example.Lion;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)

public class LionsGenderTest {

    private final String lionSex;
    private final boolean lionHasMane;

    public LionsGenderTest(String lionSex, boolean lionHasMane) {
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
}