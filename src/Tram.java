import java.util.Scanner;

public class Tram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int sum = 0;
        int ans = 0;
        while (tc-- > 0) {
            int out = sc.nextInt();
            int in = sc.nextInt();
            sum -= out;
            sum += in;
            ans = Math.max(sum, ans);
        }
        System.out.println(ans);
    }
}
