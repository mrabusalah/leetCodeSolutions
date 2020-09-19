import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (n-- > 0) {
                int value = scanner.nextInt();
                arrayList.add(value);
            }
            Collections.sort(arrayList);
            int size = arrayList.size();
            System.out.println((arrayList.get(0).equals(arrayList.get(size - 1))) ? arrayList.size() : 1);
        }
    }
}
