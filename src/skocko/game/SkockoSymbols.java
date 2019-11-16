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
public enum SkockoSymbols {
    Skocko(0), List(1), Detelina(2), Srce(3), Karo(4), Zvezda(5);
    
    private int value;
    
    private SkockoSymbols(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public static SkockoSymbols getByValue(int value) {
        for(SkockoSymbols s : values()) {
            if(s.getValue() == value) {
                return s;
            }
        }
        throw new Error("Cant fined SkockoSymbols for thet value");
    }
}
