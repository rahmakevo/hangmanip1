import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class AppTest {

  @Test
  public void printArray_PrintString_ArrayList() {
    App testWordArray = new App();
    String[] expectedOutput = new String();
    String[] anArray = {"John", "kevin", "victor"};
    assertEquals(expectedOutput, testWordArray.printArray(anArray));
   }
}
