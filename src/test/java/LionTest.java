import com.example.Lion;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Predator predatorMock;
    private Lion lion;

    @Before
    public void init() throws Exception{
        predatorMock = mock(Predator.class);
        lion = new Lion(predatorMock);
    }

    @Test
    public void testGetKittensReturnsCorrectNumber() throws Exception{
        when(predatorMock.getKittens()).thenReturn(5);

        assertEquals("Количество котят должно быть 5",5, lion.getKittens());
    }

    @Test
    public void testGetFoodCallsEatMeat() throws Exception {
        when(predatorMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> food = lion.getFood();

        assertEquals("Список еды должен содержать: \"Животные\", \"Птицы\", \"Рыба\"", List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void testLionConstructorThrowsExceptionForInvalidSex() {
        try {
            new Lion("Некорректный Пол", predatorMock);

            fail("Ожидалось выбросить Exception при некорректном значении пола");
        } catch (Exception e) {

            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }
}
