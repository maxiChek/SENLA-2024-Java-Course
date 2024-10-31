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

        List<String> words = new ArrayList<>();
        while (scan.hasNext()){
            words.add(scan.nextLine());
        }

        Random rand = new Random();

        String word = words.get(rand.nextInt(words.size()));
        System.out.println(word);
    }
}