/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skocko.game;

import java.util.ArrayList;

/**
 *
 * @author Filip
 */
public class SkockoGraphics {
    
    private final static int SYMOLS_HIGHT = 12;
    
    private final String[] zvezda = new String[] {"             *                ",
                                                  "            ***               ",
                                                  "           *****              ",
                                                  "          *******             ",
                                                  "'****************************'",
                                                  "    `********************`    ",
                                                  "      `***************`       ",
                                                  "        *************         ",
                                                  "       ******' '******        ",
                                                  "      *****'     '*****       ",
                                                  "     ***'           '***      ",
                                                  "    *'                 '*     "};
    
    private final String[] skocko = new String[] {"                 ",
                                                  "    .-'\"\"\"'-.    ",
                                                  "  .'         '.  ",
                                                  " /   ()   ()   \\ ",
                                                  ";               ;",
                                                  "; :.         .; ;",
                                                  " \\'.'-.....-'.'/ ",
                                                  "  '.'.-.-,_.'.'  ",
                                                  "    '(  (..-'    ",
                                                  "      '-'        ",
                                                  "                 ",
                                                  "                 "};
    
    private final String[] detelina = new String[] {"                   ",
                                                    "       ****        ",
                                                    "     ********      ",
                                                    "     ********      ",
                                                    "      ******       ",
                                                    " ****  ****  ****  ",
                                                    "*******************",
                                                    "*******************",
                                                    "  ****  **   ****  ",
                                                    "       ****        ",
                                                    "     ********      ",
                                                    "                   ",
                                                    "                   "};
    
    private final String[] list = new String[] {"                 ",
                                                "        *        ",
                                                "       ***       ",
                                                "      *****      ",
                                                "    *********    ",
                                                "  *************  ",
                                                "*****************",
                                                "*****************",
                                                "  **** **  ****  ",
                                                "      ****       ",
                                                "    ********     ",
                                                "                 "};
    
    private final String[] srce = new String[] {"                 ",
                                                "                 ",
                                                " ******   ****** ",
                                                "******** ********",
                                                " *************** ",
                                                "  *************  ",
                                                "    *********    ",
                                                "      *****      ",
                                                "       ***       ",
                                                "        *        ",
                                                "                 ",
                                                "                 "};
    
    private final String[] karo = new String[] {"     *     ",
                                                "    ***    ",
                                                "   *****   ",
                                                "  *******  ",
                                                " ********* ",
                                                "***********",
                                                " ********* ",
                                                "  *******  ",
                                                "   *****   ",
                                                "    ***    ",
                                                "     *     ",
                                                "           "};
    
    private final String[] space = new String[] {"     ",
                                                 "     ",
                                                 "     ",
                                                 "     ",
                                                 "     ",
                                                 "     ",
                                                 "     ",
                                                 "     ",
                                                 "     ",
                                                 "     ",
                                                 "     ",
                                                 "     "};
    
    private final String title = " .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------. \n" +
"| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\n" +
"| |    _______   | || |  ___  ____   | || |     ____     | || |     ______   | || |  ___  ____   | || |     ____     | |\n" +
"| |   /  ___  |  | || | |_  ||_  _|  | || |   .'    `.   | || |   .' ___  |  | || | |_  ||_  _|  | || |   .'    `.   | |\n" +
"| |  |  (__ \\_|  | || |   | |_/ /    | || |  /  .--.  \\  | || |  / .'   \\_|  | || |   | |_/ /    | || |  /  .--.  \\  | |\n" +
"| |   '.___`-.   | || |   |  __'.    | || |  | |    | |  | || |  | |         | || |   |  __'.    | || |  | |    | |  | |\n" +
"| |  |`\\____) |  | || |  _| |  \\ \\_  | || |  \\  `--'  /  | || |  \\ `.___.'\\  | || |  _| |  \\ \\_  | || |  \\  `--'  /  | |\n" +
"| |  |_______.'  | || | |____||____| | || |   `.____.'   | || |   `._____.'  | || | |____||____| | || |   `.____.'   | |\n" +
"| |              | || |              | || |              | || |              | || |              | || |              | |\n" +
"| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\n" +
" '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------' ";
    
    private final String autor = "  _               ___   _   _   _            __  __   _   _                 _         \n" +
" | |__   _  _    | __| (_) | | (_)  _ __    |  \\/  | (_) | |  __ _   _ _   | |__  ___ \n" +
" | '_ \\ | || |   | _|  | | | | | | | '_ \\   | |\\/| | | | | | / _` | | ' \\  | / / / _ \\\n" +
" |_.__/  \\_, |   |_|   |_| |_| |_| | .__/   |_|  |_| |_| |_| \\__,_| |_||_| |_\\_\\ \\___/\n" +
"         |__/                      |_|                                                ";
    
    public void printCombination(SkockoSymbols[] combination) {
        ArrayList<String[]> combinationGraphics = new ArrayList<>();
        for(int i = 0; i < combination.length; i++) {
            combinationGraphics.add(space); 
            combinationGraphics.add(getSymbolGraphic(combination[i])); 
        }
        for(int i = 0; i < SYMOLS_HIGHT; i++) {
            for(int j = 0; j < combinationGraphics.size(); j++) {
                System.out.print(combinationGraphics.get(j)[i]);
            }
            System.out.println();
        }
    }
    
    public void printIntro() {
        System.out.println(title);
        System.out.println(autor);
        System.out.print("\n\n");
    }
    private String[] getSymbolGraphic(SkockoSymbols symbol) {
        switch(symbol) {
            case Zvezda:
                return zvezda;
            case Skocko:
                return skocko;
            case Detelina:
                return detelina;
            case List:
                return list;
            case Srce:
                return srce;
            case Karo:
                return karo;
            default:
                throw new Error("Unknown skocko symbol");
        }
    }
}
