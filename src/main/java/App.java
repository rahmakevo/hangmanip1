import java.util.ArrayList;
import java.util.List;
import java.io.Console;
import java.util.Arrays;
import java.util.Random;

public class App {
  Console console = System.console();
  private static String[] printArray(String[] anArray) {
    System.out.println(Arrays.toString(anArray));
    return anArray;
  }
  public static void main(String[] args) {
    String[] outputWord = {"John", "kevin", "victor"};
    printArray(outputWord);

    //randomize array
    Random generator = new Random();
    int index = new Random().nextInt(outputWord.length);
    String random = (outputWord[index]);
    String[] letters = random.split("(?!^)");
    letters = Arrays.copyOfRange(letters, 0, letters.length);
    System.out.println(Arrays.toString(letters));

    // make a displayable list of empty spaces
    String[] displayable = new String[letters.length];
    for (int i = 0; i < random.length(); i++) {
      displayable[i] = "_";
      System.out.println(Arrays.toString(displayable));
    }
  }
}
