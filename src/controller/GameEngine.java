package controller;

import model.Capital;
import model.Capitals;
import view.Ui;

import java.util.ArrayList;

public class GameEngine {

    public static Capital drawCapital() {
        String capital = Capitals.getCapital();
        String dashed = Capitals.dashCapital(capital);
        Capital city = new Capital();
        city.setName(capital);
        city.setDash(dashed);
        return city;
    }

    public static void inGameMenu() {
        Integer lives = 5;
        ArrayList<Character> wrongLetters = new ArrayList<Character>();
        ;
        Capital word = drawCapital();
        loop:
        while (true) {
            if (lives < 1) {
                Ui.gameOver(word);
                break loop;
            }
            if (word.getName().equals(word.getDash())) {
                Ui.wonMessage();
                break loop;
            }
            Integer choice = Ui.wordOrLetter(lives, word, wrongLetters);
            try {
                if (choice == 1) {

                    Character letter = Ui.letterInput();
                    String initialValidation = Validator.inputValidator(letter, word);
                    if (initialValidation.equals("Correct")) {
                        word.setDash(Validator.validateLetter(letter, word));
                        Ui.correctMessage();
                    } else if (initialValidation.equals("Wrong")) {
                        lives--;
                        wrongLetters.add(letter);
                        Ui.wrongMessage();
                    } else {
                        Ui.alreadyGuessedMessage();
                    }
                } else if (choice == 0) {
                    String input = Ui.wordInput();
                    if (Validator.validateWord(input, word)) {
                        Ui.wonMessage();
                        break loop;
                    } else {
                        Ui.wrongMessage();
                        lives--;
                    }
                } else {
                    break loop;
                }
            } catch (NullPointerException cancel) {
                continue loop;
            }
        }

    }
}
