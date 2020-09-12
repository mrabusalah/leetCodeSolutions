import java.util.Scanner;

import static java.lang.Math.log10;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int length = (int) log10(n) + 1;
        System.out.println("length of " + n + " is = " + length);
        int power = getPower(length - 1);
        for (int i = 0; i < length; i++) {
            System.out.println("FD = " + n / (length * ));
            n %= length * i;
        }
        System.out.println("YES");

    }

    private static int getPower(int length) {
        int tmp = 1;
        for (int i = 0; i < length; i++) {
            tmp *= 10;
        }
        return tmp;
    }
}
