package Hangman_game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("C:\\Users\\walls\\Documents\\CSharp&Java\\SENLA\\SENLA-2024-Java-Course\\src\\Hangman_game\\words_array.txt"));
        Scanner kb = new Scanner(System.in);

        List<String> words = new ArrayList<>();
        while (scan.hasNext()){
            words.add(scan.nextLine());
        }

        Random rand = new Random();

        String word = words.get(rand.nextInt(words.size()));

        List<Character> playerGuesses = new ArrayList<>();


        int wrongCount = 0;
        while (true) {
            printHangman(wrongCount);

            if (wrongCount >= 6){
                System.out.println("You lost!");
                System.out.println("The unguessed word was " + word);
                break;
            }
            if (wrongCount >= 1 && wrongCount < 5){
                System.out.println("You have "+(6-wrongCount)+" attempts left!");
            }
            if (wrongCount == 5){
                System.out.println("You have only ONE attempt left!");
            }


            showWordState(word, playerGuesses);
            if (!getPlayerGuess(kb, word, playerGuesses)){
                wrongCount++;
                printHangman(wrongCount);
            }

            if(showWordState(word, playerGuesses)){
                System.out.println("You Win!");
                break;
            }

//            System.out.println("You can now try to guess the whole word: ");
//            if (kb.nextLine().equals(word)) {
//                System.out.println("You Win!");
//                break;
//            }
//            else {
//                System.out.println("Nope! Try again.");
//                wrongCount++;
//            }
        }
    }

    private static void printHangman(int wrongCount){
        System.out.println("_______");
        System.out.println("   |");
        if (wrongCount >= 1){
            System.out.println("   0");
        }

        if (wrongCount >= 2){
            System.out.print("  \\ ");
            if (wrongCount >= 3){
                System.out.print("/");
            }
            else {
                System.out.println();
            }
        }

        if (wrongCount >= 4){
            System.out.println();
            System.out.println("   |");
        }
        if (wrongCount >= 5){
            System.out.print("  / ");
            if (wrongCount >= 6){
                System.out.print("\\");
            }
            else {
                System.out.println();
            }
        }
        System.out.println();
    }
    private static boolean getPlayerGuess(Scanner kb, String word, List<Character> playerGuesses){
        System.out.print("Please enter a letter: ");
        String letterGuess = kb.nextLine();
        playerGuesses.add(letterGuess.charAt(0));

        return word.contains(letterGuess);
    }
    private static boolean showWordState(String word, List<Character> playerGuesses){
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctCount++;
            } else {
                System.out.print("_");
            }
        }
        System.out.println();

        return (word.length() == correctCount);
    }
}