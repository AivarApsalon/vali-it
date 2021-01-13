package ee.bcs.valiit.tasks;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {

    public static void main(String[] args) {
        randomGame();

    }
    public static int evenFibonacci(int n) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        int sum = 0;
        int fNumber;
        if (n == 2 || n == 3) {
            fNumber = 1;
        } else if (n != 1) {
            int num1 = 0;
            int num2 = 1;
            int i = 2;
            while (i < n) {
                fNumber = num1 + num2;
                num1 = num2;
                num2 = fNumber;
                System.out.println(fNumber);
                i++;
                if(fNumber % 2 == 0){
                    sum = sum + fNumber;
                }
            }
        }
        return sum;
    }





    public static void randomGame(){
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
            while(!hasWon){
                count++;
                int guess = scanner.nextInt();
                if (i < guess) {
                    System.out.println("Number on väiksem kui " + guess + ".");
                }
                if (i > guess) {
                    System.out.println("Number on suurem kui " + guess + ".");
                }if (i == guess){
                    hasWon=true;
                }
            }
                  System.out.println("ÕIGE!");
                  System.out.println("Sul kulus äraarvamiseks " + count + " katset.");
              }




    public static String morseCode(String text){
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja -
        return "";
    }
}
