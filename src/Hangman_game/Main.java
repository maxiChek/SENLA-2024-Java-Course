package Hangman_game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String secretExpression = "Java programming is fun";

        int secretExpressionLength = secretExpression.length();

        String playerExpression = "_".repeat(secretExpressionLength);

        int guesses=5;
        while (guesses>0) {
            System.out.println(playerExpression);

            System.out.print("Enter your next guess: ");
            char playerGuess = kb.next().charAt(0);

            if (secretExpression.contains(playerGuess + "")) {
                //System.out.println("Correct");

                String temp="";
                for(int i=0;i<secretExpressionLength;i++){
                    if(playerGuess==secretExpression.charAt(i)){
                        temp+=playerGuess;
                    }
                    else {
                        temp+=playerExpression.charAt(i);
                    }
                }
                playerExpression= temp;

                // end the game
                if (playerExpression.equals(secretExpression.replaceAll(" ", "_"))){
                    System.out.println("you won the game");
                    System.out.println("Secrete Expression: "+secretExpression);
                    break;
                }
            } else {
                System.out.println("InCorrect");
                guesses--;
                System.out.println("Remaining guesses: " + guesses);
            }
        }
    }
}