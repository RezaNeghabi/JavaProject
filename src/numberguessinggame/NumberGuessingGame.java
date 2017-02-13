/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberguessinggame;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * Number Guessing Game with two options: First guessing a number in a file
 * and second, guessing a random number!
 */
public class NumberGuessingGame {
    
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    
    /**
     * @param args
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException 
    {
        boolean guess = false;
        int numberToGuess;
        int guessedNumber;
        int maxNumberOfTries = 5;
        int numberOfTries;
        
        
        Scanner console = new Scanner (System.in);
        Scanner inFile; 
        inFile = new Scanner (new FileReader("NumberToGuess.txt"));
        Random rand = new Random();
                
        System.out.println("This is a guessing game.");
        System.out.print("Select to guess the value in the " + ANSI_GREEN + "F" 
                + ANSI_RESET+ "ile or a " + ANSI_RED + "R" + ANSI_RESET +
                "andom" + " nmuber (1-100)? (F / R) ");
        String selection = console.next();
        
        if ((selection.equals("R")) || (selection.equals("r")))
            {     
                numberToGuess = rand.nextInt(100)+1;
                System.out.print("Guess a number between 1 and 100: ");
                  
                for (numberOfTries = 0; numberOfTries < maxNumberOfTries ; 
                        numberOfTries++)
                {
                    guessedNumber = console.nextInt();
                    
                    if ((guessedNumber > numberToGuess) && (numberOfTries < 
                            (maxNumberOfTries -1)))
                        System.out.print("The value is less than "
                                + guessedNumber + ", guess again: ");
                    
                    else if ((guessedNumber < numberToGuess) && (numberOfTries <
                            (maxNumberOfTries -1)))
                        System.out.print("The value is greater than "
                                + guessedNumber + ", guess again: ");
                    
                    else if ((guessedNumber != numberToGuess) && (numberOfTries 
                            == (maxNumberOfTries-1) ))
                        System.out.println("You lost :-( The number is: " + 
                                numberToGuess);
                    
                    else if (guessedNumber == numberToGuess)
                        {
                            System.out.println("Congratulation, you got it in "
                                    + (numberOfTries + 1) + " tries!");
                            numberOfTries = maxNumberOfTries;
                        }
                }               
            }    
        else if ((selection.equals("F")) || (selection.equals("f")))
            {
                numberToGuess = inFile.nextInt();
                System.out.print("Guess a number between 1 and 100: ");
                
                for (numberOfTries = 0; numberOfTries < maxNumberOfTries ; 
                        numberOfTries++)
                {
                    guessedNumber = console.nextInt();
                    
                    if ((guessedNumber > numberToGuess) && (numberOfTries < 
                            (maxNumberOfTries -1)))
                        System.out.print("The value is less than "
                                + guessedNumber + ", guess again: ");
                    
                    else if ((guessedNumber < numberToGuess) && (numberOfTries 
                            < (maxNumberOfTries -1)))
                        System.out.print("The value is greater than "
                                + guessedNumber + ", guess again: ");
                    
                    else if ((guessedNumber != numberToGuess) && (numberOfTries
                            == (maxNumberOfTries-1) ))
                        System.out.println("You lost :-( The number is: " + 
                                numberToGuess);
                    
                    else if (guessedNumber == numberToGuess)
                        {
                            System.out.println("Congratulation, you got it in " 
                                    + (numberOfTries + 1) + " tries!");
                            numberOfTries = maxNumberOfTries;
                        }   
                }
            }
    }
}

    
    
    
    
    
        
    
    
    
    
    
   
    
    
    
    
    
