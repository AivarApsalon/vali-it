package ee.bcs.valiit.tasks;

public class Lesson1MathUtil {
    private String test;

    // TODO kirjuta ise (if/else) ära kasuta java.lang.Math
    public Lesson1MathUtil(String test) {
        this.test = test;
    }

    public static void main(String[] args) {
        System.out.println(min(2, 2, 5));

    }

    // TODO tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a ja b suurim väärtus
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a absoluut arv
    public static int abs(int a) {
        if(a>=0){
            return a;
        }else{
            return -a;
        }
    }

    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        if (a % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // TODO tagasta kolmest arvust kõige väiksem
    public static int min(int a, int b, int c) {
        int minNumber;
        if(a<=b && a<=c) {
            minNumber = a;
        }else if(b<=c && b<=a) {
            minNumber = b;
        }else{
            minNumber = c;
        }
        return minNumber;
    }

    // TODO tagasta kolmest arvust kõige suurem
    public static int max(int a, int b, int c) {
        int maxNumber;
        if (a >= b && a >= c) {
            maxNumber = a;
        } else if (b >= c && b >= a) {
            maxNumber = b;
        } else {
            maxNumber = c;
        }
        return maxNumber;
    }
}
