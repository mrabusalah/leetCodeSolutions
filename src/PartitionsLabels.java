import java.util.ArrayList;
import java.util.List;

public class PartitionsLabels {
    public static void main(String[] args) {
        System.out.println(partitionLabels("eccbbbbdec"));
    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> answer = new ArrayList<>();
        int len = s.length();
        int maxIdx = Integer.MIN_VALUE;
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int lastIndexOf = s.lastIndexOf(s.charAt(i));
            if (i > maxIdx && i != 0) {
                answer.add(tmp.length());
                tmp = new StringBuilder();
            }
            maxIdx = Math.max(maxIdx, lastIndexOf);
            tmp.append(s.charAt(i));
        }
        answer.add(tmp.length());
        return answer;
    }
}
