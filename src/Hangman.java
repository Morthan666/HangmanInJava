import controller.GameEngine;
import view.Ui;

class Hangman {

    public static void main(String[] args) {
        mainMenuLoop:
        while (true) {
            Integer choice = Ui.mainMenu();
            if (choice == 0) {
                GameEngine.inGameMenu();
            } else {
                break mainMenuLoop;
            }
        }
    }
}

