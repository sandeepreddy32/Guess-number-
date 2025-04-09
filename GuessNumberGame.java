import javax.swing.JOptionPane;
import java.util.Random;

public class GuessNumberGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(10) + 1; // Generate a random number between 1 and 10
        int attempts = 3; // Number of attempts allowed
        boolean guessedCorrectly = false;

        // Game loop, allowing up to 'attempts' number of guesses
        for (int i = 0; i < attempts; i++) {
            String input = JOptionPane.showInputDialog("Guess a number between 1 and 10:");

            // Handle the case where the user cancels the input dialog
            if (input == null) { 
                JOptionPane.showMessageDialog(null, "Game cancelled.");
                return;  // Exit the game if canceled
            }

            try {
                int userGuess = Integer.parseInt(input); // Convert input to integer

                // Check if the guess is correct
                if (userGuess == randomNumber) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    break; // End the game if guessed correctly
                } 
                // If the guess is too low or too high
                else if (userGuess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Too Low! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too High! Try again.");
                }
            } catch (NumberFormatException e) {
                // Handle invalid input that cannot be parsed to an integer
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.");
            }
        }

        // If the user fails to guess correctly in all attempts
        if (!guessedCorrectly) {
            JOptionPane.showMessageDialog(null, "Sorry, you've used all your attempts. The correct number was: " + randomNumber);
        }
    }
}