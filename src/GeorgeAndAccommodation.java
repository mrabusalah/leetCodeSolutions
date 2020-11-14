import java.util.Scanner;

public class GeorgeAndAccommodation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int cnt = 0;
        while (tc-- > 0) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            if (q - p >= 2)
                cnt++;
        }
        System.out.println(cnt);
    }
}
