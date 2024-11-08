import com.example.AlexTheLion;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AlexTheLionTest {

    @Mock
    private Predator predatorMock;
    private AlexTheLion alexThelion;

    @Before
    public void setUp() throws Exception{
        predatorMock = mock(Predator.class);
        alexThelion = new AlexTheLion(predatorMock);
    }

    @Test
    public void testAlexTheLionIsMale() throws Exception{
        assertTrue("Алекс должен быть самцом", alexThelion.doesHaveMane());
    }

    @Test
    public void testGetFriendsReturnsCorrectListOfFriends() throws Exception{

        List<String> expectedFriends = List.of("Зебра Мартин", "бегемотиха Глория", "жираф Мелман");
        assertEquals("Должен вернуться список друзей: \"Зебра Мартин\", \"бегемотиха Глория\", \"жираф Мелман\"",
                expectedFriends, alexThelion.getFriends());
    };

    @Test
    public void testGetPlaceOfLivingReturnsNewYorkZoo() throws Exception{

        assertEquals("Место жительства должно быть Нью-Йоркский зоопарк", "Нью-Йоркский зоопарк", alexThelion.getPlaceOfLiving());
    }

    @Test
    public void testGetKittensReturnsZero() throws Exception{

        assertEquals("Количество котят должно быть 0", 0, alexThelion.getKittens());
    }

    @Test
    public void testGetFoodCallsPredatorEatMeat() throws Exception{
        when(predatorMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        assertEquals(List.of("Животные", "Птицы", "Рыба"), alexThelion.getFood());

        verify(predatorMock, times(1)).eatMeat();
    }

}
