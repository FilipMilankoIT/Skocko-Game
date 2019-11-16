/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skocko.game;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Filip
 */
public class SkockoInterface {
    
    private static final int NUM_OF_ROUNDS = 6;
    
    private Skocko game;
    private SkockoSymbols[] combination;
    private Scanner input;
    private SkockoGraphics graphics;

    public SkockoInterface() {
        input = new Scanner(System.in);
        graphics = new SkockoGraphics();
    }
    
    public void startNewGame() {
        game = Skocko.getNewGame();
        combination = new SkockoSymbols[4];
        graphics.printIntro();
        boolean won = false;
        for(int i = 0; i < NUM_OF_ROUNDS; i++) {
            System.out.printf("Pokusaj %d od %d\n\n", i + 1, NUM_OF_ROUNDS);
            won = round();
            if (won) break;
            System.out.print("\n\n");
        }
        if (!won) {
            System.out.println("Izgubili ste :(");
        }
        printWuningCombination();
        boolean restart = askUserToRestartGame();
        if (restart) {
            clearScreen();
            startNewGame();
        }
    }
    
    private boolean round() {
        System.out.println("Iskucajte svoju kombinaciju (broj pa enter):");
        System.out.println("0 - Skocko, 1 - List, 2 - Detelina, 3 - Srce, 4 - Karo, 5 - Zvezda");
        getCombinationFromUser();
        System.out.println();
        printCombination();
        if (game.isWiningCombination(combination)) {
            System.out.println("BRAVO POGODIO SI! :D");
            return true;
        }
        System.out.println("Broj tacnih pozicija: " + 
                game.getNumOfCorrectlyPlacedSymbols(combination));
        System.out.println("Broj tacnih simbola: " + 
                game.getNumOfWronglyPlacedSymbols(combination));
        return false;
    }
    
    private void printCombination() {
        System.out.println("Tvoja kombinacija:");
        graphics.printCombination(combination);
    }
    
    private void getCombinationFromUser() {
        for (int i = 0; i < combination.length; i++) {
            int symbol;
            try {
                symbol = input.nextInt();
            } catch(InputMismatchException e) {
                System.out.println("Pogresan unos za simbol. Unesi ponovo.");
                input.next();
                i--;
                continue;
            }
            if (symbol >= 0 && symbol < 6) {
                combination[i] = SkockoSymbols.getByValue(symbol);
            } else {
                System.out.println("Pogresan broj za simbol. Unesi ponovo.");
                i--;
            }
        }
    }
    
    private void printWuningCombination() {
        System.out.println("Trazena kombinacija:");
        graphics.printCombination(game.getWiningCombination());
    }
    
    private boolean askUserToRestartGame() {
        System.out.println("Da li zelite ponovo da igrate?");
        System.out.println("Unesite \"true\" ili \"false\"");
        boolean restart;
        while(true) {
            try {
                restart = input.nextBoolean();
                break;
            } catch(InputMismatchException e) {
                System.out.println("Pogresan unos. Unestite \"true\" ili \"false\"");
                input.next();
            }
        }
        return restart;
    }
    
    private void clearScreen() {  
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------"); 
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}
