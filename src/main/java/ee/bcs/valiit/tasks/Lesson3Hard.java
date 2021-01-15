package ee.bcs.valiit.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {

    public static void main(String[] args) {
        randomGame();

    }

    public static int evenFibonacci(int n) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        int sum = 0;
        int fNumber = 0;
        if (n == 1) {
            fNumber = 0;
        } else if (n == 2 || n == 3) {
            fNumber = 1;
        } else {
            int num1 = 0;
            int num2 = 1;
            int i = 2;
            while (i < n) {
                fNumber = num1 + num2;
                num1 = num2;
                num2 = fNumber;
                i++;
                if (fNumber % 2 == 0) {
                    sum = sum + fNumber;
                }

            }

        }
        return sum;
    }

    public static void randomGame() {
        // TODO kirjuta mäng mis võtab suvalise numbri 0-100, mille kasutaja peab ära arvama
        // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
        // ja kasutaja peab saama uuesti arvata
        // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
        Random random = new Random();
        int i = random.nextInt(100);

        System.out.println("Olen suvaline number 1-st kuni 100-ni");
        System.out.println("Arva mind ära!");
        boolean hasWon = false;
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (!hasWon) {
            count++;
            int guess = scanner.nextInt();
            if (i < guess) {
                System.out.println("Number on väiksem kui " + guess + ".");
            }
            if (i > guess) {
                System.out.println("Number on suurem kui " + guess + ".");
            }
            if (i == guess) {
                hasWon = true;
            }
        }
        System.out.println("ÕIGE!");
        System.out.println("Sul kulus äraarvamiseks " + count + " katset.");
    }


    public static String morseCode(String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja -
        String editedText = text.toLowerCase();
        int size = editedText.length();
        String newString = "";
        Map<String, String> morse = new HashMap<>();
        morse.put("a", ".-");
        morse.put("b", "-...");
        morse.put("c", "-.-.");
        morse.put("d", "-..");
        morse.put("e", ".");
        morse.put("f", "..-.");
        morse.put("g", "--.");
        morse.put("h", "....");
        morse.put("i", "..");
        morse.put("j", ".---");
        morse.put("k", "-.-");
        morse.put("l", ".-..");
        morse.put("m", "--");
        morse.put("n", "-.");
        morse.put("o", "---");
        morse.put("p", ".--.");
        morse.put("r", ".-.");
        morse.put("s", "...");
        morse.put("t", "-");
        morse.put("u", "..-");
        morse.put("v", "...-");
        morse.put("w", ".--");
        morse.put("x", "-..-");
        morse.put("y", "-.--");
        morse.put("z", "--..");

        for (int i = 0; i < size; i++) {
            char newChar = editedText.charAt(i);
            String letter = String.valueOf(newChar);
            newString = newString + morse.get(letter);
        }
        return newString;
    }
}
