package ee.bcs.valiit.tasks;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {

    public static void main(String[] args) {
        System.out.println(evenFibonacci(5));

    }
    public static int evenFibonacci(int n){
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
            if(n==0){
                return 0;
            }else if(n==1) {
                return 1;
            }else{
                int a = 0;
                int b = 1;
                for(int i = 1; i < n; i++) {
                    int tmp = a;
                    a = b + tmp;
                }
                return b;
            }
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
