import java.util.Scanner;

public class SoldierAndBananas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int m = sc.nextInt();
        int w = sc.nextInt();
        System.out.println((((w * (w + 1)) / 2) * k) - m > 0 ? (((w * (w + 1)) / 2) * k) - m : 0);
    }
}
