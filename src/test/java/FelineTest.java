import com.example.Feline;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;


public class FelineTest {

    @Test
    public void shouldReturnFoodForPredator() throws Exception {
        Feline feline = new Feline();

        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        List<String> actualFood = feline.eatMeat();

        assertEquals("Метод eatMeat() должен возвращать список пищи для хищница", expectedFood, actualFood);

    }

    @Test
    public void getFoodCallsSuperMethod() throws Exception {
        Feline feline = new Feline();

        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        List<String> actualFood = feline.getFood("Хищник");

        assertEquals("Метод getFood() должен вызвать метод суперкласса и возвратить список пищи для хищника", expectedFood, actualFood);

    }

    @Test
    public void getFamilyReturnFeline() throws Exception {
        Feline feline = new Feline();

        String expectedFamily = "Кошачьи";

        String actualFamily = feline.getFamily();

        assertEquals("Метод getFamily() должен возвращать 'Кошачьи', но вернул: " + actualFamily, expectedFamily, actualFamily);
    }

    @Test
    public void testGetKittensReturnsDefaultCount() throws Exception{
        Feline feline = new Feline();

        int expectedCount = 1;

        int actualCount = feline.getKittens();

        assertEquals("Метод getKittens() не возвращает ожидаемое количество котят по умолчанию", expectedCount, actualCount);

    }

    @Test
    public void testGetKittensWithParameter() throws Exception{
        Feline feline = new Feline();

        int expectedCount = 4;

        int actualCount = feline.getKittens(4);

        assertEquals("Метод getKittens(int kittensCount) должен вернуть: " + expectedCount + " , но вернул: " + actualCount, expectedCount, actualCount);
    }

    @Test
    public void testGetFoodThrowsExceptionForUnknownType() throws Exception{
        Feline feline = new Feline();

        Exception exception = assertThrows(Exception.class, () -> {
            feline.getFood("Неизвестный тип");
        });

        String expectedMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        String actualMessage = exception.getMessage();

        assertEquals("От метода getFood() ожидалось исключение при передаче неизвестного типа животного", expectedMessage, actualMessage);
    }

}