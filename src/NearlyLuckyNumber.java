import java.util.Scanner;

public class NearlyLuckyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '7' || s.charAt(i) == '4') {
                cnt++;
            }
        }
        System.out.println(cnt == 7 || cnt == 4 ? "YES" : "NO");
    }
}
