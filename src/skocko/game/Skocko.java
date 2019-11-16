/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skocko.game;

/**
 *
 * @author Filip
 */
public class Skocko {
    
    private final SkockoSymbols[] combination;
    
    private Skocko() {
        combination = new SkockoSymbols[4];
        generateNewCombination();
    }
    
    private void generateNewCombination() {
        for (int i = 0; i < combination.length; i++) {
            int random = (int) (Math.random() * 4);
            combination[i] = SkockoSymbols.getByValue(random);
        }
    }
    
    public static Skocko getNewGame() {
        return new Skocko();
    }
    
    public boolean isWiningCombination(SkockoSymbols[] combination) {
        for (int i = 0; i < combination.length; i++) {
            if (combination[i] != this.combination[i]) {
                return false;
            }
        }
        return true;
    }
    
    public int getNumOfCorrectlyPlacedSymbols(SkockoSymbols[] combination) {
        int num = 0;
        for (int i = 0; i < combination.length; i++) {
            if (combination[i] == this.combination[i]) {
                num++;
            }
        }
        return num;
    }
    
    public int getNumOfWronglyPlacedSymbols(SkockoSymbols[] combination) {
        int num = 0;
        boolean[] checkedMy = new boolean[4];
        boolean[] checkedWin = new boolean[4];
        for (int i = 0; i < combination.length; i++) {
            if (combination[i] == this.combination[i]) {
                checkedMy[i] = true;
                checkedWin[i] = true;
            }
        }
        for (int i = 0; i < combination.length; i++) {
            if (checkedMy[i]) continue;
            for (int j = 0; j < this.combination.length; j++) {
                if (checkedWin[j]) continue;
                if (combination[i] == this.combination[j]) {
                    num++;
                    checkedWin[j] = true;
                    break;
                }
            }
        }
        return num;
    }
    
    public SkockoSymbols[] getWiningCombination() {
        return combination;
    }
}
