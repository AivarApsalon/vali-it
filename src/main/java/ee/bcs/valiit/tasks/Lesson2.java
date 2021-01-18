package ee.bcs.valiit.tasks;

import com.sun.jdi.IntegerValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lesson2 {

    public static void main(String[] args) {
        int[] a = {1, 1, 3, 3, 7, 2, 2, 2, 2};
        int[] arr = {15,11,10,7,12};
        System.out.println(Arrays.toString(solve(arr)));

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
    public static int Fibonacci(int n) {
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

    //  Uus ülesanne (codeWars 8-1)
    //  array = [1, 2, 3, 4] and N = 2, then the result is (3 astmel 2) == 9;
    //  array = [1, 2, 3] and N = 3, but N is outside of the array, so the result is -1

    public static int exercise6(int N) {
        Integer[] numbers = {1, 2, 7, 4};
        int size = numbers.length - 1;
        if (size < N) {
            return -1;
        } else {
            return (int) Math.pow(numbers[N], N);
        }
    }


    // Uus ülesanne (codeWars 8-2)
    public static int howOld(String herOld) {
        String stringAnswer = herOld.substring(0, 1);
        int intAnswer = Integer.parseInt(stringAnswer);
        return intAnswer;
    }


    // Uus ülesanne (codeWars 8-3)
    // Given a non-negative integer n, write a function to_binary/ToBinary which returns
    // that number in a binary format.
    // to_binary(1)  /* should return 1 */
    // to_binary(5)  /* should return 101 */
    // to_binary(11) /* should return 1011 */
    public static int numberInBinary(int n) {
        String number = String.format(Integer.toBinaryString(n));
        n = Integer.parseInt(number);

        return n;
    }

    // Uus ülesanne (codeWars 8-4)
    // Your task is to sum the differences between consecutive pairs
    //   in the array in descending order.
    // For example: sumOfDifferences([2, 1, 10])
    // Returns 9
    // Descending order: [10, 2, 1]
    // Sum: (10 - 2) + (2 - 1) = 8 + 1 = 9
    // If the array is empty or the array has only one element the result
    //   should be 0 (Nothing in Haskell).

    public static int sumOfDifferences(int[] arr) {
        int size = arr.length;
        int sum = 0;
        int newSize = arr.length;
        int maxNumber;
        if (newSize == 0) {
            sum = 0;
        } else {
            maxNumber = arr[0];
            int indeks = 0;
            int[] newSort = new int[size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (maxNumber < arr[j]) {
                        maxNumber = arr[j];
                        indeks = j;
                    }
                }
                arr[indeks] = Integer.MIN_VALUE;
                newSort[i] = maxNumber;
                maxNumber = Integer.MIN_VALUE;
            }

            for (int s = 0; s < newSize - 1; s++) {
                sum = sum + (newSort[s] - newSort[s + 1]);
            }
        }
        return sum;
    }


    //Uus ülesanne (codeWars 7-1)
    //Input: "How can mirrors be real if our eyes aren't real"
    //Output: "How Can Mirrors Be Real If Our Eyes Aren't Real"
    public static String exercise7(String string) {
        String[] words = string.split(" ");
        String answer = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toString();
            String newString = word.substring(0, 1).toUpperCase() + word.substring(1);
            answer = answer + " " + newString;
        }

        return answer;
    }


    //Uus ülesanne (codeWars 7-2)
    //Red Knight is chasing two pawns. Which pawn will be caught, and where?


    //Uus ülesanne (codeWars 7-3)
    //In this Kata, you will be given an array of unique elements, and your task is to rearrange
    // the values so that the first max value is followed by the first minimum, followed by second
    // max value then second min value, etc.
    // solve([15,11,10,7,12]) = [15,7,12,10,11]
    public static int[] solve(int[] arr) {
        int size = arr.length;
        int maxNumber = arr[0];
        int indeks = 0;
        int[] newSort = new int[size];
        int[] newSort2 = new int[size];
        int[] newSort3 = new int[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (maxNumber < arr[j]) {
                    maxNumber = arr[j];
                    indeks = j;
                }
            }
            arr[indeks] = Integer.MIN_VALUE;
            newSort[i] = maxNumber;
            maxNumber = Integer.MIN_VALUE;
        }

        int lisa = 0;
        int lisa2 = 1;
        int lisa3 = 0;
        for(int u = 0; u <(size/2); u++){
            newSort3[lisa] = newSort[u];
            newSort3[lisa2] = newSort[(size-1)-lisa3];
            lisa = lisa + 2;
            lisa2 = lisa2 + 2;
            lisa3 = lisa3 + 1;
        }
        newSort3[size-1] = newSort[size/2];
        return newSort3;
    }


    // Uus ülesanne (codeWars 6-1)
    //toCamelCase(the-stealth-warrior"); // returns "theStealthWarrior"
    //toCamelCase("The_Stealth_Warrior"); // returns "TheStealthWarrior"
    public static String exercise8(String string) {
        String[] words = string.replace("_", "-").split("-");
        String answer = "";
        for (int i = 1; i < words.length; i++) {
            String word = words[i].toString();
            String newString = word.substring(0, 1).toUpperCase() + word.substring(1);
            answer = answer + newString;
        }
        return words[0].toString() + answer;
    }


    // Uus ülesanne (codeWars 6-2)
    //Given a list lst and a number N, create a new list that contains each number of lst at
    // most N times without reordering. For example if N = 2, and the input is [1,2,3,1,2,1,2,3],
    // you take [1,2,3,1,2], drop the next [1,2] since this would lead to 1 and 2 being in the
    // result 3 times, and then take 3, which leads to [1,2,3,1,2,3].

    // EnoughIsEnough.deleteNth(new int[] {20,37,20,21}, 1) // return [20,37,21]
    // EnoughIsEnough.deleteNth(new int[] {1,1,3,3,7,2,2,2,2}, 3) // return [1, 1, 3, 3, 7, 2, 2, 2]

    public static int[] deleteNth(int[] a, int n) {
        int size = a.length;
        int minNumber = a[0];
        int maxNumber = a[0];
        for (int i = 0; i < size; i++) {
            if (maxNumber < a[i]) {
                maxNumber = a[i];
            }
        }
        for (int i = 0; i < size; i++) {
            if (minNumber > a[i]) {
                minNumber = a[i];
            }
        }
        int indeks = 0;
        int[] newSort = new int[size];

        for (int i = minNumber; i <= maxNumber; i++) {
            for (int j = 0; j < size; j++) {

                if (maxNumber < a[j]) {
                    maxNumber = a[j];
                    indeks = j;
                }
            }
            a[indeks] = Integer.MIN_VALUE;
            newSort[i] = maxNumber;
            maxNumber = Integer.MIN_VALUE;
        }

        return null;
    }
}

