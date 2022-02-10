import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("hello from try");
            throw new RuntimeException("failed");
        } catch (Exception e) {
            System.out.println(String.format("hello from catch {}", e.getMessage()));
        }
    }


    public static List<Integer> getIdealDays(int[] day, int k) {
        int length = day.length;
        int[] left = new int[length];
        int[] right = new int[length];
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i < length; i++)
            if (day[i - 1] >= day[i]) {
                left[i] = left[i - 1] + 1;
            }

        for (int i = length - 2; i >= 0; i--)
            if (day[i + 1] >= day[i])
                right[i] = right[i + 1] + 1;


        for (int i = 0; i < length; i++)
            if (left[i] >= k && right[i] >= k)
                res.add(i + 1);

        return res;
    }


    public static int getServedBuildings(List<Integer> buildingCount, List<Integer> routerLocation, List<Integer> routerRange) {
        int[] answer = new int[buildingCount.size()];
        for (int i = 0; i < routerLocation.size(); i++) {
            int buildingIndex = routerLocation.get(i) - 1;
            int routerRangeIndex = routerRange.get(i);
            int startPoint = buildingIndex - routerRangeIndex;
            int endPoint = buildingIndex + routerRangeIndex;
            answer[Math.max(startPoint, 0)]++;
            if (endPoint < buildingCount.size() - 1)
                answer[Math.min(endPoint, buildingCount.size() - 1) + 1]--;
        }
        for (int i = 1; i < answer.length; i++)
            answer[i] += answer[i - 1];

        int countAnswer = 0;

        for (int i = 0; i < answer.length; i++)
            if (answer[i] >= buildingCount.get(i))
                countAnswer++;

        return countAnswer;
    }
}
