import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Suborrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            arrayList.add(x);
        }
        Collections.sort(arrayList);
        System.out.println((int) Math.ceil((n - 2) / 2d));
        int left = 0, right = n - 1;
        int count = 0;
        while (count != n) {
            System.out.print(arrayList.get(right) + " ");
            count++;
            if (count == n) break;
            System.out.print(arrayList.get(left) + " ");
            count++;
            left++;
            right--;
        }
    }
}
