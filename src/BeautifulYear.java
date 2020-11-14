import java.util.Arrays;
import java.util.Scanner;

public class BeautifulYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        year++;
        while (true) {
            if (isBeautifulYear(year)) {
                break;
            }
            year++;
        }
        System.out.println(year);
    }

    private static boolean isBeautifulYear(int year) {
        String s = String.valueOf(year);
        char[] chArr = s.toCharArray();
        Arrays.sort(chArr);
        for (int i = 1; i < 4; i++) {
            if (chArr[i] == chArr[i - 1])
                return false;
        }
        return true;
    }
}
