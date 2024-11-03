package Password_generator;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String digit = "0123456789";
        String specialChar = "!@#$%^&*()_+-={}[]|:;.,<>?";
        String integration = upperCase + lowerCase + digit + specialChar;

        System.out.println("Enter the desired length of your password\n(minimum 8 symbols, maximum 12 symbols):");
        Scanner scan = new Scanner(System.in);
        int length;
        length = scan.nextInt();
        switch (length){
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            default:
                System.out.println("\nYou entered invalid number. Due to security issues the program has terminated.\nTry from the beginner!");
                throw new IllegalArgumentException();
        }

        char[] password = new char[length];
        Random rand = new Random();

        for(int i=0; i<length; i++){
            password[i]=integration.charAt(rand.nextInt(integration.length()));
        }
        System.out.println("Your Generated Password: " + new String(password));
    }
}