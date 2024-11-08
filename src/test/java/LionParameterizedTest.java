import com.example.Lion;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;
    private final boolean expectedMane;

    @Mock
    private Predator predatorMock;
    private Lion lion;

    public LionParameterizedTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Before
    public void init() throws Exception{
        MockitoAnnotations.initMocks(this);
        lion = new Lion(sex, predatorMock);
    }

    @Parameterized.Parameters
    public static Object[][] objects() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void doesHaveMane() {
        assertEquals("У льва должна быть грива", expectedMane, lion.doesHaveMane());
    }

}
