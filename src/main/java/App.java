import java.util.ArrayList;
import java.util.List;
import java.io.Console;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
  Console console = System.console();
  private static String[] printArray(String[] anArray) {
    // System.out.println(Arrays.toString(anArray));
    return anArray;
  }

  // build a word from the user input
  public static String buildWord(String[] letters) {
    String word = "";

    int index = letters.length;

    for(int i = 0; i < index; i++) {
      if (letters[i] == "_") {
        word = word + " ";
      }
      word = word + letters[i];
    }
    return word;
  }

  // displays according to the numberOfLives a user has left
  public static void displayGallows(int lives) {

    switch(lives) {
      case 5:
             System.out.println(' ');
             System.out.println(' ');
             System.out.println(' ');
             System.out.println(' ');
             System.out.println(' ');
             System.out.println("------");
             break;
      case 4:
             System.out.println("      ");
             System.out.println("     |");
             System.out.println("     |");
             System.out.println("     |");
             System.out.println("     |");
             System.out.println("-----+");
             break;
      case 2:
             System.out.println("-----+");
             System.out.println("   \\|");
             System.out.println("     |");
             System.out.println("     |");
             System.out.println("     |");
             System.out.println("-----+");
             break;
      case 1:
             System.out.println("-----+");
             System.out.println("|  \\|");
             System.out.println("     |");
             System.out.println("     |");
             System.out.println("     |");
             System.out.println("-----+");
             break;
      case 0:
             System.out.println("-----+");
             System.out.println("|  \\|");
             System.out.println("o    |");
             System.out.println("+    |");
             System.out.println("^  \\|");
             System.out.println("-----+");
             break;
    }
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
    // System.out.println(Arrays.toString(letters));

    // make a displayable list of empty spaces
    String[] displayable = new String[letters.length];
    for (int i = 0; i < random.length(); i++) {
      displayable[i] = "_";
      // System.out.println(Arrays.toString(displayable));
    }

    // premable to the game
    int numberOfLives = 6;
    ArrayList<String> guesses = new ArrayList<String>();

    Scanner input = new Scanner(System.in);
    System.out.println("Random Hangman, I CHOOSE YOU!");
    System.out.println(buildWord(displayable));
    System.out.println("You have 6 lives!");
    boolean gameOn = true;

    // main game loop
    while (gameOn == true) {

      // takes user input
      System.out.println("Guess a letter: ");
      String guess = input.nextLine();

      // add the new guess to the list of guesses
      guesses.add(guess);

      // used for the app logic later but has to be reset each round
      boolean InWord = false;
      boolean Winner = false;

      // check input against each letter
      for (int i = 0; i < letters.length; i++) {
        if (letters[i].equals(guess)) {

          displayable[i] = guess;
          InWord = true;
        }
      }

      // display a list of displayable characters
      System.out.println(buildWord(displayable));
      System.out.println(" ");

      if (InWord == false) {

        // incorrect guess
            numberOfLives = numberOfLives - 1;
            displayGallows(numberOfLives = 0);
            System.out.println("Incorrect!");
            System.out.println("You have " + Integer.toString(numberOfLives) + " lives left!");
            System.out.println("The Hangman was " + buildWord(letters) + "!");
            gameOn = false;
            break;
        }
      }
    }
  }
