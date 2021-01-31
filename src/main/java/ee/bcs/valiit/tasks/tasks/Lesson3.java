package ee.bcs.valiit.tasks.tasks;

import java.util.Arrays;

public class Lesson3 {
    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5};
        int[] a = {6, 2, 9, 3, 7};
        System.out.println(sumArray(x));
    }

    public static int sumArray(int[] x) {
        // Todo liida kokku kõik numbrid massivis x
        int size = x.length;
        int i = 0;
        int sum = 0;
        for (i = 0; i < size; i++) {
            sum = sum + x[i];
        }
        return sum;
    }

    public static int factorial(int x) {
        // TODO tagasta x faktoriaal.
        // Näiteks
        // x = 5
        // return 5*4*3*2*1 = 120
        int sum = 1;
        int i = 0;
        while (i < x) {
            int num = i + 1;
            sum = sum * num;
            i++;
        }
        return sum;
    }

    public static int[] sort(int[] a) {
        // TODO sorteeri massiiv suuruse järgi.
        // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni

        int size = a.length;
        int maxNumber = a[0];
        int indeks = 0;
        int[] newSort = new int[size];
        for (int i = 0; i < size; i++) {
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

        return newSort;
    }

//Uus ülesanne

    public static String reverseString(String a) {
        // TODO tagasta string tagurpidi
        String newString = "";
        int size = a.length() - 1;
        while (size >= 0) {
            char newChar = a.charAt(size);
            newString = newString + newChar;
            size--;
        }
        return newString;
    }


    public static boolean isPrime(int x) {
        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
        for (int divisor = 2; divisor < x; divisor++) {
            if (x != divisor && x % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}
