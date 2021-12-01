import java.util.ArrayList;
import java.util.Scanner;

public class OOP {
    final static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter the number of elements :");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("enter the element value : ");
            arr.add(sc.nextInt());
        }
    }

    public Double getAvg() {
        double ans = 0;
        for (int i = 0; i < arr.size(); i++) {
            ans += arr.get(0);
        }
        return ans / arr.size();
    }
}
