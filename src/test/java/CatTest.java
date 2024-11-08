import com.example.Cat;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Predator predatorMock;
    Cat cat;

    @Before
    public void init(){
        predatorMock = Mockito.mock(Predator.class);
        cat = new Cat(predatorMock);
    }

    @Test
    public void testGetSoundReturnsMeow(){
        assertEquals("Звук кошки должен быть 'Мяу'", "Мяу", cat.getSound());
    }

    @Test
    public void testGetFoodCallsEatMeat() throws Exception{
        when(predatorMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> food = cat.getFood();
        assertEquals("Список еды должен содержать: \"Животные\", \"Птицы\", \"Рыба\"", List.of("Животные", "Птицы", "Рыба"), food);

        verify(predatorMock, times(1)).eatMeat();
    }

    @Test
    public void testEatMeatThrowsExceptionWhenGetFoodFails() throws Exception{

        when(predatorMock.getFood("Неизвестный вид")).
                thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));

        Exception exception = assertThrows(Exception.class, () -> {
            predatorMock.getFood("Неизвестный вид");
        });

        assertEquals("Метод getFood должен выбрасывать исключение с текстом Неизвестный вид животного, используйте значение Травоядное или Хищник",
                "Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());

    }

}




