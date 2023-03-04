import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.example.Animal;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)


public class AnimalTest {
    private final String animalFamily;
    private final List<String> animalFood;

    public AnimalTest(String animalFamily, List<String> animalFood) {
        this.animalFamily = animalFamily;
        this.animalFood = animalFood;
    }
    @Parameterized.Parameters
    public static Object[][] getAnimalKind() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        };
    }
    @Test
    public void checkAnimalKind() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood(animalFamily);
        assertEquals(animalFood, actual);

    }
    @Test
    public void checkAnimalFamily() {
        Animal animal = new Animal();
        String actual = animal.getFamily();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(actual, expected);
    }
    @Test
    public void testAnimalGetFoodException() throws Exception {
        Animal animal = new Animal();
        String unknownKindOfAnimal = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        Exception actual = null;
        try {
            animal.getFood(unknownKindOfAnimal);
        } catch (Exception e) {
            actual = e;

        }
        Assert.assertNotNull(actual);
    }
}