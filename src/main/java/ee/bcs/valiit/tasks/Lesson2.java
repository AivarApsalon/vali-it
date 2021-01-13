package ee.bcs.valiit.tasks;

import java.util.Scanner;

public class Lesson2 {

    public static void main(String[] args) {
        exercise5(100, 200);

    }

    // TODO loo 10 elemendile täisarvude massiv
    // TODO loe sisse konsoolist 10 täisarvu
    // TODO trüki arvud välja vastupidises järiekorras
    public static void exercise1() {
        int[] numbers = new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Sisesta number");
        }
        for (int i = numbers.length; i > 0; i--) {
            System.out.println(numbers[i - 1]);
        }
    }


    // TODO prindi välja x esimest paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    public static void exercise2(int x) {
        int evenCount = 0;
        int number = 1;
        while (evenCount < x) {
            if (number % 2 == 0) {
                evenCount++;
                System.out.println(number);
            }
            number++;
        }
    }

    // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
    // TODO näiteks x = 3 y = 3
    // TODO väljund
    // 1 2 3
    // 2 4 6
    // 3 6 9
    // TODO 1 trüki korrutustabeli esimene rida (numbrid 1 - x)
    // TODO 2 lisa + " " print funktsiooni ja kasuta print mitte println
    // TODO 3 trüki seda sama rida y korda
    // TODO 4 Kuskile võiks kirjutada System.out.println(),
    //  et saada taebli kuju
    // TODO 5 võrdle ridu. Kas on mingi seaduspärasus ridade vahel,
    // mis on ja mis võiks olla. Äkki tuleb mõni idee
    public static void exercise3(int x, int y) {
        for (int i = 0; i < y; i++) {
            for (int j = 1; j <= x; j++) {
                System.out.print((j * (i + 1) + " "));
            }
            System.out.println();
        }
    }

    // TODO
    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Tagasta fibonacci jada n element
    public static int exercise4(int n) {
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
            }

        }
        return fNumber;
    }

    public static void exercise5(int i, int j) {
        // https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=36
        // TODO 1 (tee alamfunktsioon) mis leiab 3n+1 sequenci pikkuse
        // kui on paaris / 2 kui on paaritu *3+1
        // TODO 2 tee tsükkel mis leiab i -> j kõige suurema tsükkli pikkuse
        int longestSq = 1;
        int start = i;
        int end = j;
        while (i <= j) {
            int num = sequence(i);
            if (num > longestSq)
                longestSq = num;
            i++;
        }
        System.out.println(start + " " + j + " " + longestSq);
    }

    public static int sequence(int n) {
        int count = 1;
        if (n == 1) return count;

        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
                count++;
            } else {
                n = n * 3 + 1;
                count++;
            }
        }

        return count;
    }

//Uus ülesanne

    public static int exercise6(int N) {
        Integer[] numbers = {1, 2, 7, 4};
        int size = numbers.length - 1;
        if (size < N) {
            return -1;
        } else {
            return (int) Math.pow(numbers[N], N);
        }
    }

//Uus ülesanne

    public static String exercise7(String string) {
        String[] arr = string.split(" ");
        StringBuffer stringbuffer = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
            stringbuffer.append(Character.toUpperCase(arr[i].charAt(0))).append(arr[i].substring(1)).append(" ");
        }
        return stringbuffer.toString().trim();
    }

// Uus ülesanne

    public static String exercise8(String string) {
        String[] n = string.split("_");
        StringBuffer stringbuffer = new StringBuffer();

        for (int i = 0; i < n.length; i++) {
            stringbuffer.append(Character.toUpperCase(n[i].charAt(0))).append(n[i].substring(1)).append("");
        }
        return stringbuffer.toString().trim();
    }

}



