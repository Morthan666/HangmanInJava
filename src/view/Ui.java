package view;

import model.Capital;

import javax.swing.*;
import java.util.ArrayList;

public class Ui {

    public static Integer mainMenu() {
        Object[] options = {"New game", "Exit"};
        Integer n = JOptionPane.showOptionDialog(null,
                "Menu",
                "Hangman Game",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        return n;

    }

    public static Integer wordOrLetter(Integer lives, Capital city, ArrayList<Character> wrongLetters) {
        Object[] options = {"Word", "Letter", "Back to menu"};
        String letters = "none yet";
        if (wrongLetters.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (Character s : wrongLetters) {
                sb.append(s);
                sb.append(" ");
            }
            letters = sb.toString();
        }
        String dash = city.getDash().replace("", " ").trim();
        Object[] data = {lives, dash, letters};
        Integer n = JOptionPane.showOptionDialog(null,
                String.format(" Chances left: %d \n Word to guess: %s\n Wrong letters: %s\nWould you like to guess one letter or a whole word?", data),
                "Hangman Game",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        return n;
    }

    public static Character letterInput() {
        String guess = "  ";
        while (guess.length() != 1 || !Character.isLetter(guess.charAt(0))) {
            guess = JOptionPane.showInputDialog("Guess a letter: ");
            if (guess.length() != 1) {
                JOptionPane.showMessageDialog(null,
                        "Only one letter!",
                        "Hangman Game",
                        JOptionPane.ERROR_MESSAGE);
            } else if (!Character.isLetter(guess.charAt(0))) {
                JOptionPane.showMessageDialog(null,
                        "A letter, please!",
                        "Hangman Game",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        Character charGuessed = guess.charAt(0);
        return Character.toUpperCase(charGuessed);
    }

    public static String wordInput() {
        String word = "";
        while (word.length() < 1) {
            word = JOptionPane.showInputDialog("What's your guess?");
            if (word.length() < 1) {
                JOptionPane.showMessageDialog(null,
                        "That's hardly any word!",
                        "Hangman Game",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return word.toUpperCase();
    }

    public static void wrongMessage() {
        JOptionPane.showMessageDialog(null,
                "Wrong!",
                "Hangman Game",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void alreadyGuessedMessage() {
        JOptionPane.showMessageDialog(null,
                "You've already guessed it!",
                "Hangman Game",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void gameOver(Capital city) {
        JOptionPane.showMessageDialog(null,
                String.format("You lost!\nIt was %s", city.getName()),
                "Hangman Game",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void correctMessage() {
        JOptionPane.showMessageDialog(null, "Correct!");
    }

    public static void wonMessage() {
        JOptionPane.showMessageDialog(null, "You won!");
    }
}
